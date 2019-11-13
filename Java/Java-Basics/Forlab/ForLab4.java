package day3;

public class ForLab4 {

	public static void main(String[] args) {
		int i, j;
		char STAR = '*';

		for (i = 0; i < 7; i++) {
			for (j = 0; j < 7 - i; j++) {
				System.out.print(STAR);
			}
			System.out.println();
		}

	}

}
