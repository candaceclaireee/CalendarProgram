package designchallenge1;

public abstract class DataReader {
	
	public void parseData() {
		readData(); 
		processData();
	}
	
	public abstract void readData();
	public abstract void processData();
}
