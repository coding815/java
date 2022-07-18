package dbmanager;

import java.io.File;
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

public class DBSchemaXMLParser {

	public DBSchemaModel parse(String path) throws ParserConfigurationException, SAXException, IOException {
		
		DBSchemaModel dbSchemaModel = new DBSchemaModel();
		List<DBSchemaTableDTO> dbSchemaTableList = new ArrayList<DBSchemaTableDTO>();
		List<DBSchemaSqlDTO> dbSchemaSqlList = new ArrayList<DBSchemaSqlDTO>();

		// XML 문서 파싱
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		
		// 상대 경로
		File xmlFile = new File(path);
		System.out.println("File Path : " + xmlFile.getAbsolutePath());
		if(!xmlFile.exists()) {
			System.out.println("File Not Found.");
			System.exit(1);
		}
				
		Document document = builder.parse(xmlFile.getAbsolutePath());
//		Document document = builder.parse(DBConnectConstants.DB_SCHEMA_LOCATION);
//		Document document = builder.parse("db_schema.xml");
		
		// root 구하기
		Element root = document.getDocumentElement();
//		int asisTableCount = root.getElementsByTagName("table").getLength(); // 테이블 갯수 확인
//		System.out.println("############ AS-IS TABLE COUNT: " + asisTableCount + " ##############\n");
//		dbSchemaModel.setDbTableCount(asisTableCount);
		
		System.out.println("############### CHECK QUERY START !!!!! ###############\n");
		
		// root의 속성
//		System.out.println("root name: " + root.getAttribute("name") + "\n");
		
		NodeList children = root.getChildNodes();	// 자식 노드 목록 get
		
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			
			if (node.getNodeType() == Node.ELEMENT_NODE) {	// 해당 노드의 종류 판정 (Element일 때)
				// 자식 노드(depth 1) - 테이블 목록
				Element element = (Element) node;
				String nodeName = element.getNodeName();
//				System.out.println("node name: " + nodeName);
								
				if (nodeName.equals("table")) {
//					System.out.println("table: " + element.getAttribute("name"));
					String tableName = element.getAttribute("name");
					
					DBSchemaTableDTO dbSchemaTableDTO = new DBSchemaTableDTO();
					dbSchemaTableDTO.setIndex(i);
					dbSchemaTableDTO.setName(tableName);
					dbSchemaTableList.add(dbSchemaTableDTO);
		
					// 자식 노드(depth 2) - SQL 목록 (date: 날짜, author: 작성자)
					NodeList children2 = element.getChildNodes();
					
					for (int j = 0; j < children2.getLength(); j++) {
						Node node2 = children2.item(j);
						
						if (node2.getNodeType() == Node.ELEMENT_NODE) {
							Element element2 = (Element) node2;
//							String nodeName2 = element2.getNodeName();
//							System.out.println(nodeName2 + " date: " + element2.getAttribute("date"));
//							System.out.println(nodeName2 + " author: " + element2.getAttribute("author"));
//							System.out.println(nodeName2 + " content: " + element2.getTextContent().trim());
							
							// 쿼리문 (내용)
							String date = element2.getAttribute("date");
							String author = element2.getAttribute("author");
							String textContent = element2.getTextContent().trim();
							String type = checkType(textContent);
							
							DBSchemaSqlDTO dbSchemaSqlDTO = new DBSchemaSqlDTO();
							dbSchemaSqlDTO.setIndex(i);
							dbSchemaSqlDTO.setDate(date);
							dbSchemaSqlDTO.setAuthor(author);
							dbSchemaSqlDTO.setTextContent(textContent);
							dbSchemaSqlDTO.setType(type);
							
							dbSchemaSqlList.add(dbSchemaSqlDTO);
						}	
					}
				}
			}
		}
		dbSchemaModel.setDbSchemaTableList(dbSchemaTableList);
		dbSchemaModel.setDbSchemaSqlList(dbSchemaSqlList);
		
		return dbSchemaModel;
	}

	private String checkType(String textContent) {
		String type = "";
		
		if (textContent.toUpperCase().contains(DBSchemaTypeEnum.CREATE.getValue())) {
			type = DBSchemaTypeEnum.CREATE.getValue();
		} else if (textContent.toUpperCase().contains(DBSchemaTypeEnum.ALTER.getValue())) {
			type = DBSchemaTypeEnum.ALTER.getValue();
		} else if (textContent.toUpperCase().contains(DBSchemaTypeEnum.INSERT.getValue())) {
			type = DBSchemaTypeEnum.INSERT.getValue();
		}
		
		return type;
	}
}
