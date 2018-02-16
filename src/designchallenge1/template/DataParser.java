package designchallenge1.template;

import java.util.ArrayList;

public abstract class DataParser {
	
	static ArrayList<String[]> lines;
	
	public void parseData() {
		readData(); 
		processData();
	}
	
	public abstract void readData();
	public abstract void processData();
}
