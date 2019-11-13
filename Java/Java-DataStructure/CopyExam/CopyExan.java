package day13;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CopyExan {

	public static void main(String[] args) {
		GregorianCalendar gc = new GregorianCalendar();
		int year = gc.get(Calendar.YEAR);
		int month = gc.get(Calendar.MONTH)+1;
		int day =gc.get(Calendar.DATE);
		
		try(FileReader reader = new FileReader("c:/iotest/sample.txt");
				BufferedReader br = new BufferedReader(reader);
			FileWriter writer = new FileWriter("c:/iotest/sample_"+year+
					"_"+month+"_"+day+".txt",true);
				PrintWriter out = new PrintWriter(writer);){
			String data;
			while(true) {
				data =br.readLine();
				if(data == null)
					break;
				out.printf("%s%n", data); // = \r\n = %n
			}
			System.out.println("저장완료되었습니다");
		} catch(IOException e) {
			System.out.println("처리하는 동안 오류가 발생했습니다.");
		}
	
	}

}
