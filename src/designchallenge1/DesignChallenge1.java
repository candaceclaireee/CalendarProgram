package designchallenge1;

import designchallenge1.observer.CalendarProgram;
import designchallenge1.observer.FBApp;
import designchallenge1.observer.SMSApp;
import designchallenge1.observer.Subject;
import designchallenge1.template.CSVDataParser;
import designchallenge1.template.DataParser;
import designchallenge1.template.PSVDataParser;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class DesignChallenge1 {

    public static void main(String[] args) {

        ArrayList<DataParser> parsers = new ArrayList<DataParser>();
        parsers.add(new CSVDataParser());
        parsers.add(new PSVDataParser());

        for (DataParser parser: parsers)
            parser.parseData();

    	Subject sub = new Subject();
        CalendarProgram cp = new CalendarProgram(sub);
        sub.attach(new FBApp(sub));
        sub.attach(new SMSApp(sub));
        sub.setState();
    }
}
