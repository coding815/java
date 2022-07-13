package com.junit.test.file;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;

public class FileOutputStreamTest {

	@Test
	public void test() {
		File file = new File("D:/eclipse/workspace/temp/FileOutputStream.txt");
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file, false);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
