package day7;

import java.util.Scanner;

class GradeExpr {
	int[] jumsu;

	GradeExpr(int jumsu[]) {
		this.jumsu = jumsu;
	}

	double getAverage() {
		int sum = 0;
		int i;
		for (i = 0; i < this.jumsu.length; i++) {
			sum += jumsu[i];
		}
		return (double) (sum / i);
	}

	int getTotal() {
		int sum = 0;
		int i;
		for (i = 0; i < jumsu.length; i++) {
			sum += jumsu[i];
		}
		return sum;
	}

	int getGoodScore() {
		int max = jumsu[0];
		for (int i = 1; i < this.jumsu.length; i++) {
			if (max < jumsu[i])
				max = jumsu[i];
		}
		return max;
	}

	int getBadScore() {
		int min = jumsu[0];
		for (int i = 1; i < this.jumsu.length; i++) {
			if (min > jumsu[i])
				min = jumsu[i];
		}
		return min;
	}
}

public class GradeTest {

	public static void main(String[] args) {
		int n;
		int i;

		Scanner sc = new Scanner(System.in);
		System.out.print("점수 개수 입력 : ");
		n = sc.nextInt();
		int[] jumsu = new int[n];

		System.out.print("점수 입력 : ");
		for (i = 0; i < n; i++) {
			jumsu[i] = sc.nextInt();
		}

		System.out.print("점수들 : ");
		for (i = 0; i < n - 1; i++) {
			System.out.print(jumsu[i] + ",");
		}
		System.out.println(jumsu[i]);

		GradeExpr g = new GradeExpr(jumsu);

		System.out.println("총점 : " + g.getAverage());
		System.out.println("평균 : " + g.getTotal());
		System.out.println("최고점수 : " + g.getGoodScore());
		System.out.println("최저점수 : " + g.getBadScore());

		sc.close();

	}

}
