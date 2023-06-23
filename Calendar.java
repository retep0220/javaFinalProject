package FinalProject;
import java.time.*;
import java.util.ArrayList;

public class Calendar {
	private ArrayList<CalendarDataBase> calendar = new ArrayList<CalendarDataBase>();
	private LocalDate theDate;//constant today
	private LocalDate date;
	private int month;
	private int today;
	private int value;
	
	public Calendar() {
		theDate = LocalDate.now();
		calendar.add(new CalendarDataBase(2023,6,12,1,24));
	}
	
	public void show() {
		for(int i=0;i<calendar.get(0).getMonthCalendar().size();i++) {
			System.out.println(calendar.get(0).getMonth());
			for(int j=0;j<calendar.get(0).getMonthCalendar().get(0).getWeeks().size();j++) {
				for(int k=0;k<calendar.get(0).getMonthCalendar().get(0).getWeeks().get(j).getDays().size();k++) {
					//System.out.println(calendar.get(0).getMonthCalendar().get(0).getValue());
						System.out.print(calendar.get(0).getMonthCalendar().get(0).getWeeks().get(j).getDays().get(k).getDays()+"\t");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	public void showCalendarMonth() {
		LocalDate dateTemp = this.date;
		 System.out.println("Mon Tue Wed Thu Fri Sat Sun");
	        for (int i = 1; i < value;i++)
	            System.out.print("    ");
	        while(dateTemp.getMonthValue() == month)
	        {
	            System.out.printf("%3d",dateTemp.getDayOfMonth());
	            if (dateTemp.getDayOfMonth() == today)
	                System.out.print("*");
	            else
	                System.out.print(" ");
	            dateTemp = dateTemp.plusDays(1);
	            if (dateTemp.getDayOfWeek().getValue() == 1)
	                System.out.println();
	        }
	        if (dateTemp.getDayOfWeek().getValue() != 1)
	            System.out.println();
	}
	public void showCalendarWeek() {
		LocalDate dateTemp = theDate;
		int theWeek = (dateTemp.getDayOfWeek()).getValue();
		System.out.println("Mon Tue Wed Thu Fri Sat Sun");
		if(dateTemp.getDayOfMonth()>7) {
			dateTemp=dateTemp.minusDays(theWeek-1);
			for(int i=0;i<7;i++) {
				System.out.printf("%3d",dateTemp.getDayOfMonth());
				if (dateTemp.getDayOfMonth() == today)
	                System.out.print("*");
	            else
	                System.out.print(" ");
				dateTemp = dateTemp.plusDays(1);
			}
		}
		else {
			for (int i = 1; i < value;i++)
	            System.out.print("    ");
			System.out.printf("%3d",dateTemp.getDayOfMonth());
            if (dateTemp.getDayOfMonth() == today)
                System.out.print("*");
            else
                System.out.print(" ");
            dateTemp = dateTemp.plusDays(1);
		}
        
	}
	public void showHours() {
		System.out.printf("\n%3s\t| %3s\t| %3s\t| %3s\t| %3s\t| %3s\t| %3s\t| %3s\t|","HRS","Mon","Tue","Wed","Thu","Fri","Sat","Sun");
		for(int i=8;i<23;i++) {
			System.out.printf("\n%3d\t| %3s\t| %3s\t| %3s\t| %3s\t| %3s\t| %3s\t| %3s\t|\n",i," "," "," "," "," "," "," ");
		}
	}
	public void showHours(ArrayList<String> Mon,ArrayList<String> Tue,ArrayList<String> Wed,ArrayList<String> Thu,ArrayList<String> Fri,ArrayList<String> Sat,ArrayList<String> Sun) {
		System.out.printf("\n%3s\t| %3s\t| %3s\t| %3s\t| %3s\t| %3s\t| %3s\t| %3s\t|","HRS","Mon","Tue","Wed","Thu","Fri","Sat","Sun");
		for(int i=8;i<23;i++) {
			System.out.printf("\n%3d\t| %3s\t| %3s\t| %3s\t| %3s\t| %3s\t| %3s\t| %3s\t|\n",i,Mon.get(0),Tue.get(0),Wed.get(0),Thu.get(0),Fri.get(0),Sat.get(0),Sun.get(0));
			System.out.printf("\n%3s\t| %3s\t| %3s\t| %3s\t| %3s\t| %3s\t| %3s\t| %3s\t|\n","",Mon.get(0),Tue.get(0),Wed.get(0),Thu.get(0),Fri.get(0),Sat.get(0),Sun.get(0));
		}
	}
}
