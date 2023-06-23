package FinalProject;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Notice {
	String title; // 公告標題
	String text; // 公告內文
	String id; // 撰寫者id
	LocalDateTime time; // 公告時間
	String filePath = title+".txt"; // 內文的文字檔名稱
	Student students = new Student();
	
	public Notice(String title, String text, String id, LocalDateTime time) // 建構子
	{
		this.title=title;
		this.text=text;
		this.id=id;
		this.time=time;
		
		File file = new File(filePath);
        if (file.exists()) 
        { // 偵測是否已有同名的txt檔
            throw new IllegalArgumentException("File with the same name already exists");
        }
        
		try 
		{ // 創建內文的txt檔
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(text);
            writer.close();
            System.out.println("文字已成功寫入文件");
        } 
		catch (IOException e) 
		{
            System.out.println("寫入文件時出現錯誤：" + e.getMessage());
        }
	}
	
	public boolean isWriter(String id) // 寫文章者才有編輯權限，所以此用來測試是否為撰寫者
	{
		if(this.id.equals(id))
		{
			return true;
		}
		return false;
	}

	public String getName() // 取得撰寫者姓名
	{
		return this.students.getPerson(this.id).getName();
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public void setTitle(String title) // 編輯標題
	{
		File oldFile = new File(this.title+".txt");
        File newFile = new File(title+".txt");
        if (oldFile.exists()) 
        {
            boolean isRenamed = oldFile.renameTo(newFile);
            if (isRenamed) 
            {
                System.out.println("File renamed successfully.");
                this.title=title;
            } 
            else 
            {
                System.out.println("Failed to rename file.");
            }
        } 
        else 
        {
            System.out.println("File does not exist.");
        }
	}
	
	public LocalDateTime getTime()
	{
		return this.time;
	}
	
	public void setTime(LocalDateTime time) // 使用者編輯文章後，需要此來填寫編輯時間
	{
		this.time=time;
	}
	
	public void showText() // 當要輸出內文時，用此方法來把內文輸出
	{
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
		{
            String line;
            while ((line = reader.readLine()) != null) 
            {
                System.out.println(line);
            }
        } 
		catch (IOException e) 
		{
            System.out.println("讀取文件時出現錯誤：" + e.getMessage());
        }
	}
	
	public void setText(String oldText, String newText) // 更改內文的內容
	{
		StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                content.append(line).append(System.lineSeparator()); // 先加入此行文字，再加入行分隔符
            }
        } 
        catch (IOException e) 
        {
            System.out.println("讀取文件時出現錯誤：" + e.getMessage());
            return;
        }

        // 在內容中進行文字更改
        String modifiedContent = content.toString().replace(oldText, newText);

        // 將更改後的內容寫回到原文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) 
        {
            writer.write(modifiedContent);
            System.out.println("文字已成功修改並寫回文件");
        } 
        catch (IOException e) 
        {
            System.out.println("寫回文件時出現錯誤：" + e.getMessage());
        }
	}
}
