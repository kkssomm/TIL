package day6;

import java.util.Scanner;

public class ScannerLab2 {

	public static void main(String[] args) {

		String input1, input2;
		String ch;
		int num1, num2, result = 0;
		
		Scanner scanner = new Scanner(System.in);
		//입력된 숫자가 0이하면 첫 번째 숫자부터 다시 입력받게 한다.\
		//양의 값만 입력하세요!!"라는 메세지를 출력하고...
		do {
		System.out.print("첫 번째 숫자를 입력하세요 :");
		input1 = scanner.nextLine();
		num1 = Integer.parseInt(input1);
		if(num1<=0)
			System.out.println("양의 값만 입력하세요");
		} while(num1<=0); 
		
		do {	
		System.out.print("두 번째 숫자를 입력하세요 :");
		input2 = scanner.nextLine();
		num2 = Integer.parseInt(input2);
		if(num2<=0)
			System.out.println("양의 값만 입력하세요");
		}
		while(num2<=0);
		System.out.print("연산자(+,-,*,/)를 입력하세요 :");
		ch = scanner.next();
		scanner.close();

		switch (ch) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = Math.abs(num1 - num2);
			break;
		case "/":
			result = num1>num2?num1 / num2:num2/num1;
			break;
		default:
			result = num1 * num2;
		}

		System.out.println(num1 + "와 " + num2 + "의 " + ch + "연산 결과는 " + result + "입니다.");

	}

}
