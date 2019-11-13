package day6;

class Book {

	String title;
	String author;
	int price;

	Book() {
		title = "�ڹ��� ����";
		author = "���ü�";
		price = 10000;
	};

	Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price; // ��� ������ ���� ������ �̸��� ���Ƶ� ��
	}

	String getBookInfo() {
		return title + "\t" + author + "\t" + price;

	}

}

public class BookTest {

	public static void main(String[] args) {
		Book b1 = new Book();
		System.out.println(b1.getBookInfo());

		Book b2 = new Book("�ڹ� ������", "�����", 20000);
		System.out.println(b2.getBookInfo());

		Book b3 = new Book("JAVA training", "������", 40000);
		System.out.println(b3.getBookInfo());

		Book b4 = new Book("���� ���� �ڹ�", "ȫ�浿", 70000);
		System.out.println(b4.getBookInfo());

		Book b5 = new Book("�ڹ� ���ϸ�", "��ī��", 60000);
		System.out.println(b5.getBookInfo());

	}

}