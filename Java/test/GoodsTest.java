package test;

public class GoodsTest {
	public static void main(String[] args) {
		Goods g1 = new Goods("PRD-0001", "듀크컴퓨터", 10000, 'N');
		Goods g2 = new Goods("PRD-0002", "턱시컴퓨터", 20000);
		System.out.println(g1.getGoodInfo());
		System.out.println(g2.getGoodInfo());
	}
}
