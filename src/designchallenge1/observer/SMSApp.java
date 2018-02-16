package designchallenge1.observer;

import sms.SMS;
import sms.SMSView;

import java.time.LocalDate;
import java.util.Calendar;

public class SMSApp extends Observer {
    private SMSView app;

    public SMSApp(Subject sub) {
        app = new SMSView();
        this.sub = sub;
    }

    @Override
    public void update() {
        DateExtractor d = new DateExtractor();
        ColorConverter converter = new ColorConverter();
        d.extractSystem(LocalDate.now());

        for (Event currentEvent : sub.getData().getEvents()) {
            if (d.getMonth() == currentEvent.getMonth() && d.getDay() == currentEvent.getDay() && d.getYear() == currentEvent.getYear()
                    && currentEvent.getStatus() == false) {
                Calendar convertToCalendar = Calendar.getInstance();
                convertToCalendar.set(currentEvent.getYear(), currentEvent.getMonth() - 1, currentEvent.getDay());
                SMS smsEvent = new SMS(currentEvent.getTitle(), convertToCalendar, converter.convertColor(currentEvent.getColor()));
                app.sendSMS(smsEvent);
            }
        }
    }
}