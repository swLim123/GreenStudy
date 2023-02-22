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

class BookRentalList extends Frame implements ItemListener, ActionListener{
	
	Label lbTitle = new Label("[[  대여 책 리스트  ]]");
	static List bList = new List();
	Button btnOk = new Button("확인");
	Checkbox cbRentalYes = new Checkbox("대여가능책");
	Checkbox cbRentalNo = new Checkbox("대여불가능책");
	Checkbox cbRentalAll = new Checkbox("전체책", true);
	
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	static int boardIdx[] = new int[20];
	BookRentalList()
	{
		super("대여 책 리스트");
		this.setSize(300,430);
		this.init();//화면레이아웃구성메서드
		start();
		this.setLocation(650, 450);
		this.setVisible(true);
		
	}	
	void start() {
		cbRentalYes.addItemListener(this);
		cbRentalNo.addItemListener(this);
		cbRentalAll.addItemListener(this);
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
		lbTitle.setBounds(40, 50, 250, 30);
		
		this.add(bList);
		bList.setFont(font15);
		bList.setBounds(10, 190, 280, 160);
		
		this.add(btnOk);		
		btnOk.setFont(font15);	
		btnOk.setBounds(110, 370, 80, 30);
		
		this.add(cbRentalYes);
		cbRentalYes.setFont(font15);
		cbRentalYes.setBounds(30, 120, 100, 30);
		
		this.add(cbRentalNo);
		cbRentalNo.setFont(font15);
		cbRentalNo.setBounds(30, 150, 120, 30);
		
		this.add(cbRentalAll);
		cbRentalAll.setFont(font15);
		cbRentalAll.setBounds(30, 90, 100, 30);
		
	}
	
	public void itemStateChanged(ItemEvent e) {
		dlgMsg(bList.getSelectedItem());
		
		if(e.getSource() == cbRentalAll)
		{
			cbRentalYes.setState(false);
			cbRentalNo.setState(false);
			if(cbRentalAll.getState() == true
					&& cbRentalYes.getState() == false
					&& cbRentalNo.getState() == false)
			{
				bookList("all");
			}
		}
		else if(e.getSource() == cbRentalYes)
		{
			cbRentalAll.setState(false);
			cbRentalNo.setState(false);
			if(cbRentalYes.getState() == true
					&& cbRentalAll.getState() == false
					&& cbRentalNo.getState() == false)
			{
				bookList("yes");
			}
		}
		else if(e.getSource() == cbRentalNo)
		{
			cbRentalYes.setState(false);
			cbRentalAll.setState(false);
			if(cbRentalNo.getState() == true
					&& cbRentalYes.getState() == false
					&& cbRentalAll.getState() == false)
			{
				bookList("no");
			}
		}
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
	static void bookList(String gubun)
	{
	////////////////////////////////////////
	///데이타베이스접속..

		String query="";
		if(gubun.equals("all"))
		{
			query = "select * from book";
		}
		else if(gubun.equals("yes"))
		{
			query = "select * from book where book_rent='"+gubun+"'";
		}
		else if(gubun.equals("no"))
		{
			query = "select * from book where book_rent='"+gubun+"'";
		}
		
		
		
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.exit(0);
		}
		Connection conn = null;
		//접속 주소 : 3306/디비명
		String url = "jdbc:mysql://localhost:3306/book_db?useUnicode=true&characterEncoding=utf8";
		//String url = "jdbc:mysql://127.0.0.1:3306/java";
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			String result="";
			int count = 0;
		while (rs.next()) {
			if(count==20) {break;}
			result = rs.getString("idx")+"/"+rs.getString("title")+"/"+rs.getString("writer")+
					"/"+rs.getString("publishing")+"/"+rs.getString("date_reg");	
			System.out.println("result:"+result);
			bList.add(result);
			
			//상세보기 처리를 위해서 싱크를 맞춰서 idx값을 저장
			//리스트에서 아이템 선택시 인덱스값하고 맞춰서 제어를 위해 
			boardIdx[count] = Integer.parseInt(rs.getString("idx"));
			count++;		
		}
		rs.close();
		stmt.close();
		conn.close();
		} catch (SQLException ee) {
		System.err.println("error = " + ee.toString());
		}
		
	}
}
