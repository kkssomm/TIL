package day2;

public class ForLab3 {

	public static void main(String[] args) {
		char c = '&';
		int num = (int)(Math.random()*5)+5;
		int i,j;
		
		while(num==5 || num ==7) {
			for(i=0;i<num;i++) {
				for(j=0;j<=i;j++) {
					System.out.print(c);
				}
			System.out.println();
			}
		break;
		}
	}

}
