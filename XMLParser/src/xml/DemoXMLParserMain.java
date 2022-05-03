package xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class DemoXMLParserMain {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DemoXMLParser demoXMLParser = new DemoXMLParser();
		demoXMLParser.getXMLData("src/xml/Person.xml");
	}

}
