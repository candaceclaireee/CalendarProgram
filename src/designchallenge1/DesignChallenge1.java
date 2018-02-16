package designchallenge1;

import designchallenge1.observer.CalendarProgram;
import designchallenge1.observer.FBApp;
import designchallenge1.observer.SMSApp;
import designchallenge1.observer.Subject;
import designchallenge1.template.CSVDataParser;
import designchallenge1.template.PSVDataParser;

public class DesignChallenge1 {

    public static void main(String[] args) {
    
    	CSVDataParser cr = new CSVDataParser();
    	cr.parseData();
    	PSVDataParser pr = new PSVDataParser();
    	pr.parseData();

    	Subject sub = new Subject();
        CalendarProgram cp = new CalendarProgram(sub);
        sub.attach(new FBApp(sub));
        sub.attach(new SMSApp(sub));
        sub.setState();
    }
}
