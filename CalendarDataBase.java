package FinalProject;
import java.time.*;
import java.util.ArrayList;

public class CalendarDataBase {
	private LocalDate date;
	private int hoursFrom=1;
	private int hoursTo=24;
	private ArrayList<Month> month = new ArrayList<Month>();
	
	public CalendarDataBase() {
		date = LocalDate.now();
		month.add(new Month(date,hoursFrom,hoursTo));
	}
	public CalendarDataBase(int year,int month,int date,int hoursFrom,int hoursTo) {
		this.date = LocalDate.of(year,month,date);
		this.month.add(new Month(this.date,hoursFrom,hoursTo));
	}
//	public void setHoursFromTo(int hoursFrom,int hoursTo) {
//		this.hoursFrom=hoursFrom;
//		this.hoursTo=hoursTo;
//	}
	public int getYear() {
		return this.date.getYear();
	}
	public int getMonth() {
		return this.date.getMonthValue();
	}
	public int getDay() {
		return this.date.getDayOfMonth();
	}
	public ArrayList<Month> getMonthCalendar() {
		return this.month;
	}
}
