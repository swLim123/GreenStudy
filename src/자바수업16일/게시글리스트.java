package 자바수업16일;

import java.awt.*;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class 게시글리스트
{
	public static void main(String[] args)
	{
		BoardList bList = new BoardList();
	}
}
class BoardList extends Frame implements ActionListener, ItemListener
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
	
	Label lbWinName = new Label("게시글 목록");
	List boardList = new List();
	Button btReg = new Button("확인");
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	int boardIdx[] = new int[20];
	
	BoardList()
	{
		super("게시글 목록");
		this.setSize(400,400);
		this.init();//화면레이아웃구성메서드
		dbCon();
		this.start();//이벤트메서드처리
		this.setLocation(500, 300);
		this.setVisible(true);
		listLoad();
		
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
		btReg.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	void init() //레이아웃 구성하기...
	{
		this.setLayout(null);//레이아웃을 직접좌표처리하는방식으로하기위해서...
		this.add(lbWinName);//현재 클래스 내부에 생성해서 넣음...
		lbWinName.setBounds(140, 40, 220, 30);
		lbWinName.setFont(font25);
		
		this.add(boardList);
		boardList.setBounds(50, 85, 300, 250);
		boardList.setFont(font15);
		
		this.add(btReg);
		btReg.setBounds(160, 340, 70, 35);
		btReg.setFont(font15);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}
	void listLoad()
	{	
		String query = "select * from board";
		try {
				conn = DriverManager.getConnection(url, id, pass);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				String result="";
				int count = 0;
				while (rs.next()) 
				{
					if(count == 20)
					{
						break;
					}
					result = rs.getString("idx")+"/"+rs.getString("title")+
							"/"+rs.getString("content")+"/"+rs.getString("reg_data");
					boardList.add(result);
					
					boardIdx[count] = Integer.parseInt(rs.getString("idx"));
					count++;
				}
				rs.close();
				stmt.close();
				conn.close();	
		   	}
		catch (SQLException ee) 
		{
			System.err.println("error = " + ee.toString());
		}
	}
	public void itemStateChanged(ItemEvent e) 
	{
		BoardDetail bd = new BoardDetail(boardIdx[boardList.getSelectedIndex()]);
	}
}