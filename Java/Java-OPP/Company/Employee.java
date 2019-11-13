package emp;

public abstract class Employee {

	private String name;
	private String department; //�μ�
	private int number;
	private int salary; //����

	Employee(){
		
	}
	
	Employee(String name, int number, String department, int salary){
		this.name = name;
		this.number =number;
		this.department = department;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public abstract double tax();
	
	
}
