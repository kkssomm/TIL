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
			System.out.print("부서명 입력 :");
			name = sc.next();
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString(1) == null) {
					System.out.println(name + " 부서에서 근무하는 직원이 없습니다.");
				} else {
					System.out.println(rs.getString(2) + "부서에서 근무하는 직원들:");
					do {
						System.out.println(rs.getString(1));
					} while (rs.next());
				}

			} else {
				System.out.println(name + "부서는 존재하지 않아요.");
			}
			System.out.print("계속 합니까?(계속:1/종료:0)");
			flag = sc.nextInt();
			sc.nextLine();
		} while (flag == 1);
		System.out.println("종료합니다.");
		rs.close();
		sc.close();
		pstmt.close();
		conn.close();

	}

}
