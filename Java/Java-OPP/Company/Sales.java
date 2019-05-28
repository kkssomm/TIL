package emp;

public class Sales extends Employee implements Bonus{
	
	Sales(){
		
	}
	
	Sales(String name, int number, String department, int salary){
		super(name, number, department+"\t", salary);
		
	}
	
	public double tax() {
		return getSalary() * 0.13;
	}
	
	public void incentive(int pay) {
		setSalary((int) (getSalary()+ pay*1.20));
	}
	
	double getExtraPay() {
		return getSalary()*0.03;
	}
	
}
