package day1;

public class IfTest4 {

	public static void main(String[] args) {
		
		int score = (int)(Math.random()*101); //1~100
		//if���� ����Ͽ�
		//90~100 = "xx���� A���"
		//80~89 = "xx���� B���"
		//70~79 = "xx���� C���"
		//60~69 = "xx���� D���"
		//0~59 = "xx���� F���"
		
		if(score>=90) 
			System.out.println(score+"���� A���");
		else if(score>=80) 
			System.out.println(score+"���� B���");
		else if(score>=70) 
			System.out.println(score+"���� C���");		
		else if(score>=60) 
			System.out.println(score+"���� D���");
		else
			System.out.println(score+"���� F���");

	}

}
