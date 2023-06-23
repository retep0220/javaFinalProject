package FinalProject;
import java.time.*;
import java.util.ArrayList;


public class SpacesInformation {
	private int index=0;
	private String location; 
	private LocalDate date;
	private LocalTime timeFrom;
	private LocalTime timeTo;
	private ArrayList<RentalSpacesMonths> rentalSpacesMonths = new ArrayList<RentalSpacesMonths>();
	
	public SpacesInformation(int index,String location,LocalDate date,LocalTime timeFrom,LocalTime timeTo) {
		this.index=index;
		this.location=location;
		this.date=date;
		this.timeFrom=timeFrom;
		this.timeTo=timeTo;
		LocalDate dateTemp = date;
		dateTemp = dateTemp.minusMonths(6);
		//建立前后6個月的List
		for(int i=0;i<13;i++) {
			Month month = new Month(dateTemp,timeFrom.getHour(),timeTo.getHour());
			rentalSpacesMonths.add(new RentalSpacesMonths(month));
			dateTemp = dateTemp.plusMonths(1);
		}
	}
	public SpacesInformation(SpacesInformation spacesInformation) {
		this.index=spacesInformation.index;
		this.location=spacesInformation.location;
		this.date=spacesInformation.date;
		this.timeFrom=spacesInformation.timeFrom;
		this.timeTo=spacesInformation.timeTo;
		this.rentalSpacesMonths=spacesInformation.rentalSpacesMonths;
	}
	//選擇的那一天的某個時辰段
	public void setSpacesInformation(LocalDate date,UserData user,LocalTime timeFrom,LocalTime timeTo) {
		this.date=date;
		this.timeFrom=timeFrom;
		this.timeTo=timeTo;
		int indexMonth = 0;
		LocalTime timeTemp = timeFrom;
		//得到list裏面同月份的index
		for(int i=0;i<rentalSpacesMonths.size();i++) {
			if(rentalSpacesMonths.get(i).getRentSpacesMonths().getMonth()==date.getMonthValue()) {
				indexMonth = i;
			}
		}
		for(int i=0;i<rentalSpacesMonths.get(indexMonth).getRentSpacesWeeks().size();i++) {
			for(int j=0;j<rentalSpacesMonths.get(indexMonth).getRentSpacesDays(i).size();j++) {
				if(rentalSpacesMonths.get(indexMonth).getRentSpacesDays(i).get(j).getDays()==date.getDayOfMonth()) {
					for(int k=0;k<timeTo.getHour()-timeFrom.getHour()+1;k++) {
						if(getInformation(date,timeTemp)== null) {
							String[] event = {user.getId(),user.getName()};
							rentalSpacesMonths.get(indexMonth).setRentSpacesEvent(i,j,k,event);
						}
						timeTemp = timeTemp.plusHours(1);
					}
				}
			}
		}
	}
	public void deleteSpacesInformation(LocalDate date,UserData user,LocalTime timeFrom,LocalTime timeTo) {
		this.date=date;
		this.timeFrom=timeFrom;
		this.timeTo=timeTo;
		int indexMonth = 0;
		LocalTime timeTemp = timeFrom;
		//得到list裏面同月份的index
		for(int i=0;i<rentalSpacesMonths.size();i++) {
			if(rentalSpacesMonths.get(i).getRentSpacesMonths().getMonth()==date.getMonthValue()) {
				indexMonth = i;
			}
		}
		for(int i=0;i<rentalSpacesMonths.get(indexMonth).getRentSpacesWeeks().size();i++) {
			for(int j=0;j<rentalSpacesMonths.get(indexMonth).getRentSpacesDays(i).size();j++) {
				if(rentalSpacesMonths.get(indexMonth).getRentSpacesDays(i).get(j).getDays()==date.getDayOfMonth()) {
					for(int k=0;k<timeTo.getHour()-timeFrom.getHour()+1;k++) {
						if(getInformation(date,timeTemp)[0]==user.getId()) {
							rentalSpacesMonths.get(indexMonth).setRentSpacesEvent(i,j,k,null);
						}
						timeTemp = timeTemp.plusHours(1);
					}
				}
			}
		}
	}
	public String[] getInformation(LocalDate date,LocalTime time) {
		int indexMonth = 0;
		for(int i=0;i<rentalSpacesMonths.size();i++) {
			if(rentalSpacesMonths.get(i).getRentSpacesMonths().getMonth()==date.getMonthValue()) {
				indexMonth = i;
			}
		}
		for(int i=0;i<rentalSpacesMonths.get(indexMonth).getRentSpacesWeeks().size();i++) {
			for(int j=0;j<rentalSpacesMonths.get(indexMonth).getRentSpacesDays(i).size();j++) {
				if(rentalSpacesMonths.get(indexMonth).getRentSpacesDays(i).get(j).getDays()==date.getDayOfMonth()) {
					for(int k=0;k<rentalSpacesMonths.get(indexMonth).getRentSpacesHours(i,j).size();k++) {
						if(rentalSpacesMonths.get(indexMonth).getRentSpacesHours(i,j,k)==time.getHour()) {
							return rentalSpacesMonths.get(indexMonth).getRentSpacesEvent(i,j,k);
						}
					}
				}
			}
		}
		return null;
	}
	public int getIndex() {
		return index;
	}
	public String getLocation() {
		return this.location;
	}
	public LocalDate getDate() {
		return date;
	}
	public ArrayList<LocalTime> getTime() {
		ArrayList<LocalTime> time=new ArrayList<LocalTime>();
		time.add(timeFrom);time.add(timeTo);
		return time;
	}
	public ArrayList<RentalSpacesMonths> getRentalSpacesMonths(){
		return rentalSpacesMonths;
	}
}
