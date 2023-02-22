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

class BookRental extends Frame implements ActionListener
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
	
	Label winName = new Label("도서 대여하기");
	Label lbTitle =    new Label("대여책 이름:");
	Label lbName =    new Label("대여자 이름:");
	Label lbHp =  new Label("대여자 연락처(-빼고입력)");
	TextField tfTitle = new TextField();
	TextField tfName = new TextField();
	TextField tfHp = new TextField();
	Button btnCheck = new Button("체크");
	Button btnRental = new Button("대여하기");
	
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	
	boolean btnCheck2 = false; //대여버튼 누르기 전 대여가능 여부 체크버튼 누르도록 유도
	
	BookRental()
	{
		super("대여하기");
		this.setSize(300,360);
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
		
		this.add(tfTitle);
		tfTitle.setBounds(30, 110, 150, 30);
		tfTitle.setFont(font15);
		
		this.add(lbName);
		lbName.setBounds(30, 160, 100, 30);
		lbName.setFont(font15);
		
		this.add(tfName);
		tfName.setBounds(30, 190, 150, 30);
		tfName.setFont(font15);
		
		this.add(lbHp);
		lbHp.setBounds(30, 240, 200, 30);
		lbHp.setFont(font15);
		
		this.add(tfHp);
		tfHp.setBounds(30, 270, 150, 30);
		tfHp.setFont(font15);
		
		this.add(btnCheck);
		btnCheck.setBounds(220, 110, 50, 30);
		btnCheck.setFont(font15);
		
		this.add(btnRental);
		btnRental.setBounds(110, 310, 80, 30);
		btnRental.setFont(font15);
	}
	void start()
	{
		btnCheck.addActionListener(this);
		btnRental.addActionListener(this);
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
		if(e.getSource() == btnCheck)
		{
			rentalCheck();
		}
		if(e.getSource() == btnRental)
		{
			btnBookRental();
		}
	}
	void rentalCheck()
	{
		String query = "select * from book";				
		try {								
				rs = stmt.executeQuery(query);				
				while (rs.next()) 
				{					
					if(tfTitle.getText().equals(rs.getString("title")))
					{
						if(rs.getString("rent_check").equals("no"))
						{
							dlgMsg("대여 불가능한 도서입니다.");
							tfTitle.setText("");
							btnCheck2 = false;
							break;		
						}
						else if(rs.getString("rent_check").equals("yes"))
						{
							dlgMsg("대여 가능한 도서입니다.");	
							btnCheck2 = true;
							break;		
						}
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
		if(btnCheck2 == true)
		{
			String pquery = "insert into book_rental values (null, ?, ?, ?, now(), null)";	
			try {
				conn = DriverManager.getConnection(url, id, pass);
				pstmt = conn.prepareStatement(pquery);
				pstmt.setString(1, tfTitle.getText());
				pstmt.setString(2, tfName.getText());
				pstmt.setString(3, tfHp.getText());
				pstmt.executeUpdate();
				System.out.println("실행성공");
			} catch (SQLException ee) {
				System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
			}	
			updateBook(tfTitle.getText());
			//회원가입처리후 사후제어처리...
			tfName.setText("");
			tfHp.setText("");
			tfTitle.setText("");
			
			
			
			dlgMsg("도서 처리 완료!");
			
			dbClose();//디비작업끝나서 닫기
		}
		else if(btnCheck2 == false)
		{
			dlgMsg("대여가능 여부 체크해주세요");
		}
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
		Dialog dlg = new Dialog(this, "정보", true);
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