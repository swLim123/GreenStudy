package 자바수업17일;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class BookReturn extends Frame implements ActionListener
{
	
		//디비관련 클래스변수들...
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/test_db?useUnicode=true&characterEncoding=utf8";	
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		/////////////////////////////////////////////////////////////////////////
	
	Label winName = new Label("도서 반납하기");
	Label lbTitle =    new Label("대여책 제목:");
	static TextField tfReturnTitle = new TextField();
	Button btnFind = new Button("찾기");
	
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	
	BookReturn()
	{
		super("대여하기");
		this.setSize(300,200);
		this.init();//화면레이아웃구성메서드
		dbCon();
		start();
		this.setLocation(300, 100);
		this.setVisible(true);
	}
	void init()
	{
		this.setLayout(null);
		this.add(winName);
		winName.setBounds(60, 30, 200, 50);
		winName.setFont(font25);
		
		this.add(lbTitle);
		lbTitle.setBounds(30, 80, 100, 30);
		lbTitle.setFont(font15);
		
		this.add(tfReturnTitle);
		tfReturnTitle.setBounds(30, 110, 150, 30);
		tfReturnTitle.setFont(font15);
		
		this.add(btnFind);
		btnFind.setBounds(220, 110, 50, 30);
		btnFind.setFont(font15);

	}
	void start()
	{
		btnFind.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				viewClose();
			}
		});
	}
	void viewClose()
	{
		this.setVisible(false);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnFind)
		{
			if(tfReturnTitle.getText().equals(""))
			{
				dlgMsg("제목을 입력해주세요.");
				return;
			}
			titleCheck();
		}
	}
	void titleCheck()
	{
		String query = "select * from book";				
		try {								
				rs = stmt.executeQuery(query);				
				while (rs.next()) 
				{					
					if(tfReturnTitle.getText().equals(rs.getString("title")))
					{
						BookReturn_1 br1 = new BookReturn_1();
					}
					else
					{
						dlgMsg("제목을 확인해주세요.");
						return;
					}
				}
			} 
			catch (SQLException ee) 
			{
				System.err.println("실행결과 획득실패!!");
			}
	}
	void btnBookRental()
	{
			String pquery = "insert into book_rental values (null, ?, ?, ?, now(), null)";	
			try {
				conn = DriverManager.getConnection(url, id, pass);
				pstmt = conn.prepareStatement(pquery);
				pstmt.setString(1, tfTitle.getText());
				pstmt.executeUpdate();
				System.out.println("실행성공");
			} catch (SQLException ee) {
				System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
			}	
			updateBook(tfTitle.getText());
			//회원가입처리후 사후제어처리...
			tfTitle.setText("");
			
			dlgMsg("도서 처리 완료!");
			
			dbClose();//디비작업끝나서 닫기
		}
	void updateBook(String title)
	{
		String query = "update book set rent_check = ? where title = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "no");
			pstmt.setString(2, title);
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("수정 완료!!");
			
		} catch (SQLException ee) {
			System.err.println("수정 실패!!");
		}
	}
	void dlgMsg(String msg)
	{
		Dialog dlg = new Dialog(this, "회원정보", true);
		Label lbContent = new Label(msg);
		Button bt = new Button("확인");		
		dlg.setLayout(null);		
		dlg.add(lbContent);	 lbContent.setFont(font15);
		dlg.add(bt);		 bt.setFont(font15);
		lbContent.setBounds(50, 50, 200, 30);
		bt.setBounds(80, 120, 120, 30);		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(false);
			}
		});
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});		
		dlg.setLocation(480,250);
		dlg.setSize(300, 200);
		dlg.setVisible(true);
	}
	void dbCon()
	{
		////////////////////////////////////////
		///데이타베이스접속..	
		try {	Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {System.exit(0);}	

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		////////////////////////////////////////////
	}
	void dbClose()
	{		
		// Close 작업
		try {
			rs.close();				
			stmt.close();
			pstmt.close();
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