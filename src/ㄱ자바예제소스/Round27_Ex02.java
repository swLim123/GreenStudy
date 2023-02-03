import java.sql.*;

public class Round27_Ex02 {
	public static void main(String[] args) {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.exit(0);
		}
		Connection conn = null;
		String url = "jdbc:mysql://124.61.53.124:3306/java";
		String id = "root";
		String pass = "12345678";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from Round27_Ex02Table";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " : " + rs.getString(2));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
}
