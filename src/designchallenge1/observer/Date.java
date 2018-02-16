package designchallenge1.observer;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Date {

	    private static int yearBound, monthBound, dayBound, yearToday, monthToday;

	    private int sysMonth;
	    private int sysDay;
	    private int sysYear;
	   
	    
	    public Date(){
			GregorianCalendar cal = new GregorianCalendar();
			dayBound = cal.get(GregorianCalendar.DAY_OF_MONTH);
			monthBound = cal.get(GregorianCalendar.MONTH);
			yearBound = cal.get(GregorianCalendar.YEAR);
			monthToday = monthBound; 
			yearToday = yearBound;	
	    }

		public int getYearBound() {
			return yearBound;
		}

		public void setYearBound(int yearBound) {
			this.yearBound = yearBound;
		}

		public int getMonthBound() {
			return monthBound;
		}

		public void setMonthBound(int monthBound) {
			this.monthBound = monthBound;
		}

		public int getDayBound() {
			return dayBound;
		}

		public void setDayBound(int dayBound) {
			this.dayBound = dayBound;
		}

		public int getYearToday() {
			return yearToday;
		}

		public void setYearToday(int yearToday) {
			this.yearToday = yearToday;
		}

		public int getMonthToday() {
			return monthToday;
		}

		public void setMonthToday(int monthToday) {
			this.monthToday = monthToday;
		}
		
	    public int getsysMonth() {
	        return sysMonth;
	    }

	    public int getsysDay() {
	        return sysDay;
	    }

	    public int getsysYear() {
	        return sysYear;
	    }
}
