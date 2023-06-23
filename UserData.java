package FinalProject;

import java.time.LocalDate;

public class UserData {
	private String id;
	private int password;
	private String name;
	private LocalDate birthday;

	public UserData(String id, int password, String name, LocalDate birthday)
	{
		this.id=id;
		this.password=password;
		this.name=name;
		this.birthday=birthday;
	}
	
	public UserData(UserData user)
	{
		this.id=user.id;
		this.password=user.password;
		this.name=user.name;
		this.birthday=user.birthday;
	}

	public String getId()
	{
		return this.id;
	}
	
	public int getPassword()
	{
		return this.password;
	}
	
	public void setPassword(int password)
	{
		this.password=password;
	}
	
	public String getName()
	{
		return this.name;
	}	

	public LocalDate getBirthday()
	{
		return this.birthday;
	}
}
