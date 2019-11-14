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
	        	
	        	out.printf("오늘은 %d년 %d월 %d일 입니다.\r\n", year,month,date);
	        	out.printf("오늘은 %s입니다. \r\n", day1);
	        	
	        	String name = "김소미";
	        	LocalDate mydate = LocalDate.of(1995,03,01);
	        	DayOfWeek myday = mydate.getDayOfWeek();
	        	String myday1 = myday.getDisplayName(TextStyle.FULL, Locale.KOREAN);
	        	out.printf("%s은 %s에 태어났습니다.%n", name,myday1);	      
	        	System.out.println("저장이 완료되었습니다.");
	        } catch(Exception e) {
	        	System.out.println("파일을 저장하는 동안 오류가 발생했습니다.");
	        }

	}

}
