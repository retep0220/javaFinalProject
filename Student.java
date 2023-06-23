package FinalProject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student implements People {	
	private List<UserData> students = new ArrayList<UserData>();
	
	public void addPerson(String id, int password, String name, LocalDate birthday)
	{
		students.add(new UserData(id,password,name,birthday));
	}
	
	public void addPerson(UserData user)
	{
		students.add(user);
	}
	
	public UserData getPerson(String id)
	{
		for(int i=0;i<students.size();i++)
		{
			if(students.get(i).getId().equals(id))
			{
				return students.get(i);
			}
		}
		return null;
	}
	
	public void setPerson(String id, int password)
	{
		for(int i=0;i<students.size();i++)
		{
			if(students.get(i)==getPerson(id))
			{
				students.get(i).setPassword(password);
			}
		}
	}
	public void showStudents() {
		System.out.printf("| %12s| %20s |%16s |%20s |\n","Student's Id","Student's Password","Student's Name","Student's Birthday");
		for(int i=0;i<students.size();i++) {
			System.out.printf("| %12s| %20s |%16s |%20s |\n",students.get(i).getId(),students.get(i).getPassword(),students.get(i).getName(),students.get(i).getBirthday());
		}
	}
}
