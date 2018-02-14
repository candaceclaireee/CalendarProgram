package designchallenge1;

import facebook.FBView;
import sms.SMSView;

public class DesignChallenge1 {

    public static void main(String[] args) {
    
    	CSVReader cr = new CSVReader();
    	cr.parseData();
    	PSVReader pr = new PSVReader();
    	pr.parseData();
    	
        CalendarProgram cp = new CalendarProgram();
        FBView fb = new FBView();
        SMSView sv = new SMSView();
        Subject s = new Subject();

        s.attach(fb);
        s.attach(sv);
        s.setState();

    }
}
