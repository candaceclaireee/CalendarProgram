package designchallenge1;

public class DesignChallenge1 {

    public static void main(String[] args) {
    
    	CSVReader cr = new CSVReader();
    	cr.parseData();
    	PSVReader pr = new PSVReader();
    	pr.parseData();
    	
        CalendarProgram cp = new CalendarProgram();
    }
}
