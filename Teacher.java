package FinalProject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Teacher implements People {
	List<UserData> teachers =new ArrayList<UserData>();
	
	public void addPerson(String id, int password, String name, LocalDate birthday)
	{
		teachers.add(new UserData(id,password,name,birthday));
	}
	
	public void addPerson(UserData user)
	{
		teachers.add(user);
	}
	
	public UserData getPerson(String id)
	{
		for(int i=0;i<teachers.size();i++)
		{
			if(teachers.get(i).getId()==id)
			{
				return teachers.get(i);
			}
		}
		return null;
	}
	
	public void setPerson(String id, int password)
	{
		for(int i=0;i<teachers.size();i++)
		{
			if(teachers.get(i)==getPerson(id))
			{
				teachers.get(i).setPassword(password);
			}
		}
	}
}
