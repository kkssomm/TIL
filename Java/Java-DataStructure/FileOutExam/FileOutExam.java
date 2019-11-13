package day12;

import java.io.*;
import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class FileOutExam {

	public static void main(String[] args) {
		 	        String path = "C:/iotest";
	        File isDir = new File(path);
	        if (!isDir.exists()) {
	        	isDir.mkdirs();
	        }
	        
	        try (FileWriter writer = new FileWriter("C:/iotest/today.txt",true);
	        		PrintWriter out = new PrintWriter(writer);){
	        	LocalDate d = LocalDate.now();
	        	int year = d.getYear();
	        	int month = d.getMonthValue();
	        	int date = d.getDayOfMonth();
	        	DayOfWeek day = d.getDayOfWeek();
	        	String day1 = day.getDisplayName(TextStyle.FULL, Locale.KOREAN);
	        	
	        	out.printf("������ %d�� %d�� %d�� �Դϴ�.\r\n", year,month,date);
	        	out.printf("������ %s�Դϴ�. \r\n", day1);
	        	
	        	String name = "��ҹ�";
	        	LocalDate mydate = LocalDate.of(1995,03,01);
	        	DayOfWeek myday = mydate.getDayOfWeek();
	        	String myday1 = myday.getDisplayName(TextStyle.FULL, Locale.KOREAN);
	        	out.printf("%s�� %s�� �¾���ϴ�.%n", name,myday1);	      
	        	System.out.println("������ �Ϸ�Ǿ����ϴ�.");
	        } catch(Exception e) {
	        	System.out.println("������ �����ϴ� ���� ������ �߻��߽��ϴ�.");
	        }

	}

}
