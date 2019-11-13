package day4;

public class TwoArrayLab3 {
	public static void main(String[] args) {
		char play[][] = { 
				{ 'X', 'X', 'X', 'R', 'X', 'R' },
				{ 'R', 'X', 'X', 'X', 'F', 'X' },
				{ 'X', 'X', 'R', 'X', 'X', 'X' }, 
				{ 'R', 'X', 'X', 'X', 'X', 'X' }, 
				{ 'X', 'R', 'X', 'X', 'X', 'X' },
				{ 'X', 'R', 'X', 'R', 'X', 'R' },
				};

		int catchNum = 0;
		/*
		 * R은 토끼이고 F는 여우다 여우의 위치는 정해져 있고 정해진 위치에서 대각선과 직선으로만 이동 가능하다. 위와 같은 2차원 배열 데이터에서
		 * 토끼를 몇마리 잡겠는가?
		 */
		int fPosi = 0;
		int fPosj = 0;

		// System.out.println(fPosj[3][3]);
		pos: for (int i = 0; i < play.length; i++) {
			for (int j = 0; j < play[i].length; j++) {
				if (play[i][j] == 'F') {
					fPosi = i;
					fPosj = j;
					break pos;
				}
			}
		}

		System.out.println("여우의 위치 : (" + fPosi + "," + fPosj + ")");

		// 가로
		for (int j = 0; j < play[fPosi].length; j++) {
			if (play[fPosi][j] == 'R')
				catchNum++;
		}

		// 세로
		for (int i = 0; i < play.length; i++) {
			if (play[i][fPosj] == 'R')
				catchNum++;
		}

		// 대각선
		for (int i = 0; i < play.length; i++) {
			for (int j = 0; j < play[i].length; j++) {		
				if ((i + j == fPosi + fPosj || fPosi-i == fPosj-j)&&(play[i][j]=='R'))
					catchNum++;
			}
		}

		System.out.printf("여우는 토끼를 %d 마리 잡는다.", catchNum);
	}
}
