package FinalProject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;

public class RentalSpaces {
	private List<SpacesInformation> spaces = new ArrayList<SpacesInformation>();
	private String location;
	
	public RentalSpaces(String location) {
		this.location=location;
	}
	//timeFrom->timeTo 可以租借的時間
	public void addSpacesInformation(String location,LocalDate date,LocalTime timeFrom,LocalTime timeTo) {
		spaces.add(new SpacesInformation(spaces.size(),location,date,timeFrom,timeTo));
	}
	//timeFrom->timeTo 要租借的時間且不能在當天租
	public void setSpacesInformation(int index,UserData user,LocalDate date,LocalTime timeFrom,LocalTime timeTo) {
		LocalDate localDate = LocalDate.now();
		//avoid rent in today
		if(localDate.until(date,ChronoUnit.DAYS)>=1) {	
			spaces.get(index).setSpacesInformation(date, user, timeFrom, timeTo);
		}
	}
	public void deleteSpacesInformation(int index,UserData user,LocalDate date,LocalTime timeFrom,LocalTime timeTo) {
		LocalDate localDate = LocalDate.now();
		//avoid rent in today
		if(localDate.until(date,ChronoUnit.DAYS)>=1) {	
			spaces.get(index).deleteSpacesInformation(date, user, timeFrom, timeTo);
		}
	}
	public void showInformation(int index,LocalDate date,LocalTime time) {
		String[] information = spaces.get(index).getInformation(date,time);
		if(information!=null) {
			for(int i=0;i<information.length;i++) {
				System.out.println(information[i]);
			}
		}
		else {
			System.out.println("Null");
		}
//		for(int i=0;i<getRentalSpacesMonths.size();i++) {
//			System.out.println(getRentalSpacesMonths.get(i).getRentSpacesMonths().getMonth());
//			System.out.println("-".repeat(location.length()+4));
//			System.out.println("| "+location+" |");
//			System.out.println("-".repeat(location.length()+4));
//			System.out.println("-".repeat(114));
//			for(int j=0;j<spaces.size();j++) {
//				System.out.printf("|%2d\t| %25s\t| %15s\t| %23s \n",j,spaces.get(index).getLocation(),,);
//			}
//			System.out.println("-".repeat(114));
//		}
	}
	public String getRentalSpacesLocation() {
		return location;
	}
}