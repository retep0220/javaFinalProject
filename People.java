package FinalProject;

import java.time.LocalDate;

public interface People {
	void addPerson(String id, int password, String name, LocalDate birthday);
	void addPerson(UserData user);
	UserData getPerson(String id);
	void setPerson(String id, int password);
	
}
