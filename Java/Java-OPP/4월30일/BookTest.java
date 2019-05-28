package day6;

class Book {

	String title;
	String author;
	int price;

	Book() {
		title = "자바의 정석";
		author = "남궁성";
		price = 10000;
	};

	Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price; // 멤버 변수와 지역 변수의 이름은 같아도 됨
	}

	String getBookInfo() {
		return title + "\t" + author + "\t" + price;

	}

}

public class BookTest {

	public static void main(String[] args) {
		Book b1 = new Book();
		System.out.println(b1.getBookInfo());

		Book b2 = new Book("자바 길잡이", "손흥민", 20000);
		System.out.println(b2.getBookInfo());

		Book b3 = new Book("JAVA training", "아이유", 40000);
		System.out.println(b3.getBookInfo());

		Book b4 = new Book("쉽게 배우는 자바", "홍길동", 70000);
		System.out.println(b4.getBookInfo());

		Book b5 = new Book("자바 포켓몬", "피카츄", 60000);
		System.out.println(b5.getBookInfo());

	}

}