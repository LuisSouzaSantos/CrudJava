package br.com.ftt.ec6.crud.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {

	public static List<String> accessFile(String fileName) throws IOException {
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
	
}
