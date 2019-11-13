package test;

public class Goods {
	String prodId; // 상품 아이디
	String prodName; // 상품 이름
	int price; // 상품 가격
	char asYn; // AS 가능 여부

	Goods(String prodId, String prodName, int price) {
		this.prodId = prodId;
		this.prodName = prodName;
		this.price = price;
		this.asYn = 'Y';
	}

	Goods(String prodId, String prodName, int price, char asYn) {
		this.prodId = prodId;
		this.prodName = prodName;
		this.price = price;
		this.asYn = asYn;
	}

	String getGoodInfo() {
		if (asYn == 'Y')
			return String.format("상품ID : %s, 상품명 : %s, 가격 : %,d, AS가능여부 : %s", prodId, prodName, price, "가능");
		else
			return String.format("상품ID : %s, 상품명 : %s, 가격 : %,d, AS가능여부 : %s", prodId, prodName, price, "불가");

	}
}
