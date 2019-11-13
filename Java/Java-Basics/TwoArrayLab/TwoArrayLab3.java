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
		 * R�� �䳢�̰� F�� ����� ������ ��ġ�� ������ �ְ� ������ ��ġ���� �밢���� �������θ� �̵� �����ϴ�. ���� ���� 2���� �迭 �����Ϳ���
		 * �䳢�� ��� ��ڴ°�?
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

		System.out.println("������ ��ġ : (" + fPosi + "," + fPosj + ")");

		// ����
		for (int j = 0; j < play[fPosi].length; j++) {
			if (play[fPosi][j] == 'R')
				catchNum++;
		}

		// ����
		for (int i = 0; i < play.length; i++) {
			if (play[i][fPosj] == 'R')
				catchNum++;
		}

		// �밢��
		for (int i = 0; i < play.length; i++) {
			for (int j = 0; j < play[i].length; j++) {		
				if ((i + j == fPosi + fPosj || fPosi-i == fPosj-j)&&(play[i][j]=='R'))
					catchNum++;
			}
		}

		System.out.printf("����� �䳢�� %d ���� ��´�.", catchNum);
	}
}
