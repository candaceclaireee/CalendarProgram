package designchallenge1.template;

import java.util.ArrayList;

public abstract class DataParser {
	
	public void parseData() {
		readData(); 
		processData();
	}
	
	public abstract void readData();
	public abstract void processData();

	protected ArrayList<String[]> lines = new ArrayList<String[]>();
}
