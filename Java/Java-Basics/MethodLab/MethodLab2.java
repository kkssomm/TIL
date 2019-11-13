package day5;

public class MethodLab2 {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			int x = (int) (Math.random() * 30) + 1;
			int y = (int) (Math.random() * 30) + 1;

			System.out.printf("%d와 %d의 차는 %d 입니다.\n", x, y, diff(x, y));
		}
	}

	static int diff(int x, int y) {
		return Math.abs(x - y);
	}

}
