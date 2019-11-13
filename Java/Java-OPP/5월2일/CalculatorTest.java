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
				System.out.print("숫자 두 개 입력 : ");
				n1 = sc.nextInt();
				n2 = sc.nextInt();
				CalculatorExpr cal = new CalculatorExpr(n1, n2);
				System.out.print("추출된 숫자 : ");
				System.out.println(n1 + ", " + n2);
				System.out.println("덧셈 : " + cal.getAddition());
				System.out.println("뺄셈 : " + cal.getSubtraction());
				System.out.println("곱셈 : " + cal.getMultiplication());
				System.out.println("나눗셈 : " + cal.getDivision());
				
				System.out.println("계속 진행 하겠습니까?(계속:1) :");
				input=sc.nextInt();
			}
		while(input==1);
		System.out.println("종료합니다.");

sc.close();

}
}