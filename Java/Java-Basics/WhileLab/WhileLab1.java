package day3;

public class WhileLab1 {

	public static void main(String[] args) {
		int i = 1, j = 1;
		int num = (int) (Math.random() * 6) + 5;

		System.out.println("[for 결과]");
		for (i = 1; i <= num; i++) {
			System.out.printf("%d -> %d\n", i, i * i);
		}

		System.out.println("[ while 결과]");
		while (j <= num) {
			System.out.printf("%d -> %d\n", j, j * j);
			j++;
		}

	}

}
