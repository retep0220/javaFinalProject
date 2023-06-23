package FinalProject;

import java.time.LocalDateTime;

public class Event {
	private String purpose;
	private People people;
	private People group;
	private LocalDateTime date;
	
	public Event(String purpose, People people, LocalDateTime date)
	{
		this.purpose=purpose;
		this.people=people;
		this.date=date;
	}
	
	public String getPurpose()
	{
		return this.purpose;
	}
	
	public void setPurpose(String purpose)
	{
		this.purpose=purpose;
	}
	
	public void addGroup(String id)
	{
		group.addPerson(people.getPerson(id));
	}
	
	public LocalDateTime getDate()
	{
		return this.date;
	}
	
	public void setDate(LocalDateTime date)
	{
		this.date=date;
	}
}
