package day3;

public class ArrayLab1 {

	public static void main(String[] args) {

		int i;
		int sum = 0;
		int[] arr = new int[10];

		for (i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 17) + 4;
			sum += arr[i];
		}

		System.out.print("��� ������ �� :");
		for (i = 0; i < arr.length; i++)
			if(i==arr.length-1)
				System.out.println(arr[i]);
			else
				System.out.print(arr[i] + ",");

		System.out.println("��� ������ �� :" + sum);
	}

}

/*
 * [ �ǽ� 2 ]
 * 1. ArrayLab1 �̶�� Ŭ������ �ϳ� �����. 
 * 2. 10���� ����(����)�� ������ �� �ִ� �迭�� �ϳ� �����. 
 * 3. ������ ���ҿ� 4���� 20������ ������ �����Ͽ� �����Ѵ�. 
 * 4. ��� ������ ���� ���Ѵ�. 5. ������ ���� �������� ����Ѵ�.
 * 
 * ��� ������ �� : x,x,x,x,x,x,x,x,x,x ��� ������ �� : x
 */