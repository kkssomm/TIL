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

		System.out.print("모든 원소의 값 :");
		for (i = 0; i < arr.length; i++)
			if(i==arr.length-1)
				System.out.println(arr[i]);
			else
				System.out.print(arr[i] + ",");

		System.out.println("모든 원소의 합 :" + sum);
	}

}

/*
 * [ 실습 2 ]
 * 1. ArrayLab1 이라는 클래스를 하나 만든다. 
 * 2. 10개의 숫자(정수)를 저장할 수 있는 배열을 하나 만든다. 
 * 3. 각각의 원소에 4부터 20사이의 난수를 추출하여 저장한다. 
 * 4. 모든 원소의 합을 구한다. 5. 다음과 같은 형식으로 출력한다.
 * 
 * 모든 원소의 값 : x,x,x,x,x,x,x,x,x,x 모든 원소의 합 : x
 */