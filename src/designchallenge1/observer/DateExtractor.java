package designchallenge1.observer;

import java.time.LocalDate;

public class DateExtractor {

    public void extractSystem(LocalDate systemDate) {
        String[] tempDate = systemDate.toString().split("-");

        extractedYear = Integer.parseInt(tempDate[0]);
        extractedMonth = Integer.parseInt(tempDate[1]);
        extractedDay = Integer.parseInt(tempDate[2]);

    }

    public int getMonth() {
        return extractedMonth;
    }

    public int getDay() {
        return extractedDay;
    }

    public int getYear() {
        return  extractedYear;
    }

    private int extractedMonth;
    private int extractedDay;
    private int extractedYear;
}