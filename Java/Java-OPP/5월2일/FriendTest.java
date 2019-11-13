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
	String getInfo(){ // �������̵�
		return super.getInfo() +"\t"+phoneNum+"\t"+email;
	}
	
}

public class FriendTest {

	public static void main(String[] args) {
		
		Friend f[] = {new Friend("ȫ�浿","5321","qwer"),
				new Friend("�����","4921","asdf"),
				new Friend("������", "3521","zxcv"),
				new Friend("��ī��", "5324","uiop"),
				new Friend("�⼺��", "7532","hjkl")
		};
		
		for(Friend data : f) {
			System.out.println(data.getInfo());
		}
	}

}
