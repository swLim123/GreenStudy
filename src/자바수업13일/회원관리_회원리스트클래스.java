package 자바수업13일;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class memberList extends Frame implements ItemListener, ActionListener
{
	Choice gc = new Choice();
	Label lbTitle = new Label("회원목록 리스트");
	List li = new List();
	Button bt = new Button("확인");
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	memberList()
	{
		super("회원가입");
		this.setSize(350, 450);
		this.init();
		this.start();
		this.setLocation(400, 200);
		dataload();
		this.setVisible(true);
	}
	void init()
	{
		this.setLayout(null);
		this.add(lbTitle);
		lbTitle.setBounds(90, 40, 270, 30);
		lbTitle.setFont(font25);
		
		this.add(li);
		li.setFont(font15);
		li.setBounds(50, 100, 240, 220);
		/*li.add("1 / hong / 홍길동 / 1111111");
		li.add("2 / cms / 아무개 / 2222222");
		li.add("3 / abc / 둘리 / 3333333");*/
		
		this.add(bt);		
		bt.setFont(font15);	
		bt.setBounds(130, 340, 80, 30);
		
	}
	public void start() 
	{
		bt.addActionListener(this);
		li.addItemListener(this);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{
				dispose();
			}
		});
	}	
	public void itemStateChanged(ItemEvent e) 
	{
		
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == bt)
		{
			bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewClose();
				}
			});
		}
	}
	void ViewClose()
	{
		this.setVisible(false);
	}
	void dataload()
	{
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.exit(0);
		}
		Connection conn = null;
		//접속 주소 : 3306/디비
		String url = "jdbc:mysql://localhost:3306/member?useUnicode=true&characterEncoding=utf8";
		//12.0.0.1 = 자기 자신을 가르킨다.
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from tb_member2";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			String result =  "";
			while (rs.next()) {
				result = rs.getString("idx") + rs.getString("id") + rs.getString("pass") + 
						rs.getString("name") + rs.getString("hp") + rs.getString("sex");
				System.out.println("result:"+result);
				li.add(result);
				}
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
}
