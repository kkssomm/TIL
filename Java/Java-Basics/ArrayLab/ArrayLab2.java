package day3;

public class ArrayLab2 {

	public static void main(String[] args) {

		int i, k;
		char[] arr = new char[] { 'J', 'a', 'v', 'a' };

		k = 'a' - 'A';

		for (i = 0; i < arr.length; i++) {
			if (arr[i] >= 'A' && arr[i] <= 'Z')
				arr[i] = (char) (arr[i] + k);
			else if (arr[i] >= 'a' && arr[i] <= 'z')
				arr[i] = (char) (arr[i] - k);
		}

		System.out.print("��ȯ�� �迭 :");
		for (i = 0; i < arr.length; i++) {
			if (i == arr.length - 1)
				System.out.println(arr[i]);
			else
				System.out.print(arr[i] + ",");
		}
	}

}
/*
 * [ �ǽ� 3 ] 
 * 1. ArrayLab2 ��� Ŭ������ �ϳ� �����. 
 * 2. 'J', 'a', 'v', 'a' ��� ���ҵ�� �����Ǵ� char Ÿ���� �迭�� �����. 
 * 3. �� ���ҵ��� ������ �빮�ڴ� �ҹ��ڷ� �ҹ��ڴ� �빮�ڷ� ��ȯ�Ѵ�.
 * 4. ���� ��� :
 * 
 * ��ȯ�� �迭 : j,A,V,A
 */