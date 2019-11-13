package day6;

class Member{
	String name;
	String account;
	String passwd;
	int birthyear;
}

public class MemberTest {

	public static void main(String[] args) {
		Member m1 = new Member();
		m1.name = "홍길동";
		m1.account = "hgd";
		m1.passwd = "aaaa";
		m1.birthyear = 1850;
		System.out.printf("회원1 : %s(%s, %s, %d)\n",
				m1.name,m1.account,m1.passwd,m1.birthyear );
		
		Member m2 = new Member();
		m2.name = "손흥민";
		m2.account = "shm";
		m2.passwd = "bbbb";
		m2.birthyear = 1990;
		System.out.printf("회원2 : %s(%s, %s, %d)\n",
				m2.name,m2.account,m2.passwd,m2.birthyear );
		
		Member m3 = new Member();
		m3.name = "아이유";
		m3.account = "iu";
		m3.passwd = "cccc";
		m3.birthyear = 1993;
		System.out.printf("회원3 : %s(%s, %s, %d)\n",
				m3.name,m3.account,m3.passwd,m3.birthyear );
	}
	
}