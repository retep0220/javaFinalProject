package FinalProject;
import java.util.ArrayList;

public class Days {
	private int days;
	private int hoursFrom;
	private int hoursTo;
	private ArrayList<Hours> hours =new  ArrayList<Hours>();
	
	public Days(int days,int hoursFrom,int hoursTo) {
		this.days=days;
		this.hoursFrom=hoursFrom;
		this.hoursTo=hoursTo;
		for(int i=0;i< hoursTo-hoursFrom;i++) {
			hours.add(new Hours(hoursFrom++));
		}
	}
	public int getDays() {
		return days;
	}
	public ArrayList<Hours> getHours() {
		return hours;
	}
}
