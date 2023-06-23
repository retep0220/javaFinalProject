package FinalProject;

import java.util.ArrayList;
import java.util.List;

public class Timetable {
	private String site; // 教室地點號碼
	private List<Integer> time = new ArrayList<Integer>(); // 上課時間(這邊不是記時間，而是記節數)
	private String className; // 課程名稱
	private String teacherName; // 老師名稱
	
	public Timetable (String site, ArrayList<Integer> time, String className, String teacherName) // 建構子
	{
		this.site=site;
		this.time=time;
		this.className=className;
		this.teacherName=teacherName;
	}

	public String getSite() // 提取地點
	{
		return this.site;
	}
	
	public void setSite(String site) // 設定地點
	{
		this.site=site;
	}
	
	public List<Integer> getTime() // 提取時間
	{
		return this.time;
	}
	
	public void setTime(ArrayList<Integer> time) // 設定時間
	{
		this.time=time;
	}
	
	public void addTime(int time) // 增加時間
	{
		this.time.add(time);
	}
	
	public String getClassName() // 提取課程名稱
	{
		return this.className;
	}
	
	public void setClassName(String className) // 設定課程名稱
	{
		this.className=className;
	}
	
	public String getTeacherName() // 提取老師名稱
	{
		return this.teacherName;
	}
	
	public void setTeacherName(String teacherName) // 設定老師名稱
	{
		this.teacherName=teacherName;
	}
}
