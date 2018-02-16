package designchallenge1.template;

import designchallenge1.observer.Event;
import designchallenge1.observer.Events;

import java.util.*;
import java.io.*;

public class CSVDataParser extends DataParser {

	static ArrayList<String[]> lines = new ArrayList<String[]>();
	static Events events = new Events();
	
	public void readData(){
		try {
			File f = new File("src\\sample_files\\PhilippineHolidays.csv");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
		
			String curLine = br.readLine();
			
			while(curLine != null) {
				
				String line[] = curLine.split(",");
				lines.add(line);
			
				curLine = br.readLine();
			}

			f = new File("src\\sample_files\\UserEvents.csv");
			fr = new FileReader(f);
			br = new BufferedReader(fr);

			curLine = br.readLine();

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
	
	
	public static void writeData(int index) {

		String filepath = "src\\sample_files\\UserEvents.csv";
		BufferedWriter bw = null;
		BufferedReader br = null;
		String line = null;
		
		try {
			FileWriter fw = new FileWriter(filepath, true);
			bw = new BufferedWriter(fw);
			
			line = events.getEvents().get(index).getMonth() + "/" + events.getEvents().get(index).getDay() + "/" + events.getEvents().get(index).getYear() + "," 
					+ events.getEvents().get(index).getTitle() + "," + events.getEvents().get(index).getColor();
				
			bw.write(line);
			bw.write(System.getProperty("line.separator"));
				
		} catch(IOException e) {
			e.printStackTrace();
			
		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
