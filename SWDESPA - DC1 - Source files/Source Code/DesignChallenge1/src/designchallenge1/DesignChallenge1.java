package designchallenge1;

import DesignChallenge1.CSVReader;
import DesignChallenge1.CalendarProgram;
import DesignChallenge1.PSVReader;

public class DesignChallenge1 {

    public static void main(String[] args) {
    
    	CSVReader cr = new CSVReader();
    	cr.parseData();
    	PSVReader pr = new PSVReader();
    	pr.parseData();
    	
        CalendarProgram cp = new CalendarProgram();
    }
}
