package 자바수업7일;
import java.awt.*;
public class WindowLayout 
{
	public static void main(String[] args) 
	{
		WinTest1 wt = new WinTest1();
	}
}
class WinTest1 extends Frame
{
	Label lbTitle = new Label("안녕하세요 JAVA!");
	Label lbName = new Label("이름입력:");
	Label lbHp = new Label("연락처 입력:");
	TextField tfName = new TextField();
	TextField tfHp = new TextField();
	Button bt = new Button("확인");
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	WinTest1()
	{
		super("윈도우 프로그래밍 연습");
		this.setSize(300, 400);
		this.init();
		this.setLocation(500, 300);
		this.setVisible(true);
	}
	void init()
	{
		this.setLayout(null);
		this.add(lbTitle);
		lbTitle.setBounds(40, 40, 220, 30);
		lbTitle.setFont(font25);
		
		this.add(lbName);
		lbName.setBounds(40, 120, 70, 30);
		lbName.setFont(font15);
		
		this.add(tfName);
		tfName.setBounds(150, 120, 100, 30);
		tfName.setFont(font15);
		
		this.add(lbHp);
		lbHp.setBounds(40, 200, 100, 30);
		lbHp.setFont(font15);
		
		this.add(tfHp);
		tfHp.setBounds(150, 200, 100, 30);
		tfHp.setFont(font15);
		
		this.add(bt);
		bt.setBounds(150, 300, 70, 40);
		bt.setFont(font15);
	}
}
