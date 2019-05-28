package day3;

public class TimeTest {

	public static void main(String[] args) {

		int time = 32150;
		int h, m, s;

		h = time / 3600;
		m = time % 3600 / 60;
		s = time % 3600 % 60;
		System.out.printf("%d시간 %d분 %d초\n", h, m, s);

	}

}

/*
 * [ 실습 1 ] 연산자 실습
 * 1. TimeTest 라는 클래스를 생성한다.
 * 2. time 이라는 변수를 선언하여 32150(초) 이라는 값을 초기화 한다. 
 * 3. time 변수의 값으로 "XX시간 XX분 XX초" 형식으로 변환하여 출력한다.
 */