package com.junit.test.file;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class FilesCreateFileTest {

	@Test
	public void test() {
		Path filePath = Paths.get("D:/eclipse/workspace/temp/FilesCreateFile.txt");
		
		try {
			Path newFilePath = Files.createFile(filePath);
			System.out.println(newFilePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
