package dbmanager;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public enum DBConnectInfoParser {
	INSTANCE;

	public void parseAndPut(File file) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse(file);

		Element rootElement = document.getDocumentElement();

		putDataSourceInfo(rootElement);
	}

	private void putDataSourceInfo(Element rootElement) {
		NodeList datasourcesNS = rootElement.getElementsByTagName("datasources");
		for (Node datasourcesN : convertList(datasourcesNS)) {
			for (Element datasourceE : getChild(datasourcesN)) {
				String pool_name = datasourceE.getAttribute("pool-name");
				if (!pool_name.equals("EPCDB-pool"))
					continue;

				String connectionUrl = getText(datasourceE, "connection-url");
				String dbAddr = connectionUrl.split(":")[2].replace("//", "");
				String dbPort = connectionUrl.split(":")[3].split("/")[0];
				String dbName = connectionUrl.split(":")[3].split("/")[1];

				String userName = getText(datasourceE, "user-name");
				String password = getText(datasourceE, "password");

				DBConnectConfig.INSTANCE.put(DBConnectConfig.Key.DB_HOST, dbAddr);
				DBConnectConfig.INSTANCE.put(DBConnectConfig.Key.DB_PORT, dbPort);
				DBConnectConfig.INSTANCE.put(DBConnectConfig.Key.DB_NAME, dbName);
				DBConnectConfig.INSTANCE.put(DBConnectConfig.Key.DB_USER, userName);
				DBConnectConfig.INSTANCE.put(DBConnectConfig.Key.DB_PWD, password);
			}
		}
	}

	private String getText(Element element, String tagName) {
		NodeList connectionUrlNS = element.getElementsByTagName(tagName);
		List<Node> nodes = convertList(connectionUrlNS);
		if (!nodes.isEmpty()) {
			return nodes.get(0).getTextContent();
		}
		return null;
	}

	private List<Element> getChild(Node node) {
		List<Element> list = new ArrayList<>();
		for (Node n : convertList(node.getChildNodes())) {
			if (n instanceof Element) {
				list.add((Element) n);
			}
		}
		return list;
	}

	private List<Node> convertList(NodeList nodeList) {
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			list.add(node);
		}
		return list;
	}
}
