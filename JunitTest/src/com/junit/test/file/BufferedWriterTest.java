package com.junit.test.file;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class BufferedWriterTest {

	@Test
	public void test() {
		String filePath = "D:/eclipse/workspace/temp/BufferedWriterTest.txt";
		
		try {
			FileWriter fw = new FileWriter(filePath, true);
			BufferedWriter bw = new BufferedWriter(fw);
			String lineToAppend = "The quick brown fox jumps over the lazy dog.\r\n";
			bw.write(lineToAppend);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
