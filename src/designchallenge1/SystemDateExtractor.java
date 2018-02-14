package designchallenge1;

import java.time.LocalDate;

public class SystemDateExtractor {

    public void extractSystem(LocalDate systemDate) {
        String[] tempDate = systemDate.toString().split("-");

        year = Integer.parseInt(tempDate[0]);
        month = Integer.parseInt(tempDate[1]);
        day = Integer.parseInt(tempDate[2]);

    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    private int month;
    private int day;
    private int year;
}