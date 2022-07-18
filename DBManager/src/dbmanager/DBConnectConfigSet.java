package dbmanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class DBConnectConfigSet {

	/** 
	 * loadDBConnectConfig...
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public void loadDBConnectConfig() throws IOException, ParserConfigurationException, SAXException {
        File standaloneFile = getStandaloneFile();
        DBConnectInfoParser.INSTANCE.parseAndPut(standaloneFile);
    }

	public File getStandaloneFile() throws FileNotFoundException {
        String standaloneFilePath = getStandaloneFilePath();
        File standaloneFile = new File(standaloneFilePath);
        if (!standaloneFile.exists()) {
            throw new FileNotFoundException(standaloneFilePath + " is not found.");
        }
        return standaloneFile;
    }

	public String getStandaloneFilePath() {
        String userHome = System.getProperty("user.home");
        String configPath = DBConnectConstants.JBOSS_CONFIGURATION_PATH;
        String standaloneFile = DBConnectConstants.STANDALONE_NMF_FILE;
        return userHome + "/" + configPath + "/" + standaloneFile;
    }
}
