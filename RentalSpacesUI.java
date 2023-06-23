package FinalProject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RentalSpacesUI {
	private List<RentalSpaces> rental = new ArrayList<RentalSpaces>();
	//detail 0：Student's Name 1：Student's Id 2：Available/Rented
	public RentalSpacesUI() {
		LocalTime timeFrom = LocalTime.of(8, 0);
		LocalTime timeTo = LocalTime.of(22, 0);
		LocalDate date = LocalDate.now();
		rental.add(new RentalSpaces("學生活動中心(Art Center)"));
		rental.get(0).addSpacesInformation("1stFloor1thMeetingRoom",date,timeFrom,timeTo);
		rental.get(0).addSpacesInformation("1stFloor2thMeetingRoom",date,timeFrom,timeTo);
		rental.add(new RentalSpaces("芸青軒(Student's Reading Hall)"));
		rental.get(1).addSpacesInformation( "2stFloor1thMeetingRoom",date,timeFrom,timeTo);
		rental.get(1).addSpacesInformation( "2stFloor2thMeetingRoom",date,timeFrom,timeTo);
	}
	//顯示指定日期的時間段
	public void showRentalInformation(int indexRentalSpaces,int indexRentalSpacesInformation,LocalDate date,LocalTime time) {
		rental.get(indexRentalSpaces).showInformation(indexRentalSpacesInformation,date,time);
	}
	//timeFrom->timeTo 要租借的時間且不能在當天租
	public void setRentalInformation(int indexRentalSpaces,int indexSpaces,UserData user,LocalDate date,LocalTime timeFrom,LocalTime timeTo) {
		rental.get(indexRentalSpaces).setSpacesInformation(indexSpaces,user,date,timeFrom,timeTo);
	}
	public void deleteRentalInformation(int indexRentalSpaces,int indexSpaces,UserData user,LocalDate date,LocalTime timeFrom,LocalTime timeTo) {
		rental.get(indexRentalSpaces).deleteSpacesInformation(indexSpaces,user,date,timeFrom,timeTo);
	}
	public void addRentalInformation(int index,String location,LocalDate date,LocalTime timeFrom,LocalTime timeTo) {
		rental.get(index).addSpacesInformation(location,date,timeFrom,timeTo);
	}
}
