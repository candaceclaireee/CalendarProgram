package designchallenge1;

public class Event {
	public static int numOfEvents; 
	
	private int year;
	private int month;
	private int day;

	private String title;
	private String color;
	
	public Event(int month, int day, int year){
		numOfEvents++;
		
		setDate(month, day, year);
				
		color = "Blue"; //DEFAULT
		title = ""; //DEFAULT
	}

	public void setDate(int month, int day, int year){
		this.month = month; 
		this.day = day; 
		this.year = year;
	}	

	public void setDay(int d){ this.day = d; }
	
	public void setMonth(int m){
		this.month = m;
	}
	
	public void setYear(int y){
		this.year = y;
	}
		
	public void setTitle(String t){
		this.title = t;
	}
	
	public void setColor(String c) {
		this.color = c;
	}
	
	
	public int getNumOfEvents(){
		return numOfEvents;
	}
	
	public int getDay(){
		return day;
	}
	
	public int getMonth(){
		return month;
	}
	
	public int getYear(){
		return year;
	}
		
	public String getTitle(){
		return title;
	}
	
	public String getColor(){
		return color;
	}

	
}
