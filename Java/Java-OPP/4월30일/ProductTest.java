package day6;

class Product {

	private String name;
	private int balance, price;

	Product() {
		this("��ũ����", 5, 10000);
	}

	Product(String name, int balance, int price) {
		this.name = name;
		this.balance = balance;
		this.price = price;
	}

	public String getName() { // Source > Generate Getters and Setters
		return name;
	}

	public int getBalance() {
		return balance;
	}

	public int getPrice() {
		return price;
	}
}

public class ProductTest{
	
	public static void main(String[] args) {
		Product productArr[] = new Product[5];
		productArr[0] = new Product();
		productArr[1] = new Product("��ī��",3,13000);
		productArr[2] = new Product("������",14,12000);
		productArr[3] = new Product("���̸�",13,4000);
		productArr[4] = new Product("���α�",1,1000000);
				
		for(Product data:productArr) {
			System.out.printf("%s\t%d\t%,d\n",
					data.getName(),data.getBalance(),data.getPrice());
		}
		
	}
}