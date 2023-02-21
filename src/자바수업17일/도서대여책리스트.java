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

class BookList extends Frame implements ItemListener, ActionListener{
	
	//디비관련 클래스변수들...
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/test_db?useUnicode=true&characterEncoding=utf8";	
			String id = "root";
			String pass = "qwer";
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			//////////////////////////////////////////////////////////
	
	Label lbTitle = new Label("[[  책 리스트  ]]");
	List bList = new List();
	Button btnOk = new Button("확인");	
	
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	BookList()
	{
		super("회원목록");
		this.setSize(300,400);
		this.init();//화면레이아웃구성메서드
		start();
		this.setLocation(650, 450);
		dataLoad();
		this.setVisible(true);
		
	}	
	void start() {
		btnOk.addActionListener(this);
		bList.addItemListener(this);
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
		
		this.add(bList);bList.setFont(font15);
		bList.setBounds(10, 100, 280, 220);
//		mList.add("1 / hong / 홍길동 / 1111111");
//		mList.add("2 / cms / 아무개 / 2222222");
//		mList.add("3 / abc / 둘리 / 3333333");
		
		this.add(btnOk);		btnOk.setFont(font15);	btnOk.setBounds(110, 340, 80, 30);
		
	}
	void dataLoad()
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
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.exit(0);
		}
		String query = "select * from book";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			String result="";
		while (rs.next()) {
			result = rs.getString("idx")+"/"+rs.getString("title")+"/"+rs.getString("writer")
			+"/"+rs.getString("publishing")+"/"+rs.getString("date_reg");	
			System.out.println("result:"+result);
			bList.add(result);
		
		}
		rs.close();
		stmt.close();
		conn.close();
		} catch (SQLException ee) {
		System.err.println("error = " + ee.toString());
		}
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		dlgMsg(bList.getSelectedItem());
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {		
		 viewClose(); 
		
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