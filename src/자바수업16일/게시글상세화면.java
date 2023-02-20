package 자바수업16일;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
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

class BoardDetail extends Frame implements ActionListener
{
	//디비관련 클래스변수들...
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/test_db?useUnicode=true&characterEncoding=utf8";	
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		//////////////////////////////////////////////////////////
	
	Label lbWinName = new Label("게시글 상세화면");
	Label lbTitle = new Label("제목:");
	Label lbDetail = new Label("내용:");
	TextField tfTitle = new TextField();
	TextArea tfDetail = new TextArea();
	Button btEdit = new Button("글 수정");
	Button btDel = new Button("글 삭제");
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	
	BoardDetail(int idx)
	{
		super("게시글 등록");
		this.setSize(500,550);
		this.init();//화면레이아웃구성메서드
		dbCon();
		detail(idx);
		this.start();//이벤트메서드처리
		this.setLocation(500, 300);
		this.setVisible(true);
		
	}	
	void viewClose() {
		this.setVisible(false);
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
	void start()
	{
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				viewClose();
			}
		});
	}
	void init() //레이아웃 구성하기...
	{
		this.setLayout(null);//레이아웃을 직접좌표처리하는방식으로하기위해서...
		this.add(lbWinName);//현재 클래스 내부에 생성해서 넣음...
		lbWinName.setBounds(190, 40, 220, 30);
		lbWinName.setFont(font25);
		
		this.add(lbTitle);
		lbTitle.setBounds(60, 100, 50, 30);
		lbTitle.setFont(font15);
		
		this.add(tfTitle);
		tfTitle.setBounds(130, 100, 300, 30);
		tfTitle.setFont(font15);
		
		this.add(lbDetail);
		lbDetail.setBounds(60, 170, 50, 30);
		lbDetail.setFont(font15);
		
		this.add(tfDetail);
		tfDetail.setBounds(70, 220, 360, 250);
		tfDetail.setFont(font15);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}
	void detail(int idx)
	{	
		String query = "select * from board where idx='"+idx+"'";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		while (rs.next()) {			
			tfTitle.setText(rs.getString("title"));
			tfDetail.setText(rs.getString("content"));
		}
		rs.close();
		stmt.close();
		conn.close();
		} catch (SQLException ee) {
		System.err.println("error = " + ee.toString());
		}	
	}
	void dlgMsg(String msg)
	{
		Dialog dlg = new Dialog(this, "로그인체크", true);
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