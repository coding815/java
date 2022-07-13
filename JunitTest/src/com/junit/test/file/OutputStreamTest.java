package com.junit.test.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Test;

public class OutputStreamTest {

	@Test
	public void test() {
		try {
			OutputStream output = new FileOutputStream("D:/eclipse/workspace/temp/Output.txt");
		    String str = "오늘 날씨는 아주 좋습니다.";
		    byte[] by = str.getBytes();
		    output.write(by);
		} catch (FileNotFoundException fe) {
			// TODO Auto-generated catch block
			fe.printStackTrace();
		} catch (IOException ie) {
			// TODO Auto-generated catch block
			ie.printStackTrace();
		}

	}

}
