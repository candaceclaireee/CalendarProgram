package designchallenge1.observer;

import java.util.ArrayList;

public class Events {

	private static ArrayList<Event> events = new ArrayList<Event>();

	public void addEvent(Event e)
	{
		events.add(e);
	}

	public ArrayList<Event> getEvents(){
		return events;
	}

	public int getEventsSize() {
		return events.size();
	}

	public int getIndex(Event e) {
		return events.indexOf(e);
	}

	public void printEvents() {
		for (int i = 0; i<events.size(); i++)
		{
			System.out.println(i + " " + events.get(i).getTitle() + " " + events.get(i).getColor());
			System.out.println("ON: "+ events.get(i).getMonth()+ "/"+  events.get(i).getDay()+ "/" +events.get(i).getYear());
		}
	}
}
