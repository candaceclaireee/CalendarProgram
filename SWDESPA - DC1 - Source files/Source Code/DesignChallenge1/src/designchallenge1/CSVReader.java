package designchallenge1;

import java.util.*;
import java.io.*;

public class CSVReader extends DataReader {

	static ArrayList<String[]> lines = new ArrayList<String[]>();
	
	public void readData(){
		try {
			File f = new File("src\\SampleFiles\\PhilippineHolidays.csv");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
		
			String curLine = br.readLine();
			
			while(curLine != null) {
				
				String line[] = curLine.split(",");
				lines.add(line);
			
				curLine = br.readLine();
			}
			
			br.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
		System.out.println("DATA FROM CSV FILE READ");		
	}
	
	public void processData() {
		for(int i = 0; i < lines.size(); i++) {
			
			for(int j = 0; j < lines.get(i).length; j=j+3) {
				
				String line = lines.get(i)[j];
				
				String date[] = line.split("/");
				if (date[0].substring(0,1).equals("0"))
						date[0] = date[0].substring(1);	
				if (date[1].substring(0,1).equals("0"))
					date[1] = date[1].substring(1);	

				Event e = new Event(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
				
				e.setTitle(lines.get(i)[j+1]);
				e.setColor(lines.get(i)[j+2]);	
				
				Events evt = new Events(); 
				evt.addEvent(e);
			}
		}
	}	
}
