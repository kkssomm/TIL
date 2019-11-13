package day2;

public class ForLab1 {

	public static void main(String[] args) {
		int evenNum=0, oddNum=0;
		int i;
		for(i=1;i<=100;i++) {
			if(i%2==0)
				evenNum += i;
			else
				oddNum+= i;
		}
		
		System.out.println("1부터 100까지의 숫자들 중에서"
				+ "짝수의 합은" +evenNum+"이고 홀수의 합은"+ oddNum+"이다");
	}
}
