package day8;

class Multiplication {

	private int dan;
	private int number;

	Multiplication() {
	}

	Multiplication(int dan) {
		this.dan = dan;
	}

	Multiplication(int dan, int number) {
		this.dan = dan;
		this.number = number;
	}

	void printPart() {
		if (number == 0) {
			for (int n = 1; n <= 9; n++)
				System.out.print("\t" + dan + "*" + n + "=" + dan * n);
			System.out.println();
		} else {
			System.out.println(dan * number);
		}
	}
}

class GuGuDanExpr extends Multiplication {
	GuGuDanExpr() {

	}

	GuGuDanExpr(int dan) {
		super(dan);
	}

	GuGuDanExpr(int dan, int number) {
		super(dan, number);
	}

	static void printAll() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++)
				System.out.print("\t" + i + "*" + j + "=" + i * j);
			System.out.println();
		}
	}
}

public class GuGuDan {

	public static void main(String[] args) {

		int dan = day5.MethodLab3.getRandom(20);
		int num = day5.MethodLab3.getRandom(20);
		//System.out.println(dan + "," + num);

		if (num >= 1 && num <= 9 && dan >= 1 && dan <= 9) {
			GuGuDanExpr g = new GuGuDanExpr(dan, num);

			System.out.print("\t" + dan + "*" + num + "=");
			g.printPart();
		}

		else if (num >= 10 && dan >= 1 && dan <= 9) {
			GuGuDanExpr g = new GuGuDanExpr(dan);

			g.printPart();
		}

		else if (dan >= 10) {
			GuGuDanExpr.printAll();
		}
	}

}
