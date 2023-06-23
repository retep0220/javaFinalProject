package FinalProject;
import java.time.*;
import java.util.ArrayList;

public class Weeks {
	private int weeks;
	private LocalDate dayFrom;
	private LocalDate dayTo;
	private ArrayList<Days> days =new  ArrayList<Days>();
	
	public Weeks(int weeks,LocalDate dayFrom,LocalDate dayTo,int hoursFrom,int hoursTo) {
		this.weeks=weeks;
		this.dayFrom=dayFrom;
		this.dayTo=dayTo;
		Period next = Period.between(dayFrom, dayTo);
		LocalDate dateTemp = dayFrom;
		
		for(int i=0;i<next.getDays();i++) {
			days.add(new Days(dateTemp.getDayOfMonth(),hoursFrom,hoursTo));
			dateTemp = dateTemp.plusDays(1);
		}
	}
	public ArrayList<Days> getDays() {
		return this.days;
	}
	public int getWeeks() {
		return this.weeks;
	}
}
