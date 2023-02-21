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

class BookDel extends Frame implements ItemListener, ActionListener{
	
	//디비관련 클래스변수들...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/test_db?useUnicode=true&characterEncoding=utf8";	
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	//////////////////////////////////////////////////////////
	
	Label lbWinName = new Label("[[ 책정보삭제 ]]");
	Label lbTitle =    new Label("제목:");
	Label lbWriter =    new Label("저자:");
	Label lbPublishing =  new Label("출판사:");
	Label lbDate =    new Label("등록일:");
	TextField tfTitle = new TextField();
	Label lbWriter2 = new Label("대기중...");
	Label lbPublishing2 = new Label("대기중...");
	Label lbDate2 =    new Label("대기중...");
	Button btnIdCheck = new Button("찾기");	
	Button btnDel = new Button("삭제완료");
	Button btnCancel = new Button("취소");
	
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	BookDel()
	{
		super("책정보삭제");
		dbCon();//디비연동
		this.setSize(300,450);
		this.init();//화면레이아웃구성메서드
		start();
		this.setLocation(650, 450);
		this.setVisible(true);
		
	}	
	void start() {
		btnCancel.addActionListener(this);
		btnIdCheck.addActionListener(this);
		btnDel.addActionListener(this);
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
		this.add(btnIdCheck);		btnIdCheck.setFont(font15);		btnIdCheck.setBounds(200, 100, 80, 30);
		
		this.add(lbWriter);			lbWriter.setFont(font15);		lbWriter.setBounds(30, 150, 80, 30);		
		this.add(lbWriter2);		lbWriter2.setFont(font15);		lbWriter2.setBounds(110, 150, 120, 30);
		
		this.add(lbPublishing);		lbPublishing.setFont(font15);	lbPublishing.setBounds(30, 200, 80, 30);		
		this.add(lbPublishing2);	lbPublishing2.setFont(font15);	lbPublishing2.setBounds(110, 200, 120, 30);
		
		this.add(lbDate);			lbDate.setFont(font15);			lbDate.setBounds(30, 250, 80, 30);		
		this.add(lbDate2);			lbDate2.setFont(font15);		lbDate2.setBounds(110, 250, 120, 30);
			
		this.add(btnDel);			btnDel.setFont(font15);			btnDel.setBounds(110, 340, 80, 30);
		this.add(btnCancel);		btnCancel.setFont(font15);		btnCancel.setBounds(110, 380, 80, 30);
		
	}
	
	
	void idCheck()
	{
		//삭제아이디 찾기
		String query = "select * from book";				
		try {								
			rs = stmt.executeQuery(query);
			boolean idCheck = false;				
			while (rs.next()) {					
				
				if(tfTitle.getText().equals(rs.getString("title")))
				{
					dlgMsg("삭제할 책을 찾았습니다.");	
					idCheck = true;
					//대상찾았으면 표시
					lbWriter2.setText(rs.getString("writer"));
					lbPublishing2.setText(rs.getString("publishing"));
					lbDate2.setText(rs.getString("date_reg"));
					
					break;										
				}
			}
			if(idCheck==false)
			{
				dlgMsg("삭제대상이 없습니다.");					
			}
			
		} catch (SQLException ee) {
			System.err.println("실행결과 획득실패!!");
		}
		
		
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
	public void itemStateChanged(ItemEvent e) {		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
		
		if(e.getSource() == btnIdCheck)  {
			if(tfTitle.getText().equals("")){dlgMsg("제목을 입력하시오.");return;	}			
			idCheck();
		}
		else if(e.getSource() == btnDel) {
			if(tfTitle.getText().equals("")){dlgMsg("제목을 입력하시오.");return;	}
			deleteMember(tfTitle.getText());
		}
		else if(e.getSource() == btnCancel) {viewClose();}		
	}
	public void deleteMember(String id) {
		String query = "delete from memberlist where id = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("회원삭제완료!");
			tfTitle.setText("");
			lbWriter2.setText("");
			lbPublishing2.setText("");
			lbDate2.setText("");
		} catch (SQLException ee) {
			System.err.println("책 삭제 실패!!");			
		}				
	}
	void dlgMsg(String msg)
	{
		Dialog dlg = new Dialog(this, "대상찾기", true);
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