package day3;

public class ArrayLab3 {

	public static void main(String[] args) {

		int i;
		int num = 10;
		int[] iArr = new int[num];
		char[] chArr = new char[num];

		for (i = 0; i < num; i++) {
			iArr[i] = (int) (Math.random() * 26) + 1;
			chArr[i] = (char) ('A' + iArr[i] - 1);
		}

		for (i = 0; i < num; i++) {
			if (i == num - 1)
				System.out.println(iArr[i]);
			else
				System.out.print(iArr[i] + ",");
		}

		for (i = 0; i < num; i++) {
			if (i == num - 1)
				System.out.println(chArr[i]);
			else
				System.out.print(chArr[i] + ",");
		}
	
	}

}

/*
 * [ �ǽ� 4 ] 
 * 1. ArrayLab3 �̶�� Ŭ������ �ϳ� �����. 
 * 2. 10 ���� ���Ҹ� ���� int Ÿ���� �迭�� ������ �Ŀ� �� �迭�� ������ ���Ұ����� 1���� 26 ������ ������ �����Ͽ� �����Ѵ�. 
 * 3. 10���� ���Ҹ� ���� char Ÿ���� �迭�� �����Ѵ�.
 * 4. 2������ ������ �迭�� ������ ���Ұ��� 3������ ������ �迭�� ���Ұ����� �����ϴµ� �� ���� 1�̸� 'A', 2 �̸� 'B', ...
 *    26�̸� 'Z'�� �����Ѵ�. 
 * 5. �� �迭�� ���Ұ��� ������ ���� ����Ѵ�.
 * 
 * 10,1,3,21,6,8,11,26,22,19 J,A,C,U,F,H,K,Z,V,S
 */