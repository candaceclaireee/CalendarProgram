package designchallenge1.observer;

import facebook.FBView;
import sms.SMS;
import sms.SMSView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class Subject {
    public Subject() {
        observers = new ArrayList<Observer>();
        eventData = new Events();
        currentNumEvents = eventData.getEventsSize();
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    public void setState() {
        for (Observer o: observers)
            o.update();

        SystemDateExtractor s = new SystemDateExtractor();
        s.extractSystem(LocalDate.now());

        for (Event currentEvent: eventData.getEvents()) {
            if (s.getMonth() == currentEvent.getMonth() && s.getDay() == currentEvent.getDay() && s.getYear() == currentEvent.getYear()
                    && currentEvent.getStatus() == false)
                currentEvent.setStatus(true);

        }
    }

    public Events getData() {
        return eventData;
    }

    public int getCurrentNumEvents() {
        return currentNumEvents;
    }

    public void updateNumEvents() {
        currentNumEvents = eventData.getEventsSize();
    }

    private ArrayList<Observer> observers;
    private Events eventData;
    private static int currentNumEvents;
}
