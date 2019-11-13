package day1;

public class IfTest4 {

	public static void main(String[] args) {
		
		int score = (int)(Math.random()*101); //1~100
		//if문을 사용하여
		//90~100 = "xx점은 A등급"
		//80~89 = "xx점은 B등급"
		//70~79 = "xx점은 C등급"
		//60~69 = "xx점은 D등급"
		//0~59 = "xx점은 F등급"
		
		if(score>=90) 
			System.out.println(score+"점은 A등급");
		else if(score>=80) 
			System.out.println(score+"점은 B등급");
		else if(score>=70) 
			System.out.println(score+"점은 C등급");		
		else if(score>=60) 
			System.out.println(score+"점은 D등급");
		else
			System.out.println(score+"점은 F등급");

	}

}
