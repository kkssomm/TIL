package day3;

public class WhileLab2 {

	public static void main(String[] args) {
		int count=0;
		int num;
		//int c;

		while(true) {
			num = (int) (Math.random() * 31);
			if((num ==0) || ((num>=27)&&(num<=30))) 
				break;
	
			System.out.printf("%c(%d)\n", 'A'+num-1,num);
			count++;
		}
		System.out.printf("수행횟수는 %d번 입니다\n",count);
	}

}
