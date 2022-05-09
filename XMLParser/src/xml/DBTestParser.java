package xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DBTestParser {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		// XML ���� �Ľ�
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse("src/xml/DBTest.xml");
		
		// root ���ϱ�
		Element root = document.getDocumentElement();
		
		// root�� �Ӽ�
		System.out.println("root name: " + root.getAttribute("name"));
		System.out.println("\n");

		NodeList children = root.getChildNodes();	// �ڽ� ��� ��� get
		
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {	// �ش� ����� ���� ���� (Element�� ��)
				// �ڽ� ���(depth 1) - ���̺� ���
				Element element = (Element) node;
				String nodeName = element.getNodeName();
				System.out.println("node name: " + nodeName);
				if (nodeName.equals("table")) {
					System.out.println("table: " + element.getAttribute("name"));
					// �̸��� student�� ���� �ڽĳ�尡 �� ������
					NodeList children2 = element.getChildNodes();
					for (int j = 0; j < children2.getLength(); j++) {
						// �ڽ� ���(depth 2) - SQL ��� (date: ��¥, author: �ۼ���)
						Node node2 = children2.item(j);
						if (node2.getNodeType() == Node.ELEMENT_NODE) {
							Element element2 = (Element) node2;
							String nodeName2 = element2.getNodeName();
							System.out.println(nodeName2 + " date: " + element2.getAttribute("date"));
							System.out.println(nodeName2 + " author: " + element2.getAttribute("author"));
							System.out.println(nodeName2 + " content: " + element2.getTextContent().trim());

//							NodeList children3 = element2.getChildNodes();
//							for (int k = 0; k < children3.getLength(); k++) {
//								Node node3 = children3.item(k);
//								if (node3.getNodeType() == Node.ELEMENT_NODE) {
//									Element element3 = (Element) node3;
//									String nodeName3 = element3.getNodeName();
//									System.out.println("node " + nodeName3 + ": " + element3.getAttribute("score"));
//								}
//							}
						}	
						System.out.println("\n");
					}
				}
			}
		}
	}
}
