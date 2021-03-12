package br.com.ftt.ec6.crud.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Database {

	public static List<String> readFile(String fileName) throws IOException {
		List<String> objectList = new ArrayList<String>();
		BufferedReader buffRead = new BufferedReader(new FileReader(fileName));
		String line = buffRead.readLine();
		
		while(line != null) {
			objectList.add(line);
			line = buffRead.readLine();
		}
		
		buffRead.close();
		return objectList;
	}
	
	public static String saveLine(String fileName, String content) {
		//File file = new File(fileName);
		PrintWriter printWriter = null;
		try {
			FileWriter fileWriter = new FileWriter(fileName, true);
			printWriter = new PrintWriter(fileWriter);
			printWriter.println(content);
			printWriter.flush();
			return "SUCCESS";
		} catch (IOException e) {
			return "ERROR";
		}finally {
			printWriter.close();
		}
	}
	
}
