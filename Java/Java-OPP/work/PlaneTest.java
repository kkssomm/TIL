package work;

public class PlaneTest {

	public static void main(String[] args) {
		
        // Airplane과 Cargoplane 객체 생성
		Plane p[] =new Plane[2];
		p[0] = new Airplane("L747",1000);
		p[1] = new Cargoplane("C40",1000);
		
        // 생성된 객체의 정보 출력
		printInfo(p);
		System.out.println();
		
        // Airplane과 Cargoplane 객체에 100씩 운항 후 객체 정보 출력
		p[0].flight(100);
		p[1].flight(100);
		System.out.println("[100운항]");
		printInfo(p);
		System.out.println();
		
        // Airplane과 Cargoplane 객체에 200 주유 후 객체 정보 출력
		p[0].refuel(200);
		p[1].refuel(200);
		System.out.println("[200주유]");
		printInfo(p);
    }
public static void printInfo(Plane[] list) {
        // 타이틀 출력
	System.out.println("Plane\tfuelSize");
	System.out.println("------------------");
    
	// Plane 객체들의 데이터 출력(출력 결과 참조)
	for(Plane data : list) {
		System.out.println(data.getPlaneName()+"\t"+data.getFuelSize());
	}
    	}

}
