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

class BookReturn_1 extends Frame implements ActionListener
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
	
	Label lbName = new Label();
	Label lbPh = new Label();
	Label lbDate = new Label();
	TextField tfName = new TextField();
	TextField tfPh = new TextField();
	TextField tfDate = new TextField();
	Button btReturn = new Button("반납하기");
	
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
		this.add(lbName);
		lbName.setBounds(60, 30, 200, 50);
		lbName.setFont(font15);
		
		this.add(lbPh);
		lbPh.setBounds(60, 30, 200, 50);
		lbPh.setFont(font15);
		
		this.add(lbDate);
		lbDate.setBounds(60, 30, 200, 50);
		lbDate.setFont(font15);
		
		this.add(tfName);
		tfName.setBounds(60, 30, 200, 50);
		tfName.setFont(font15);
		
		this.add(tfPh);
		tfPh.setBounds(60, 30, 200, 50);
		tfPh.setFont(font15);
		
		this.add(tfDate);
		tfDate.setBounds(60, 30, 200, 50);
		tfDate.setFont(font15);

	}
	void start()
	{
		btReturn.addActionListener(this);
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
		if(e.getSource() == btReturn)
		{
			
		}
	}
	void dbCon()
	{
		////////////////////////////////////////
		///데이타베이스접속..	
		try 
		{	
			Class.forName("org.gjt.mm.mysql.Driver");
		} 
		catch (ClassNotFoundException ee) 
		{
			System.exit(0);
		}	

		try 
		{
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
		////////////////////////////////////////////
	}
}