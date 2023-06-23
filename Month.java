package FinalProject;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Month {
	private LocalDate date;
	private LocalDate theDate;
	private int today;
	private int month;
	private DayOfWeek weekday;
	private int value;
	private ArrayList<Weeks> weeks =new  ArrayList<Weeks>();
	
	public Month(LocalDate date,int hoursFrom,int hoursTo) {
		this.date = date;
		this.theDate = date;
		this.month=theDate.getMonthValue();
		today = this.date.getDayOfMonth();
		this.date = this.date.minusDays(today-1);
		weekday = this.date.getDayOfWeek();
		value = weekday.getValue();
		for(;;) {
			this.date = this.date.plusDays(7);
			if(this.date.getMonthValue()!=this.month) {
				LocalDate dateTemp = this.date.minusDays(this.date.getDayOfMonth()-1);
				weeks.add(new Weeks(value,this.date.minusDays(7),dateTemp,hoursFrom,hoursTo));
				break;
			}
			else
				weeks.add(new Weeks(value,this.date.minusDays(7),this.date,hoursFrom,hoursTo));
		}
	}
	public ArrayList<Weeks> getWeeks() {
		return this.weeks;
	}
	public int getMonth() {
		return this.month;
	}
	public int getValue() {
		return this.value;
	}
	public LocalDate getDate() {
		return theDate;
	}
}
