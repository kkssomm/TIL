package day6;

class SalaryExpr {

	int bonus;

	SalaryExpr() {
		this(0);
	}

	public SalaryExpr(int bonus) {
		this.bonus = bonus;
	}

	public int getSalary(int grade) {
		switch (grade) {
		case 1:
			return bonus + 100;
		case 2:
			return bonus + 90;
		case 3:
			return bonus + 80;
		case 4:
			return bonus + 70;
		}
		return 0;
	}

}

public class SaleryExam {

	public static void main(String[] args) {
		int month, grade;

		month = (int) (Math.random() * 12) + 1; // 월정보
		grade = (int) (Math.random() * 4) + 1;

		if (month % 2 == 0) {
			SalaryExpr salary = new SalaryExpr(100);
			// System.out.println(salary.getSalary(grade));
			System.out.printf("%d월 %d 등급의 월급은 %d입니다.\n", month, grade, salary.getSalary(grade));
		}

		else {
			SalaryExpr salary = new SalaryExpr();
			// System.out.println(salary.getSalary(grade));
			System.out.printf("%d월 %d 등급의 월급은 %d입니다.\n", month, grade, salary.getSalary(grade));
		}

	}
}