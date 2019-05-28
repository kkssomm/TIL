
/*
 * [ 실습 ] 자바의 제어문 ~ 기본 배열
 * 
 * 1. LottoMachine1 이라는 클래스를 생성한다. 2. 1부터 45 사이의 6개를 추출하여 다음 형식으로 출력한다. 단, 6개
 * 숫자는 중복을 허용하지 않는다.
 * 
 * [ 출력형식 ]
 * 
 * 오늘의 로또 번호 - x, x, x, x, x, x
 */

package day4;

public class LotteMachine1 {

	public static void main(String[] args) {

		int[] nums = new int[6];
		int i, j;

		System.out.print("오늘의 로또 번호 - ");

		for (i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 40) + 6;

			j=i;
			while(j!=0) {
				j--;
				if(nums[i]==nums[j]) {
					i--;
					break;
				}
		
			}
		}
		
		for(i=0;i<nums.length;i++) {	
			if (i == nums.length - 1)
				System.out.print(nums[i]);
			else
				System.out.print(nums[i] + ", ");
			
		}

	}

}