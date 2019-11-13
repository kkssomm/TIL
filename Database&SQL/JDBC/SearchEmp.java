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
		String query = "SELECT ename, to_char(hiredate,'yyyy\"��\"mm\"��\"'), deptno from EMP WHERE ename = upper(?)";
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String name;
		int flag;

		do {
			System.out.print("���� �̸� �Է� :");
			name = sc.nextLine();
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getString(1) + "������ �ٹ����Դϴ�.");
				System.out.println(rs.getString(2) + "�� �Ի��߰� ����" + rs.getString(3) + "�� �ٹ����Դϴ�.");
			} else {
				System.out.println(name + "������ �ٹ����� �ʽ��ϴ�.");
			}
			System.out.print("��� �մϱ�?(���:1/����:0)");
			flag = sc.nextInt();
			sc.nextLine();
		} while (flag == 1);

		rs.close();
		sc.close();
		pstmt.close();
		conn.close();
	}

}