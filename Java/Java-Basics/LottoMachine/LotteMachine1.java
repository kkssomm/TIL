
/*
 * [ �ǽ� ] �ڹ��� ��� ~ �⺻ �迭
 * 
 * 1. LottoMachine1 �̶�� Ŭ������ �����Ѵ�. 2. 1���� 45 ������ 6���� �����Ͽ� ���� �������� ����Ѵ�. ��, 6��
 * ���ڴ� �ߺ��� ������� �ʴ´�.
 * 
 * [ ������� ]
 * 
 * ������ �ζ� ��ȣ - x, x, x, x, x, x
 */

package day4;

public class LotteMachine1 {

	public static void main(String[] args) {

		int[] nums = new int[6];
		int i, j;

		System.out.print("������ �ζ� ��ȣ - ");

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