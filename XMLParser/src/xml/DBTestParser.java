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

		// XML 문서 파싱
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse("src/xml/DBTest.xml");
		
		// root 구하기
		Element root = document.getDocumentElement();
		
		// root의 속성
		System.out.println("root name: " + root.getAttribute("name"));
		System.out.println("\n");

		NodeList children = root.getChildNodes();	// 자식 노드 목록 get
		
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {	// 해당 노드의 종류 판정 (Element일 때)
				// 자식 노드(depth 1) - 테이블 목록
				Element element = (Element) node;
				String nodeName = element.getNodeName();
				System.out.println("node name: " + nodeName);
				if (nodeName.equals("table")) {
					System.out.println("table: " + element.getAttribute("name"));
					// 이름이 student인 노드는 자식노드가 더 존재함
					NodeList children2 = element.getChildNodes();
					for (int j = 0; j < children2.getLength(); j++) {
						// 자식 노드(depth 2) - SQL 목록 (date: 날짜, author: 작성자)
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
