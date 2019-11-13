package exercise;

class Human {
	
	String name;
	int age;
	int height;
	int weight;
	
	Human() {
		
	}
	Human(String name, int age, int height, int weight){
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	String printInformation(){
		return name +"\t"+ age+"\t"+height+"\t"+weight;
	}
	
}

class Student extends Human {
	
	private String number;
	private String major;
	Student(){	
	}
	Student(String name, int age, int height, int weight, String number, String major){
		super(name, age, height, weight);
		this.number = number;
		this.major = major;
	}
	String printInformation() {
		return super.printInformation() + number +"\t"+ major;
	}
	
}

public class StudentTest {

	public static void main(String[] args) {
		
		Student arrays [] = new Student[3];
		arrays[0] = new Student("홍길동",20,171,81,"201101","영문");
		arrays[1] = new Student("고길동",21,183,72,"201102","건축");
		arrays[2] = new Student("박길동",22,175,65,"201103","컴공");
		
		for(int i = 0;i<3;i++) {
			System.out.println(arrays[i].printInformation());
		}

	}

}
