package designchallenge1.template;

public abstract class DataParser {
	
	public void parseData() {
		readData(); 
		processData();
	}
	
	public abstract void readData();
	public abstract void processData();
}
