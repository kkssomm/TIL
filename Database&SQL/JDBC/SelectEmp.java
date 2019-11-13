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
				System.out.print(rs.getString("ename") + "직원의 월급은" + rs.getString("to_char(sal,'999,999')") + "입니다.");
				System.out.println();
			}
		} else {
			rs = stmt.executeQuery("SELECT ename,to_char(hiredate,'yyyy\"년\"mm\"월\"dd\"일\"') from EMP");
			while (rs.next()) {
				System.out.print(rs.getString("ename") + "직원은 " + rs.getString("to_char(hiredate,'yyyy\"년\"mm\"월\"dd\"일\"')") + "에 입사하였습니다.");
				System.out.println();
			}
			if (rs != null)
				rs.close();
			stmt.close();
			conn.close();
		}

	}
}
