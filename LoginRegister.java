package FinalProject;
import java.time.LocalDate;

public class LoginRegister {
	public LoginRegister() {
		
	}
	public boolean login(String id,int password,People allPeople) {
		//Verify Login Information
		UserData userTemp = allPeople.getPerson(id);
		if(userTemp.getId()!=null) {
			if(userTemp.getPassword()==password) {
				System.out.print("Login Success ");
				return true;
			}
			else {
				System.out.println("Login Fail in Password ");
				return false;
			}
		}
		else {
			System.out.println("Login Fail in ID or Password ");
		}
		return false;
	}
	public String logOut(String id) {//可以在你那邊寫就好
		return null;
	}
	public void register(String id,int password,String name,LocalDate birthday,Student allStudent) {
		UserData user;
		user = new UserData(id,password,name,birthday);
		allStudent.addPerson(user);
		allStudent.showStudents();
	}
	public void forgotIdPassword(String id,int password,People allPeople) {
		allPeople.getPerson(id).setPassword(password);	
	}
}
