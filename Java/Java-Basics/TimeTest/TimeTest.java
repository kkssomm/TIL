package day3;

public class TimeTest {

	public static void main(String[] args) {

		int time = 32150;
		int h, m, s;

		h = time / 3600;
		m = time % 3600 / 60;
		s = time % 3600 % 60;
		System.out.printf("%d�ð� %d�� %d��\n", h, m, s);

	}

}

/*
 * [ �ǽ� 1 ] ������ �ǽ�
 * 1. TimeTest ��� Ŭ������ �����Ѵ�.
 * 2. time �̶�� ������ �����Ͽ� 32150(��) �̶�� ���� �ʱ�ȭ �Ѵ�. 
 * 3. time ������ ������ "XX�ð� XX�� XX��" �������� ��ȯ�Ͽ� ����Ѵ�.
 */