package 자바수업9일;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class 회원목록리스트 
{
	public static void main(String[] args) 
	{
		WinStudy2 wt2 = new WinStudy2();
	}
}
class WinStudy2 extends Frame implements ItemListener
{
	Choice gc = new Choice();
	Label lbTitle = new Label("회원목록 리스트");
	List li = new List();
	Button bt = new Button("확인");
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	WinStudy2()
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
		lbTitle.setBounds(90, 40, 270, 30);
		lbTitle.setFont(font25);
		
		this.add(li);
		li.setFont(font15);
		li.setBounds(50, 100, 240, 220);
		li.add("1 / hong / 홍길동 / 1111111");
		li.add("2 / cms / 아무개 / 2222222");
		li.add("3 / abc / 둘리 / 3333333");
		
		this.add(bt);		
		bt.setFont(font15);	
		bt.setBounds(130, 340, 80, 30);
		
	}
	public void start() 
	{
		li.addItemListener(this);
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
		
	}
}