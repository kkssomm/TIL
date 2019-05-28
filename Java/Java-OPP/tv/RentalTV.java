package day9.case4;

public class RentalTV extends TV implements Rentable {
	private int price;

	RentalTV() {
	}

	RentalTV(int price, String model, int size, int channel) {
		super(model, size, channel);
		this.price = price;
	}

	void play() {
		System.out.printf("�뿩 TV ä�� %d���� ���θ� �÷��� �մϴ�.\n", getChannel());
	}

	public void rent() {
		System.out.printf("%s ���� ��ǰ�� �뿩�մϴ�. %d �� ������ �ּ���.\n", getModel(), price);

	}

	public String toString() {
		return String.format("�뿩��ǰ���� : �𵨸�(%s), ����(%,d��), ũ��(%d)", getModel(), price, getSize());
	}

}
