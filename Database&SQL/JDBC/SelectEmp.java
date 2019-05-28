package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class SelectEmp {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
		Statement stmt = conn.createStatement();
		ResultSet rs = null;

		Random r = new Random();
		boolean b = r.nextBoolean();

		if (b == true) {
			rs = stmt.executeQuery("SELECT ename, to_char(sal,'999,999') from EMP");
			while (rs.next()) {
				System.out.print(rs.getString("ename") + "������ ������" + rs.getString("to_char(sal,'999,999')") + "�Դϴ�.");
				System.out.println();
			}
		} else {
			rs = stmt.executeQuery("SELECT ename,to_char(hiredate,'yyyy\"��\"mm\"��\"dd\"��\"') from EMP");
			while (rs.next()) {
				System.out.print(rs.getString("ename") + "������ " + rs.getString("to_char(hiredate,'yyyy\"��\"mm\"��\"dd\"��\"')") + "�� �Ի��Ͽ����ϴ�.");
				System.out.println();
			}
			if (rs != null)
				rs.close();
			stmt.close();
			conn.close();
		}

	}
}
