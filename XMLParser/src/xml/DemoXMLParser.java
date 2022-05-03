package xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DemoXMLParser {
	
	public void getXMLData(String xmlFile) throws ParserConfigurationException, SAXException, IOException {
		
		// 1. ���� ���丮 ����
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		
		// 2. ���� ���丮�κ��� ���� ����
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		
		// 3. ������ ���� XML ������ �Ľ��ؼ� Document ��ü�� �����´�.
		Document document = builder.parse(xmlFile);
		
		// ���� ���� ����ȭ ?
		document.getDocumentElement().normalize();
		
		// XML ������ �� <person> �±��� ������ �����´�.
		NodeList personTagList = document.getElementsByTagName("person");
		
		// <person> �±� ����Ʈ�� �ϳ��� ���鼭 ������ �����´�.
		for (int i = 0; i < personTagList.getLength(); ++i) {
			// �Ӽ� �� ��������
			String name = personTagList.item(i).getAttributes().getNamedItem("sex").getNodeValue();
			
			// <person> �±��� ���� ������ �����´�. (���⼭ ���� �±׸� �ǹ��Ѵ�.)
			NodeList childNodes = personTagList.item(i).getChildNodes();
			for (int j = 0; j < childNodes.getLength(); ++j) {
				if ("name".equals(childNodes.item(j).getNodeName())) {
					System.out.println("name: " + childNodes.item(j).getNodeName());
				}
				
				if ("age".equals(childNodes.item(j).getNodeName())) {
					System.out.println("age: " + childNodes.item(j).getNodeName());
				}
			}
		}
		
	}
	
}
