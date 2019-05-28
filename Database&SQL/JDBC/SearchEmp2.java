package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class SearchEmp2 {

	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
		String query = "SELECT ename, deptno from EMP E right JOIN DEPT D USING(DEPTNO) WHERE dname=UPPER(?)";
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String name;
		int flag;

		do {
			System.out.print("�μ��� �Է� :");
			name = sc.next();
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString(1) == null) {
					System.out.println(name + " �μ����� �ٹ��ϴ� ������ �����ϴ�.");
				} else {
					System.out.println(rs.getString(2) + "�μ����� �ٹ��ϴ� ������:");
					do {
						System.out.println(rs.getString(1));
					} while (rs.next());
				}

			} else {
				System.out.println(name + "�μ��� �������� �ʾƿ�.");
			}
			System.out.print("��� �մϱ�?(���:1/����:0)");
			flag = sc.nextInt();
			sc.nextLine();
		} while (flag == 1);
		System.out.println("�����մϴ�.");
		rs.close();
		sc.close();
		pstmt.close();
		conn.close();

	}

}
