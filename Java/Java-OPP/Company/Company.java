package emp;

public class Company {

	public static void main(String[] args) {
		// Employee �迭�� ��ü���� �����Ͽ� �����Ѵ�.
		Employee[] emp = new Employee[2];
		emp[0] = new Secretary("Duke", 1, "secretary", 800);
		emp[1] = new Sales("Tuxi", 2, "sales", 1200);

		// printEmployee()  �޼��带 ȣ���Ͽ� Employee �迭�� ��ü�� ������ ����Ѵ�.
        // �� ���� ������ ������� �ʴ´�.
		printEmployee(emp, false); 
		
        // ��� �������� �μ�Ƽ��� 100�� �����Ѵ�.(������ ���� ����Ǵ� �μ�Ƽ�� �ݾ��� �ٸ���. 
		System.out.println("\n[�μ�Ƽ��100����]");
		for(Employee data: emp)
			((Bonus)data).incentive(100);
		
		// printEmployee()  �޼��带 ȣ���Ͽ� Employee �迭�� ��ü�� ������ ������ ����Ѵ�.    
		printEmployee(emp, true);
	}
	
	// ��ü�� ������ ����Ѵ�.(���� ����� ����)
	public static void printEmployee(Employee[] emp, boolean isTax) {
		 // isTax �� ��/���� ���ο� ���� �ؽ� ��� ���θ� �����Ͽ� ó���Ѵ�.
		if (isTax == true) {
			System.out.println("name\tdepartment\tsalary\ttax\textra pay\t");
			System.out.println("-----------------------------------------------");
			for (int i = 0; i < emp.length; i++) {
				System.out.print(emp[i].getName() + "\t");
				System.out.print(emp[i].getDepartment() + "\t");
				System.out.print(emp[i].getSalary() + "\t");
				System.out.print(emp[i].tax() + "\t");
				if (emp[i] instanceof Sales) {
					System.out.println(((Sales) emp[i]).getExtraPay());
				}
				else
					System.out.println();
			}
		
		} else {
			System.out.println("name\tdepartment\tsalary\textra pay\t");
			System.out.println("-----------------------------------------");
			for (int i = 0; i < emp.length; i++) {
				System.out.print(emp[i].getName() + "\t");
				System.out.print(emp[i].getDepartment() + "\t");
				System.out.print(emp[i].getSalary() + "\t");
				if (emp[i] instanceof Sales) {
					System.out.println(((Sales) emp[i]).getExtraPay());
				}
				else
					System.out.println();
			}
		}

	}

}
