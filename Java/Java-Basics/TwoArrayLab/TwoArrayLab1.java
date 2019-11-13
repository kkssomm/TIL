package day4;

public class TwoArrayLab1 {

	public static void main(String[] args) {
		char[][] chArr = { 
			{ 'B', 'C', 'A', 'A'},
			{'C', 'C', 'B', 'B' },
			{'D', 'A', 'A', 'D' }, 
			};
		
		int[] iArr = new int[4];
		
		int i,j;
		int row= chArr.length, col = chArr[row-1].length;
		
		for(i=0;i<row;i++) {
			for(j=0;j<col;j++) {
				switch(chArr[i][j]) {
				case 'A':
					iArr[0]++;
					break;
				case 'B':
					iArr[1] = iArr[1]+1;
					break;
				case 'C':
					iArr[2]++;
					break;
				case 'D':
					iArr[3]++;
					break;
				}
			}
		}
		
		for(i=0;i<4;i++) {
			System.out.printf("%c는 %d개 입니다.",'A'+i, iArr[i]);
		}

	}
}
