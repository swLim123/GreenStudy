package 자바수업17일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class BookManagement extends Frame implements ActionListener{
	//디비관련 클래스변수들...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/test_db?useUnicode=true&characterEncoding=utf8";	
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	/////////////////////////////////////////////////////////////////////////
	
	Label lbWinName = new Label("책 등록하기");
	Label lbTitle =    new Label("제목:");
	Label lbWriter =    new Label("저자:");
	Label lbPublishing =  new Label("출판사:");
	Label lbDate =    new Label("등록일:");
	TextField tfTitle = new TextField();
	TextField tfWriter = new TextField();
	TextField tfPublishing = new TextField();
	TextField tfDate = new TextField();	
	Button btnJoin = new Button("등록하기");
	Button btncheck = new Button("중복확인");
	
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	BookManagement()
	{		
		super("회원가입");
		dbCon();//디비접속
		this.setSize(300,400);
		this.init();//화면레이아웃구성메서드
		start();
		this.setLocation(650, 450);
		this.setVisible(true);
		
	}	
	void start() {
		btnJoin.addActionListener(this);		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				viewClose();
			}
		});
	}
	void viewClose() {
		this.setVisible(false);
	}
	void init() //레이아웃 구성하기...
	{
		this.setLayout(null);//레이아웃을 직접좌표처리하는방식으로하기위해서...		
		this.add(lbWinName);
		lbWinName.setFont(font25);
		lbWinName.setBounds(50, 50, 200, 30);
		
		this.add(lbTitle);			lbTitle.setFont(font15);		lbTitle.setBounds(30, 100, 80, 30);		
		this.add(tfTitle);			tfTitle.setFont(font15);		tfTitle.setBounds(110, 100, 80, 30);
		
		this.add(lbWriter);			lbWriter.setFont(font15);		lbWriter.setBounds(30, 150, 80, 30);		
		this.add(tfWriter);			tfWriter.setFont(font15);		tfWriter.setBounds(110, 150, 80, 30);
		this.add(lbPublishing);		lbPublishing.setFont(font15);	lbPublishing.setBounds(30, 200, 80, 30);		
		this.add(tfPublishing);		tfPublishing.setFont(font15);	tfPublishing.setBounds(110, 200, 120, 30);
		
		this.add(lbDate);			lbDate.setFont(font15);		lbDate.setBounds(30, 250, 80, 30);		
		this.add(tfDate);			tfDate.setFont(font15);		tfDate.setBounds(110, 250, 120, 30);
		this.add(btnJoin);		  	btnJoin.setFont(font15);	btnJoin.setBounds(110, 340, 80, 30);
		this.add(btncheck);		  	btncheck.setFont(font15);	btncheck.setBounds(200, 100, 80, 30);
		
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
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		
	}
	void idCheck()
	{
		//아이디중복체크...
		String query = "select * from book";				
		try {								
			rs = stmt.executeQuery(query);
			boolean idCheck = true;				
			while (rs.next()) {					
				
				if(tfTitle.getText().equals(rs.getString("id")))
				{
					dlgMsg("도서명이 중복됩니다.");	
					idCheck = false;
					
					break;										
				}
			}
			if(idCheck==true)
			{
				dlgMsg("사용가능한 아이디입니다.");	
				tfTitle.setEnabled(false);				
			}
			
		} catch (SQLException ee) {
			System.err.println("실행결과 획득실패!!");
		}
		
		
	}
	void join()
	{	
		String pquery = "insert into book values (null, ?, ?, ?, now())";	
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, tfTitle.getText());
			pstmt.setString(2, tfWriter.getText());
			pstmt.setString(3, tfPublishing.getText());
			pstmt.setString(4, tfDate.getText());			
			pstmt.executeUpdate();
			System.out.println("실행성공");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}		
		dbClose();//디비작업끝나서 닫기
		
		//회원가입처리후 사후제어처리...
		tfDate.setEnabled(true);
		tfWriter.setText("");
		tfPublishing.setText("");
		tfDate.setText("");
		
		dlgMsg("도서 처리 완료!");
			
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
}