package work;

public class PlaneTest {

	public static void main(String[] args) {
		
        // Airplane�� Cargoplane ��ü ����
		Plane p[] =new Plane[2];
		p[0] = new Airplane("L747",1000);
		p[1] = new Cargoplane("C40",1000);
		
        // ������ ��ü�� ���� ���
		printInfo(p);
		System.out.println();
		
        // Airplane�� Cargoplane ��ü�� 100�� ���� �� ��ü ���� ���
		p[0].flight(100);
		p[1].flight(100);
		System.out.println("[100����]");
		printInfo(p);
		System.out.println();
		
        // Airplane�� Cargoplane ��ü�� 200 ���� �� ��ü ���� ���
		p[0].refuel(200);
		p[1].refuel(200);
		System.out.println("[200����]");
		printInfo(p);
    }
public static void printInfo(Plane[] list) {
        // Ÿ��Ʋ ���
	System.out.println("Plane\tfuelSize");
	System.out.println("------------------");
    
	// Plane ��ü���� ������ ���(��� ��� ����)
	for(Plane data : list) {
		System.out.println(data.getPlaneName()+"\t"+data.getFuelSize());
	}
    	}

}
