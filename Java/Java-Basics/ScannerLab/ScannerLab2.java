package day6;

import java.util.Scanner;

public class ScannerLab2 {

	public static void main(String[] args) {

		String input1, input2;
		String ch;
		int num1, num2, result = 0;
		
		Scanner scanner = new Scanner(System.in);
		//�Էµ� ���ڰ� 0���ϸ� ù ��° ���ں��� �ٽ� �Է¹ް� �Ѵ�.\
		//���� ���� �Է��ϼ���!!"��� �޼����� ����ϰ�...
		do {
		System.out.print("ù ��° ���ڸ� �Է��ϼ��� :");
		input1 = scanner.nextLine();
		num1 = Integer.parseInt(input1);
		if(num1<=0)
			System.out.println("���� ���� �Է��ϼ���");
		} while(num1<=0); 
		
		do {	
		System.out.print("�� ��° ���ڸ� �Է��ϼ��� :");
		input2 = scanner.nextLine();
		num2 = Integer.parseInt(input2);
		if(num2<=0)
			System.out.println("���� ���� �Է��ϼ���");
		}
		while(num2<=0);
		System.out.print("������(+,-,*,/)�� �Է��ϼ��� :");
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

		System.out.println(num1 + "�� " + num2 + "�� " + ch + "���� ����� " + result + "�Դϴ�.");

	}

}
