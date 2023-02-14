package ㄱ자바예제소스;
import java.sql.*;

public class Round27_Ex03 {
	public static void main(String[] args) {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("드라이브 없음!!");
		}
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/member?useUnicode=true&characterEncoding=utf8";
		String user = "root";// ID
		String password = "qwer";// 비밀번호
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결되었습니다.");
		} catch (SQLException ee) {
			System.err.println("연결객체 생성실패!!");
		}
		
		
		String query = "select * from tb_member2";
		Statement stmt = null;
		String pquery = "insert into tb_member2 values (null, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, "id");
			pstmt.setString(2, "pass");
			pstmt.setString(3, "name");
			pstmt.setString(4, "hp");
			pstmt.setString(5, "sex");
			pstmt.executeUpdate();
			System.out.println("실행성공");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}
		// 4. ResultSet 객체생성
		// ResultSet rs = stmt.executeQuery(query);
		// ResultSet rs = pstmt.executeQuery();
		String query1 = "select * from tb_member2";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(query1);
			while (rs.next()) {
				int num = rs.getInt("idx");
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
