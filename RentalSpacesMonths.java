package FinalProject;

import java.util.ArrayList;

public class RentalSpacesMonths   {
	private Month months;
	//選擇月份
	public RentalSpacesMonths(Month months) {
		this.months = months;
	}
	public Month getRentSpacesMonths() {
		return months;
	}
	//選擇月份的全部week
	public ArrayList<Weeks> getRentSpacesWeeks() {
		return months.getWeeks();
	}
	//選擇月份，指定week的所有日期
	public ArrayList<Days> getRentSpacesDays(int index){
		return months.getWeeks().get(index).getDays();
	}
	//選擇月份，指定week中的其中一天的時辰
	public ArrayList<Hours> getRentSpacesHours(int indexWeek,int indexDay){
		return months.getWeeks().get(indexWeek).getDays().get(indexDay).getHours();
	}
	//選擇月份，指定week中的其中一天的某個時辰
	public int getRentSpacesHours(int indexWeek,int indexDay,int indexHour){
		return months.getWeeks().get(indexWeek).getDays().get(indexDay).getHours().get(indexHour).getHours();
	}
	public String[] getRentSpacesEvent(int indexWeek,int indexDay,int indexHour){
		return months.getWeeks().get(indexWeek).getDays().get(indexDay).getHours().get(indexHour).getEvent();
	}
	public void setRentSpacesEvent(int indexWeek,int indexDay,int indexHour,String[] event){
		months.getWeeks().get(indexWeek).getDays().get(indexDay).getHours().get(indexHour).setEvent(event);
	}
}
