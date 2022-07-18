package DBManagerPreview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DBTableParser {

	public List<DBTableDTO> xmlParser() throws ParserConfigurationException, SAXException, IOException {
		
		List<DBTableDTO> dbTableList = new ArrayList<DBTableDTO>();

		// XML ���� �Ľ�
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		
		Document document = builder.parse("/home/zjeokwa/git/SKT_NMF/NmfServer/ERLGNmfServer/src/main/resources/db_schema.xml");
//		Document document = builder.parse("db_schema.xml");
		
		// root ���ϱ�
		Element root = document.getDocumentElement();
		
		// root�� �Ӽ�
//		System.out.println("root name: " + root.getAttribute("name"));
//		System.out.println("\n");

		NodeList children = root.getChildNodes();	// �ڽ� ��� ��� get
		
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {	// �ش� ����� ���� ���� (Element�� ��)
				// �ڽ� ���(depth 1) - ���̺� ���
				Element element = (Element) node;
				String nodeName = element.getNodeName();
//				System.out.println("node name: " + nodeName);
				
				DBTableDTO dbTableDTO = new DBTableDTO();
				
				if (nodeName.equals("table")) {
//					System.out.println("table: " + element.getAttribute("name"));
					String tableName = element.getAttribute("name");
					dbTableDTO.setName(tableName);
					
					// �ڽ� ���(depth 2) - SQL ��� (date: ��¥, author: �ۼ���)
					NodeList children2 = element.getChildNodes();
					for (int j = 0; j < children2.getLength(); j++) {
						Node node2 = children2.item(j);
						if (node2.getNodeType() == Node.ELEMENT_NODE) {
							Element element2 = (Element) node2;
//							String nodeName2 = element2.getNodeName();
//							System.out.println(nodeName2 + " date: " + element2.getAttribute("date"));
//							System.out.println(nodeName2 + " author: " + element2.getAttribute("author"));
//							System.out.println(nodeName2 + " content: " + element2.getTextContent().trim());
							
							String textContent = element2.getTextContent().trim();
							dbTableDTO.setQuery(textContent);
						}	
//						System.out.println("\n");
					}
				}
				dbTableList.add(dbTableDTO);
			}
		}
		
		return dbTableList;
	}
}
