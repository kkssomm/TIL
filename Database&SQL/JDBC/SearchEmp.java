package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchEmp {

	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
		String query = "SELECT ename, to_char(hiredate,'yyyy\"년\"mm\"월\"'), deptno from EMP WHERE ename = upper(?)";
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String name;
		int flag;

		do {
			System.out.print("직원 이름 입력 :");
			name = sc.nextLine();
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getString(1) + "직원은 근무중입니다.");
				System.out.println(rs.getString(2) + "에 입사했고 현재" + rs.getString(3) + "에 근무중입니다.");
			} else {
				System.out.println(name + "직원은 근무하지 않습니다.");
			}
			System.out.print("계속 합니까?(계속:1/종료:0)");
			flag = sc.nextInt();
			sc.nextLine();
		} while (flag == 1);

		rs.close();
		sc.close();
		pstmt.close();
		conn.close();
	}

}