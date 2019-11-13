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

		System.out.print("변환된 배열 :");
		for (i = 0; i < arr.length; i++) {
			if (i == arr.length - 1)
				System.out.println(arr[i]);
			else
				System.out.print(arr[i] + ",");
		}
	}

}
/*
 * [ 실습 3 ] 
 * 1. ArrayLab2 라는 클래스를 하나 만든다. 
 * 2. 'J', 'a', 'v', 'a' 라는 원소들로 구성되는 char 타입의 배열을 만든다. 
 * 3. 각 원소들의 값에서 대문자는 소문자로 소문자는 대문자로 변환한다.
 * 4. 수행 결과 :
 * 
 * 변환된 배열 : j,A,V,A
 */