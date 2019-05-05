package test;

import java.io.IOException;
import java.util.ArrayList;

import controller.Controller;
import persistence.FileManager;

public class TestPersistance {
	
	public static void main(String[] args) {
		FileManager fileManager = new FileManager();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Double> doubleList = new ArrayList<Double>();
		
		try {
//			fileManager.print(fileManager.readFile());
			fileManager.readFile();
			for (int i = 0; i < fileManager.readFile().size(); i++) {
				list.add(fileManager.splitLine(fileManager.readFile().get(i), ",").toString());
			}
			for (int i = 0; i < list.size(); i++) {
//				doubleList.add(Double.parseDouble(list.get(i).toString()));
				System.out.println(list.get(i).toString());
			}
		} catch (IOException e) {
			System.out.println(e);;
		}
	}

}
