package day9.case4;

public class SaleTV extends TV {

	private int price;

	SaleTV() {
	}

	SaleTV(int price, String model, int size, int channel) {
		super(model, size, channel);
		this.price = price;
	}

	void play() {
		System.out.printf("�Ǹ� TV ä�� %d���� ���θ� �÷��� �մϴ�.\n", getChannel());
	}

	void sale() {
		System.out.printf("%s ���� ��ǰ�� �Ǹ��մϴ�. %d �� ������ �ּ���.\n", getModel(), price);
	}

	public String toString() {
		return String.format("�ǸŻ�ǰ���� : �𵨸�(%s), ����(%,d��), ũ��(%d)", getModel(), price, getSize());

	}

}
