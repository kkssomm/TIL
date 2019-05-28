package mobile;

class MobileTest {
	public static void main(String args[]) {
		Ltab m1 = new Ltab("Ltab", 500, "ABC-01");
		Otab m2 = new Otab("Otab", 1000, "XYZ-20");

		printTitle();
		printMobile(m1);
		printMobile(m2);
		System.out.println();
		
		m1.charge(10);
		m2.charge(10);
		System.out.println("[10분 충전]");
		printTitle();
		printMobile(m1);
		printMobile(m2);
		System.out.println();
		
		m1.operate(5);
		m2.operate(5);
		System.out.println("[5분 통화]");
		printTitle();
		printMobile(m1);
		printMobile(m2);
	}

	public static void printMobile(Mobile mobile) {
		System.out.println(mobile.getMobileName()+"\t"+mobile.getBatterySize()+"\t"+mobile.getOsType());

	}

	public static void printTitle() {
		System.out.println("Mobile\tBattery\tOsType");
		System.out.println("--------------------------------");
	}
}