package day9.case4;

public class TVTest {
	public static void main(String args[]) {
		// SaleTV, RentalTV Ŭ������ ��ü�� ���� �����Ѵ�.
		SaleTV t1 = new SaleTV(300000, "SALETV-1", 40, 1);
		RentalTV t2 = new RentalTV(100000, "RENTALTV-1", 42, 1);

		// SaleTV ��ü�� ä���� �� �� ���δ�.
		t1.channelUp();
		t1.channelUp();

		// RentalTV ��ü�� ä���� �� �� ������.
		t2.chnnelDown();
		t2.chnnelDown();
		t2.chnnelDown();

		// �� ��ü�� ���Ͽ� printAllTV()�� ȣ���Ѵ�.
		printAllTV(t1);
		printAllTV(t2);

		// Rentable Ÿ���� ��ü�� RentalTV ��ü�� printRentalTV() �� ȣ���Ѵ�.
		printRentalTV(t2);
	}

	static void printAllTV(TV tv) {
		// �ƱԸ�Ʈ�� ���޵� ��ü�� toString() �� ȣ���Ͽ� �� ��ǰ�� ������ ����Ѵ�.
		System.out.println(tv.toString());

		// �ƱԸ�Ʈ�� ���޵� ��ü�� play() �� ȣ���Ѵ�.
		if (tv instanceof SaleTV) {
			((SaleTV) tv).play();
			// tv ������ ���޵� ��ü�� SaleTV Ÿ���̸� sale() �޼��带 ȣ���Ѵ�.
			((SaleTV) tv).sale();
		} else
			((RentalTV) tv).play();
	}

	static void printRentalTV(Rentable tv) {
		// �ƱԸ�Ʈ�� ���޵� Rentable ��ü�� rent() �޼��带 ȣ���Ѵ�.
		tv.rent();
	}
}
