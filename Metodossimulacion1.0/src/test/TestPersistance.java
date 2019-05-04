package test;

import java.io.IOException;

import persistence.FileManager;

public class TestPersistance {
	
	public static void main(String[] args) {
		FileManager fileManager = new FileManager();
		try {
			fileManager.print(fileManager.readFile());
		} catch (IOException e) {
			System.out.println(e);;
		}
	}

}
