package day2;

public class ForLab2 {

	public static void main(String[] args) {
		
		int num1 = (int)(Math.random()*7)+3;
		int num2 = (int)(Math.random()*3)+1;
		int i;
		
		if(num2==1)
			for(i=0;i<num1;i++)
				System.out.print('*');
		else if(num2==2)
			for(i=0;i<num1;i++)
				System.out.print('$');
		else if(num2==3)
			for(i=0;i<num1;i++)
				System.out.print('#');
		
	}

}
