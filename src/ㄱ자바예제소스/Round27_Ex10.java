import java.sql.*;

public class Round27_Ex10 {
	private Connection dc;

	public Round27_Ex10() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			return;
		}
		String url = "jdbc:mysql://124.61.53.124:3306/java";
		String id = "root";
		String pass = "12345678";
		try {
			dc = DriverManager.getConnection(url, id, pass);
		} catch (SQLException ee) {
		}
	}

	// 회원가입을 위해서...
	public boolean registerMember(String name, String id, String pass,
			String email) {
		String query = "insert into Round27_Ex10Table values (null, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pass);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ee) {
			System.err.println("회원 가입 실패!! : " + ee.toString());
			return false;
		}
		return true;
	}

	// login을 위해서...
	public boolean loginMember(String id, String pass) {
		String query = "select * from Round27_Ex10Table where id = ? and pass = ?";
		
		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) {
				rs.close();
				pstmt.close();
				return false;
			}
			rs.close();
			pstmt.close();
		} catch (SQLException ee) {
			System.err.println("login 처리 실패!!");
		}
		return true;
	}

	// 회원 정보수정을 위해서...
	public boolean editMember(String id, String name, String pass, String email) {
		String query = "update Round27_Ex10Table set name = ?, pass = ?, email = ? where id = ?";
		
		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ee) {
			System.err.println("회원 정보수정 실패!!");
			return false;
		}
		return true;
	}

	// 회원삭제를 위해서...
	public boolean deleteMember(String id) {
		String query = "delete from Round27_Ex10Table where id = ?";
		
		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ee) {
			System.err.println("회원 삭제 실패!!");
			return false;
		}
		return true;
	}
}
