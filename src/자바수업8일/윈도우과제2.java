package 자바수업8일;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class 윈도우과제2 
{
	public static void main(String[] args) 
	{
		LoginWin log = new LoginWin();
		MainWin main = new MainWin();
	}
}
class LoginWin extends Frame
{
	Label lbTitle = new Label("로그인화면");
	Label lbId = new Label("아이디:");
	Label lbPw = new Label("패스워드:");
	TextField tflbId = new TextField();
	TextField tflbPw = new TextField();
	Button bt = new Button("로그인");
	Button bt2 = new Button("회원가입");
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	LoginWin()
	{
		super("로그인");
		this.setSize(350, 450);
		this.init();
		this.setLocation(300, 300);
		this.setVisible(true);
	}
	void init()
	{
		this.setLayout(null);
		this.add(lbTitle);
		lbTitle.setBounds(110, 40, 270, 30);
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
		
		this.add(bt);
		bt.setBounds(110, 280, 120, 40);
		bt.setFont(font15);
		
		this.add(bt2);
		bt2.setBounds(110, 340, 120, 40);
		bt2.setFont(font15);
	}
}

class MainWin extends Frame
{
	Label lbTitle = new Label("메인화면");
	Button bt1 = new Button("회원목록 보기");
	Button bt2 = new Button("회원정보 수정");
	Button bt3 = new Button("회원 삭제");
	Button bt4 = new Button("회원 가입");
	Button bt5 = new Button("닫기");
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	MainWin()
	{
		super("메인");
		this.setSize(350, 450);
		this.init();
		this.start();
		this.setLocation(800, 300);
		this.setVisible(true);
	}
	void init()
	{
		this.setLayout(null);
		this.add(lbTitle);
		lbTitle.setBounds(120, 40, 270, 30);
		lbTitle.setFont(font25);
		
		this.add(bt1);
		bt1.setBounds(110, 100, 120, 40);
		bt1.setFont(font15);
		
		this.add(bt2);
		bt2.setBounds(110, 160, 120, 40);
		bt2.setFont(font15);
		
		this.add(bt3);
		bt3.setBounds(110, 220, 120, 40);
		bt3.setFont(font15);
		
		this.add(bt4);
		bt4.setBounds(110, 280, 120, 40);
		bt4.setFont(font15);
		
		this.add(bt5);
		bt5.setBounds(110, 340, 120, 40);
		bt5.setFont(font15);
	}
	void start()
	{
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{
				System.exit(0);
			}
		});
	}
}
