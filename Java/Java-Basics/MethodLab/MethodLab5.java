package day5;

public class MethodLab5 {

	public static void main(String[] args) {
		
		int r1[] = powerArray(2);
		int r2[] = powerArray(3);
		int r3[] = powerArray(4);
		int i;
		
		for (i=0;i<r1.length-1;i++)
			System.out.print(r1[i]+",");
		System.out.println(r1[i]);
		
		for (i=0;i<r2.length-1;i++)
			System.out.print(r2[i]+",");
		System.out.println(r2[i]);
		
		for (i=0;i<r3.length-1;i++)
			System.out.print(r3[i]+",");
		System.out.println(r3[i]);

	}

	static int[] powerArray(int n) {
		int[] nums = new int[10];
		for(int i=0;i<nums.length;i++)
			nums[i]= (i+1)*n;
		return nums;
	}
}
