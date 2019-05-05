package persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {
	
	public List<String> readFile() throws IOException{
		List<String> listLines;
		listLines = Files.readAllLines(Paths.get("src/data/data.csv"));
		return listLines;		
	}
	
	public static String[] splitLine(String line, String separator){
		return line.split(separator);
	}
	
	public double toDouble(String line) {
		return Double.parseDouble(line);
	}
	
	public void print(List<String> listData) {
		for (int i = 0; i < listData.size(); i++) {
			if (listData.get(i) != null) {
				System.out.println(listData.get(i).toString());
			}
		}
	}
	
	public static String convert(String line){
		String aux2 ="";		
		String aux = line;
		for(int i=0; i<line.length(); i++){
			if(aux.charAt(i) == '$' && aux.charAt(i-1) !='$')
				aux2 += "$";
			if(aux.charAt(i) != '$')
				aux2 += aux.charAt(i);
			
		}
		return aux2;
	}
}