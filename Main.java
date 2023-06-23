package FinalProject;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
public class Main {
	public static void main(String[] args) {
		Application.launch(GUI.class, args);
		Scanner keyIn=new Scanner (System.in);
		//System.out.println(keyIn.nextInt());
		LocalDate birth = LocalDate.of(2000, 03, 13);
		LocalDate today = LocalDate.of(2023, 05, 29);//輸入日期要比今天的日子后至少一天
		LocalTime timeTestFrom = LocalTime.of(8, 0);
		LocalTime timeTestTo = LocalTime.of(10, 0);
		Student student = new Student();
		String loginPeopleId=" ";
		student.addPerson("E14085040",19970629,"james",birth);
		student.addPerson("E14085050",19970630,"jamespai",birth);
		
		//LoginOrRegister
		LoginRegister login = new LoginRegister();
		System.out.print("Login/Register(1/2): ");
		int index=keyIn.nextInt();
		keyIn.nextLine(); 
		
		switch(index) {
			case 1:
				String id;
				int password;
				System.out.print("Student’s ID: ");
				id=keyIn.nextLine(); 
				System.out.print("Student’s Password: ");
				password=keyIn.nextInt();
				if(login.login(id, password, student)) {
					//give response
					loginPeopleId=id;
					System.out.println("good");
				}
				break;
			case 2:
				String name;
				LocalDate birthday; int year; int month; int date;
				System.out.print("Student’s ID: ");
				id=keyIn.nextLine(); 
				System.out.print("Student’s Password: ");
				password=keyIn.nextInt();
				keyIn.nextLine(); 
				System.out.print("Student’s Name: ");
				name=keyIn.nextLine(); 
				System.out.print("Student’s Born's (year/month/date): ");
				year=keyIn.nextInt(); 
				month=keyIn.nextInt(); 
				date=keyIn.nextInt(); 
				birthday=LocalDate.of(year, month, date);
				login.register(id, password, name, birthday, student);
				break;
			default:
					break;
		}
		if(!loginPeopleId.equals(" ")) {
			UserData user = new	UserData(student.getPerson(loginPeopleId));
			//RentalSpaces
			RentalSpacesUI rental=new RentalSpacesUI();
			System.out.println("Show ALL Spaces");
			rental.showRentalInformation(0,0,today,timeTestFrom);
			rental.setRentalInformation(0,0,user,today,timeTestFrom,timeTestTo);
			rental.showRentalInformation(0,0,today,timeTestFrom);
			rental.deleteRentalInformation(0,0,user,today,timeTestFrom,timeTestTo);
			rental.showRentalInformation(0,0,today,timeTestTo);
			
//			ArrayList<String> detail = new ArrayList<String>();
//			detail.add(student.getPerson(loginPeopleId).getName());
//			detail.add(student.getPerson(loginPeopleId).getId());
//			rental.showRentalInformation(0,0,today,timeTestFrom);
		}
		
		//calandar
//		Calendar calendar = new Calendar();
//		LocalDate date = LocalDate.of(2023, 5, 24);
//		calendar.show();

		
	}

	

}
