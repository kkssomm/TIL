package day6;

import java.util.Scanner;

public class ScannerLab1 {

	public static void main(String[] args) {

		String input1, input2;
		String ch;
		int num1, num2, result = 0;
		System.out.print("ù ��° ���ڸ� �Է��ϼ��� :");
		Scanner scanner = new Scanner(System.in);
		input1 = scanner.nextLine();
		num1 = Integer.parseInt(input1);
		System.out.print("�� ��° ���ڸ� �Է��ϼ��� :");
		input2 = scanner.nextLine();
		num2 = Integer.parseInt(input2);
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
		case "*":
			result = num1 * num2;
			break;
		}

		System.out.println(num1 + "�� " + num2 + "�� " + ch + "���� ����� " + result + "�Դϴ�.");

	}

}
