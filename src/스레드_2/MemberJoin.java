package 스레드_2;
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

class MemberJoin extends Frame implements ItemListener, ActionListener{
	//디비관련 클래스변수들...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/factory?useUnicode=true&characterEncoding=utf8";	
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	/////////////////////////////////////////////////////////////////////////
	
	Label lbTitle = new Label("회원 가입");
	Label lbName =  new Label("사 원 명:");
	Label lbId =    new Label("아 이 디:");
	Label lbPw =    new Label("패스워드:");		
	Label lbGrade =    new Label("직   급:");
	Label lbPart =    new Label("담당파트:");
	TextField tfId = new TextField();
	TextField tfPw = new TextField();
	TextField tfName = new TextField();	
	Button btnIdCheck = new Button("중복확인");	
	Button btnJoin = new Button("가입하기");
	String grade = "사원";
	String part = "기계1";
	Choice chGrade = new Choice();
	Choice chPart = new Choice();
	
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	MemberJoin()
	{		
		super("회원가입");
		dbCon();//디비접속
		this.setSize(300,400);
		this.init();//화면레이아웃구성메서드
		start();
		this.setLocation(500, 200);
		this.setVisible(true);
		
	}	
	void start() {
		btnJoin.addActionListener(this);		
		btnIdCheck.addActionListener(this);
		chGrade.addItemListener(this);
		chPart.addItemListener(this);
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
		this.add(lbTitle);
		lbTitle.setFont(font25);
		lbTitle.setBounds(50, 50, 200, 30);
		
		this.add(lbId);			lbId.setFont(font15);		lbId.setBounds(30, 100, 80, 30);		
		this.add(tfId);			tfId.setFont(font15);		tfId.setBounds(110, 100, 80, 30);
		this.add(btnIdCheck);	btnIdCheck.setFont(font15);	btnIdCheck.setBounds(200, 100, 80, 30);
		
		this.add(lbPw);			lbPw.setFont(font15);		lbPw.setBounds(30, 150, 80, 30);		
		this.add(tfPw);			tfPw.setFont(font15);		tfPw.setBounds(110, 150, 80, 30);
		tfPw.setEchoChar('*');
		this.add(lbName);		lbName.setFont(font15);		lbName.setBounds(30, 200, 80, 30);		
		this.add(tfName);		tfName.setFont(font15);		tfName.setBounds(110, 200, 120, 30);	
		
		this.add(lbGrade); lbGrade.setFont(font15);				lbGrade.setBounds(30, 250, 80, 30);
		this.add(chGrade); chGrade.setFont(font15);				chGrade.setBounds(110, 250, 120, 30);
		chGrade.add("사원"); chGrade.add("반장");chGrade.add("공장장");		
		
		this.add(lbPart); lbPart.setFont(font15);				lbPart.setBounds(30, 300, 80, 30);
		this.add(chPart); chPart.setFont(font15);				chPart.setBounds(110, 300, 120, 30);
		chPart.add("기계1"); chPart.add("기계2");chPart.add("기계3");
		chPart.add("기계4"); chPart.add("기계5");chPart.add("기계6");
		chPart.add("관리자");
		
		
		this.add(btnJoin);		btnJoin.setFont(font15);	btnJoin.setBounds(110, 340, 80, 30);
		
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
		grade = chGrade.getSelectedItem();		
		part = chPart.getSelectedItem();
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
		//회원가입버튼
		if( e.getSource() == btnJoin) 
		{
			if(tfId.getText().equals("")){
				dlgMsg("아이디를 입력하시오.");
				return;
			}
			else if(tfPw.getText().equals("")){
				dlgMsg("패스워드를 입력하시오.");
				return;
			}
			else if(tfName.getText().equals("")){
				dlgMsg("이름을 입력하시오.");
				return;
			}			
			//회원가입 디비메서드
			join();			
		}
		//회원가입시 아이디 중복체크 버튼
		else if( e.getSource() == btnIdCheck) {					
			if(tfId.getText().equals("")){dlgMsg("아이디를 입력하시오.");return;	}
			//회원가입 아이디중복체크
			idCheck();			
		}		
	}
	void idCheck()
	{
		//아이디중복체크...
		String query = "select * from member";				
		try {								
			rs = stmt.executeQuery(query);
			boolean idCheck = true;				
			while (rs.next()) {					
				
				if(tfId.getText().equals(rs.getString("id")))
				{
					dlgMsg("아이디가 중복됩니다.");	
					idCheck = false;
					
					break;										
				}
			}
			if(idCheck==true)
			{
				dlgMsg("사용가능한 아이디입니다.");	
				tfId.setEnabled(false);
				btnIdCheck.setEnabled(false);				
			}
			
		} catch (SQLException ee) {
			System.err.println("실행결과 획득실패!!");
		}
		
		
	}
	void join()
	{	
		String pquery = "insert into member values (null, ?, ?, ?, ?, ?)";	
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, tfId.getText());
			pstmt.setString(2, tfPw.getText());
			pstmt.setString(3, tfName.getText());
			pstmt.setString(4, grade);
			pstmt.setString(5, part);			
			pstmt.executeUpdate();
			System.out.println("실행성공");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}		
		dbClose();//디비작업끝나서 닫기
		
		//회원가입처리후 사후제어처리...
		tfId.setEnabled(true);
		btnIdCheck.setEnabled(true);
		tfId.setText("");
		tfPw.setText("");
		tfName.setText("");		
		
		dlgMsg("회원가입 처리 완료!");
			
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








