package designchallenge1;

import facebook.FBView;
import sms.SMS;
import sms.SMSView;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class Subject {
    public Subject() {
        fbViewApps = new ArrayList<FBView>();
        smsApps = new ArrayList<SMSView>();
        eventData = new Events();
    }

    public void attach(FBView fb) {
        fbViewApps.add(fb);
    }

    public void attach(SMSView sms) {
        smsApps.add(sms);
    }

    public void setState() {
        ArrayList<Event> currentEvents = eventData.getEvents();
        ColorConverter converter = new ColorConverter();
        Date d = new Date();
        d.extractSystem(LocalDate.now());

        for (FBView currentFBView : fbViewApps) {
            for (Event currentEvent: eventData.getEvents()) {
                if (d.getsysMonth() == currentEvent.getMonth() && d.getsysDay() == currentEvent.getDay() && d.getsysYear() == currentEvent.getYear())
                    currentFBView.showNewEvent(currentEvent.getTitle(), currentEvent.getMonth(),
                            currentEvent.getDay(), currentEvent.getYear(), converter.convertColor(currentEvent.getColor()));
            }
        }

        for (SMSView currentSMSView : smsApps) {
            for (Event currentEvent: eventData.getEvents()) {
                if (d.getsysMonth() == currentEvent.getMonth() && d.getsysDay() == currentEvent.getDay() && d.getsysYear() == currentEvent.getYear()) {
                    Calendar convertToCalendar = Calendar.getInstance();
                    convertToCalendar.set(currentEvent.getYear(), currentEvent.getMonth()-1, currentEvent.getDay());
                    SMS smsEvent = new SMS(currentEvent.getTitle(), convertToCalendar, converter.convertColor(currentEvent.getColor()));
                    currentSMSView.sendSMS(smsEvent);
                }
            }
        }
    }

    private ArrayList<FBView> fbViewApps;
    private ArrayList<SMSView> smsApps;
    private Events eventData;
}
