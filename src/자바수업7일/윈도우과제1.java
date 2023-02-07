package 자바수업7일;
import java.awt.*;
public class 윈도우과제1
{
	public static void main(String[] args) 
	{
		WinStudy1 wt = new WinStudy1();
	}
}

class WinStudy1 extends Frame
{
	Label lbTitle = new Label("회원가입하기");
	Label lbId = new Label("아이디:");
	Label lbPw = new Label("패스워드:");
	Label lbName = new Label("이름:");
	Label lbHp = new Label("연락처:");
	TextField tflbId = new TextField();
	TextField tflbPw = new TextField();
	TextField tfName = new TextField();
	TextField tfHp = new TextField();
	Button bt = new Button("가입하기");
	Button bt2 = new Button("확인");
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	WinStudy1()
	{
		super("회원가입");
		this.setSize(350, 450);
		this.init();
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
		
		this.add(bt);
		bt.setBounds(140, 350, 70, 40);
		bt.setFont(font15);
		
		this.add(bt2);
		bt2.setBounds(240, 139, 50, 30);
		bt2.setFont(font15);
	}
}