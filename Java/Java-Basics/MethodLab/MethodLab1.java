package day5;

public class MethodLab1 {

	public static void main(String[] args) {
		printCharacter('@', 3);
		printCharacter('%', 4);
		printCharacter('A', 5);
		printCharacter('°¡', 3);
	}

	static void printCharacter(char c, int num) {
		for (int i = 1; i <= num; i++)
			System.out.print(c);
		System.out.println();
	}

}
