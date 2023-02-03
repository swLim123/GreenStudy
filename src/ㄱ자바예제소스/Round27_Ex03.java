import java.sql.*;

public class Round27_Ex03 {
	public static void main(String[] args) {
		// 1. 드라이브를 검색 (Readme.txt 참조)
		// oracle => com.oracle.OracleDriver
		// my-sql => org.gjt.mm.mysql.Driver
		// odbc => jdbc.odbc.JdbcOdbcDriver : jdk1.2 이상에서는 기본설치
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("드라이브가 있습니당~! ^_^v");
		} catch (ClassNotFoundException ee) {
			System.out.println("드라이브 없음!!");
		}
		// 2. Connection 객체생성 (Readme.txt 참조)
		// Connection conn = DriverManager.getConnection(
		// "protocol:subprotocol:sid", "id", "pass");
		// oracle => "jdbc:oracle:thin@124.61.53.124:1521/java"
		// my-sql => "jdbc:mysql://124.61.53.124:3306/java"
		// odbc => "jdbc:odbc:java"
		Connection conn = null;
		String url = "jdbc:mysql://124.61.53.124:3306/java";
		String user = "root";// ID
		String password = "12345678";// 비밀번호
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결되었습니다.");
		} catch (SQLException ee) {
			System.err.println("연결객체 생성실패!!");
		}
		// 3. Query 실행 클래스 생성
		// Statement stmt = conn.createStatement();
		// PrepareStatment pstmt = conn.prepareStatement(query);
		String query = "select * from Round27_Ex02Table";
		Statement stmt = null;
		String pquery = "insert into Round27_Ex02Table values (null, ?)";
		PreparedStatement pstmt = null;
		try {
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, "김지후");
			pstmt.executeUpdate();
			System.out.println("실행성공");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}
		// 4. ResultSet 객체생성
		// ResultSet rs = stmt.executeQuery(query);
		// ResultSet rs = pstmt.executeQuery();
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				System.out.println(num + " : " + name);
			}
		} catch (SQLException ee) {
			System.err.println("실행결과 획득실패!!");
		}
		// 5. Close 작업
		try {
			rs.close();
			pstmt.close();
			stmt.close();
			if (conn != null) {
				if (!conn.isClosed()) {
					conn.close();
				}
				conn = null;
			}
		} catch (SQLException ee) {
			System.err.println("닫기 실패~!!");
		}
	}
}
