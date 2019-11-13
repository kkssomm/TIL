package day7;

class Person{
	
	private String name;
	Person(String name){
		this.name = name;
	}
	String getInfo() {
		return name;
	}
	
}

class Friend extends Person{
	
	private String phoneNum;
	private String email;
	Friend(String name, String phoneNum, String email){
		super(name);
		this.phoneNum = phoneNum;
		this.email = email;
	}
	String getInfo(){ // 오버라이딩
		return super.getInfo() +"\t"+phoneNum+"\t"+email;
	}
	
}

public class FriendTest {

	public static void main(String[] args) {
		
		Friend f[] = {new Friend("홍길동","5321","qwer"),
				new Friend("손흥민","4921","asdf"),
				new Friend("아이유", "3521","zxcv"),
				new Friend("피카츄", "5324","uiop"),
				new Friend("기성용", "7532","hjkl")
		};
		
		for(Friend data : f) {
			System.out.println(data.getInfo());
		}
	}

}
