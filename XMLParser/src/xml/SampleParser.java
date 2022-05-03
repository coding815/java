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

public class SampleParser {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		// XML 문서 파싱
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse("src/xml/Sample.xml");
		
		// root 구하기
		Element root = document.getDocumentElement();
		
		// root의 속성
		System.out.println("class name: " + root.getAttribute("name"));
		System.out.println("\n");

		NodeList children = root.getChildNodes();	// 자식 노드 목록 get
		
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {	// 해당 노드의 종류 판정 (Element일 때)
				Element element = (Element) node;
				String nodeName = element.getNodeName();
				System.out.println("node name: " + nodeName);
				if (nodeName.equals("teacher")) {
					System.out.println("node attribute: " + element.getAttribute("name"));
					System.out.println("\n");
				}
				else if (nodeName.equals("student")) {
					System.out.println("node attribute: " + element.getAttribute("name"));
					// 이름이 student인 노드는 자식노드가 더 존재함
					NodeList children2 = element.getChildNodes();
					for (int j = 0; j < children2.getLength(); j++) {
						Node node2 = children2.item(j);
						if (node2.getNodeType() == Node.ELEMENT_NODE) {
							Element element2 = (Element) node2;
							String nodeName2 = element2.getNodeName();
							System.out.println("node " + nodeName2 + ": " + element2.getAttribute("num"));
//							System.out.println("node name2: " + nodeName2);
//							System.out.println("node attribute2: " + element2.getAttribute("num"));
						}
					}
					System.out.println("\n");
				}
			}

		}
	}
}
