package day7;

import java.util.Scanner;

class CalculatorExpr {
	private int num1;
	private int num2;

	CalculatorExpr(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	int getAddition() {
		return num1 + num2;
	}

	int getSubtraction() {
		return num1 > num2 ? num1 - num2 : num2 - num1;
	}

	int getMultiplication() {
		return num1 * num2;
	}

	double getDivision() {
		return (num1 > num2 ? (double) num1 / num2 : (double) num2 / num1);
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

}

public class CalculatorTest {

	public static void main(String[] args) {

		int n1, n2;
		int input = 0;
		Scanner sc = new Scanner(System.in);
		do{
				System.out.print("���� �� �� �Է� : ");
				n1 = sc.nextInt();
				n2 = sc.nextInt();
				CalculatorExpr cal = new CalculatorExpr(n1, n2);
				System.out.print("����� ���� : ");
				System.out.println(n1 + ", " + n2);
				System.out.println("���� : " + cal.getAddition());
				System.out.println("���� : " + cal.getSubtraction());
				System.out.println("���� : " + cal.getMultiplication());
				System.out.println("������ : " + cal.getDivision());
				
				System.out.println("��� ���� �ϰڽ��ϱ�?(���:1) :");
				input=sc.nextInt();
			}
		while(input==1);
		System.out.println("�����մϴ�.");

sc.close();

}
}