package test;

public class WordTest {
	public static void main(String[] args) {
		WordCount a = new WordCount();
		System.out.println("결과 1  : " + a.counter("java jdbc sql html5 css javascript", true));
		System.out.println("결과 2  : " + a.counter("java jdbc sql html5 css javascript", false));
	}
}

class WordCount {

	String word;
	int count;
	boolean isTrue;

	int counter(String word, boolean isTrue) {
		if (isTrue == true) {
			int count = 1;
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == ' ')
					count++;
			}
			return count;
		} else {
			return word.length();
		}
	}
}
