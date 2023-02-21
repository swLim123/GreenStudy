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

class BookEdit extends Frame implements ItemListener, ActionListener{
	//디비관련 클래스변수들...
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/test_db?useUnicode=true&characterEncoding=utf8";	
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		//////////////////////////////////////////////////////////
		
	
	Label lbWinName = new Label("[[ 책정보수정 ]]");
	Label lbTitle =    new Label("제목:");
	Label lbWriter =    new Label("저자:");
	Label lbPublishing =  new Label("출판사:");
	Label lbDate =    new Label("등록일:");
	TextField tfTitle = new TextField();
	TextField tfWriter = new TextField();
	TextField tfPublishing = new TextField();
	TextField tfDate = new TextField();
	Button btnIdCheck = new Button("찾기");	
	Button btnEdit = new Button("수정완료");
	Button btnCancel = new Button("취소");
	
	Choice chSex = new Choice();
	String sex="남자";
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	BookEdit()
	{
		super("회원정보수정");
		dbCon();
		this.setSize(300,450);
		this.init();//화면레이아웃구성메서드
		start();
		this.setLocation(650, 450);
		this.setVisible(true);
		
	}	
	void start() {
		btnCancel.addActionListener(this);
		btnEdit.addActionListener(this);
		btnIdCheck.addActionListener(this);
		chSex.addItemListener(this);
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
		this.add(tfWriter);			tfWriter.setFont(font15);		tfWriter.setBounds(110, 150, 80, 30);
		
		this.add(lbPublishing);		lbPublishing.setFont(font15);	lbPublishing.setBounds(30, 200, 80, 30);		
		this.add(tfPublishing);		tfPublishing.setFont(font15);	tfPublishing.setBounds(110, 200, 120, 30);
		
		this.add(lbDate);			lbDate.setFont(font15);			lbDate.setBounds(30, 250, 80, 30);		
		this.add(tfDate);			tfDate.setFont(font15);			tfDate.setBounds(110, 250, 120, 30);
		
		this.add(btnEdit);			btnEdit.setFont(font15);		btnEdit.setBounds(110, 340, 80, 30);
		this.add(btnCancel);		btnCancel.setFont(font15);		btnCancel.setBounds(110, 380, 80, 30);
		
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
	void idCheck(String findTitle)
	{
		//수정아이디 찾기
		String query = "select * from book where title='"+findTitle+"'";				
		try {								
			rs = stmt.executeQuery(query);
			boolean bCheck = false;				
			while (rs.next()) {			
				bCheck =true;
				dlgMsg("수정대상을 찾았습니다.");
				tfWriter.setText(rs.getString("writer"));
				tfPublishing.setText(rs.getString("publishing"));
				tfDate.setText(rs.getString("date_reg"));
				break;
			}
			if(bCheck==false)
			{				
				dlgMsg("수정대상이 없습니다.");				
			}
			
		} catch (SQLException ee) {
			System.err.println("실행결과 획득실패!!");
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		sex = chSex.getSelectedItem();		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == btnIdCheck)  {
			if(tfTitle.getText().equals("")){dlgMsg("아이디를 입력하시오.");return;	}			
			idCheck(tfTitle.getText());
		}
		else if(e.getSource() == btnEdit) {
			if(tfTitle.getText().equals("")){dlgMsg("아이디를 입력하시오.");return;	}
			else if(tfWriter.getText().equals("")){dlgMsg("패스워드를 입력하시오.");return;	}
			else if(tfPublishing.getText().equals("")){dlgMsg("이름을 입력하시오.");return;	}
			else if(tfDate.getText().equals("")){dlgMsg("연락처를 입력하시오.");return;	}
			
			updateMember(tfTitle.getText(),tfWriter.getText(),tfPublishing.getText(),tfDate.getText());
		}
		else if(e.getSource() == btnCancel) {viewClose();}	

		
	}
	// 회원 정보수정을 위해서...
	void updateMember(String title, String writer, String publishing, String date_reg) {
			String query = "update book set id = ?, pw = ?, name = ?, hp = ? where title = ?";
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, title);
				pstmt.setString(2, writer);
				pstmt.setString(3, publishing);
				pstmt.setString(4, date_reg);
				pstmt.setString(6, title);
				pstmt.executeUpdate();
				pstmt.close();
				dlgMsg("수정완료!");
			} catch (SQLException ee) {
				System.err.println("회원 정보수정 실패!!");
			
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