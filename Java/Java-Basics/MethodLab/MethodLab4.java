package day5;

public class MethodLab4 {

	public static void main(String[] args) {
		
		int[] arr1 ={10,20,30};
		int[] arr2 ={100,500,300,200,400};
		int[] arr3 = {1,10,3,4,5,8,7,6,9,2};
		
		System.out.printf("가장 큰 값은 %d입니다.\n",maxNumArray(arr1));
		System.out.printf("가장 큰 값은 %d입니다.\n",maxNumArray(arr2));
		System.out.printf("가장 큰 값은 %d입니다.\n",maxNumArray(arr3));

	}

	static int maxNumArray(int[] n) {
		int i;
		int max = n[0];
		for(i=1;i<n.length;i++) {
			if(n[i]>max)
				max=n[i];
		}
		return max;
	}
}
