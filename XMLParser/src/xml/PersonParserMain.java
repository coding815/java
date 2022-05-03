package xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class PersonParserMain {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		PersonParser personParser = new PersonParser();
		personParser.getXMLData("src/xml/Person.xml");
	}

}
