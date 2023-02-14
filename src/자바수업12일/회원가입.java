package 자바수업12일;
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
public class 회원가입
{
	public static void main(String[] args) 
	{
		WinStudy1 wt = new WinStudy1();
	}
}

class WinStudy1 extends Frame implements ItemListener, ActionListener
{
	Choice gc = new Choice();
	Label lbTitle = new Label("회원가입하기");
	Label lbId = new Label("아이디:");
	Label lbPw = new Label("패스워드:");
	Label lbName = new Label("이름:");
	Label lbHp = new Label("연락처:");
	Label lbGd = new Label("성별:");
	TextField tflbId = new TextField();
	TextField tflbPw = new TextField();
	TextField tfName = new TextField();
	TextField tfHp = new TextField();
	Button bt = new Button("가입하기");
	Button bt2 = new Button("중복확인");
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	WinStudy1()
	{
		super("회원가입");
		this.setSize(350, 450);
		this.init();
		this.start();
		this.setLocation(400, 200);
		this.setVisible(true);
	}
	void init()
	{
		this.setLayout(null);
		this.add(lbTitle);
		lbTitle.setBounds(100, 40, 270, 30);
		lbTitle.setFont(font25);
		
		this.add(lbId);
		lbId.setBounds(40, 140, 70, 30);
		lbId.setFont(font15);
		
		this.add(tflbId);
		tflbId.setBounds(120, 140, 100, 30);
		tflbId.setFont(font15);
		
		this.add(lbPw);
		lbPw.setBounds(40, 180, 70, 30);
		lbPw.setFont(font15);
		
		this.add(tflbPw);
		tflbPw.setBounds(120, 180, 100, 30);
		tflbPw.setFont(font15);
		
		this.add(lbName);
		lbName.setBounds(40, 220, 70, 30);
		lbName.setFont(font15);
		
		this.add(tfName);
		tfName.setBounds(120, 220, 100, 30);
		tfName.setFont(font15);
		
		this.add(lbHp);
		lbHp.setBounds(40, 260, 70, 30);
		lbHp.setFont(font15);
		
		this.add(tfHp);
		tfHp.setBounds(120, 260, 100, 30);
		tfHp.setFont(font15);
		
		this.add(lbGd);
		lbGd.setBounds(40, 300, 70, 30);
		lbGd.setFont(font15);
		
		this.add(gc);
		gc.setBounds(120, 300, 70, 30);
		gc.add("남성");
		gc.add("여성");
		
		this.add(bt);
		bt.setBounds(110, 370, 120, 40);
		bt.setFont(font15);
		
		this.add(bt2);
		bt2.setBounds(235, 139, 100, 30);
		bt2.setFont(font15);
	}
	public void start() 
	{
		gc.addItemListener(this);
		bt.addActionListener(this);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{
				System.exit(0);
			}
		});
	}
	
	public void itemStateChanged(ItemEvent e) 
	{
		if (e.getSource() == gc) 
		{
			if(gc.getSelectedItem().equals("남성"))
			{
				System.out.println("Choice..Men..");
			}
			else if(gc.getSelectedItem().equals("여성"))
			{
				System.out.println("Choice..Women..");
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()== bt)
		{
			try {
				Class.forName("org.gjt.mm.mysql.Driver");
				} catch (ClassNotFoundException ee) {
				System.out.println("드라이브 없음!!");
				}
				Connection conn = null;
				String url = "jdbc:mysql://localhost:3306/member?useUnicode=true&characterEncoding=utf8";
				String user = "root";// ID
				String password = "qwer";// 비밀번호
				try {
					conn = DriverManager.getConnection(url, user, password);
					System.out.println("연결되었습니다.");
					} catch (SQLException ee) {
					System.err.println("연결객체 생성실패!!");
					}
			
			
			String query = "select * from tb_member2";
			Statement stmt = null;
			String pquery = "insert into tb_member2 values (null, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = null;
			try {
				stmt = conn.createStatement();
				pstmt = conn.prepareStatement(pquery);
				pstmt.setString(1, "id");
				pstmt.setString(2, "pass");
				pstmt.setString(3, "name");
				pstmt.setString(4, "hp");
				pstmt.setString(5, "sex");
				pstmt.executeUpdate();
				System.out.println("실행성공");
			} catch (SQLException ee) {
				System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
			}
			// 4. ResultSet 객체생성
			// ResultSet rs = stmt.executeQuery(query);
			// ResultSet rs = pstmt.executeQuery();
			String query1 = "select * from tb_member2";
			ResultSet rs = null;
			try {
				rs = stmt.executeQuery(query1);
				while (rs.next()) {
					int num = rs.getInt("idx");
					String name = rs.getString("name");
					System.out.println(num + " : " + name);
				}
			} catch (SQLException ee) {
				System.err.println("실행결과 획득실패!!");
			}
			// 5. Close 작업
			try {
					rs.close();
					pstmt.close();
					stmt.close();
					if (conn != null) 
					{
						if (!conn.isClosed()) 
						{
							conn.close();
						}
						conn = null;
					}
				} 
			catch (SQLException ee) 
			{
				System.err.println("닫기 실패~!!");
			}
		}
		
		if(e.getSource() == bt2)
		{
			
		}
	}
}