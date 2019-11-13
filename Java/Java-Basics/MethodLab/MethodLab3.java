package day5;

public class MethodLab3 {

	public static void main(String[] args) {
		System.out.print(getRandom(10) + ",");
		System.out.print(getRandom(10) + ",");
		System.out.print(getRandom(10) + ",");
		System.out.print(getRandom(10) + ",");
		System.out.println(getRandom(10));

		System.out.print(getRandom(10, 20) + ",");
		System.out.print(getRandom(10, 20) + ",");
		System.out.print(getRandom(10, 20) + ",");
		System.out.print(getRandom(10, 20) + ",");
		System.out.println(getRandom(10, 20));

	}

	static int getRandom(int n) {
		return (int) (Math.random() * n) + 1;
	}

	static int getRandom(int n1, int n2) {
		return (int) (Math.random() * (n2 - n1 + 1)) + n1;
	}

}
