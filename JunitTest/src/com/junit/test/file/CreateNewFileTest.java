package com.junit.test.file;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class CreateNewFileTest {

	@Test
	public void test() {
		File file = new File("D:/eclipse/workspace/temp/CreateNewFile.txt");
		
		try {
			if(file.createNewFile()) {
				System.out.println("File Created.");
			} else {
				System.out.println("File already exists");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
