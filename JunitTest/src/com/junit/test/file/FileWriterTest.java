package com.junit.test.file;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class FileWriterTest {

	@Test
	public void test() {
		String filePath = "D:/eclipse/workspace/temp/FileWriterTest.txt";
		
		try {
			FileWriter fw = new FileWriter(filePath, true);
			String lineToAppend = "The quick brown fox jumps over the lazy dog.\r\n";
			fw.write(lineToAppend);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
