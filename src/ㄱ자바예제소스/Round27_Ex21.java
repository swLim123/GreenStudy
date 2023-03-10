import java.io.*;
import java.sql.*;

public class Round27_Ex21 {
	public static void main(String[] args) {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
		}
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pass = "12345678";
		Statement stmt = null;
		ResultSet rs = null;
		// String query = "select * from DateTable";
		String query = "select * from Round27_Ex20Table";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int num = rs.getInt("number");// DB생성시 실수해서 number를 numm으로 설정!!
				String msg = rs.getString("message");
				// java.sql.Date dd = rs.getDate("msgdate");
				java.sql.Time dd = rs.getTime("msgtime");
				java.util.Date d = new java.util.Date(dd.getTime());
				System.out.println(num + " : " + msg + " : " + d.toString());
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
		}
	}
}
