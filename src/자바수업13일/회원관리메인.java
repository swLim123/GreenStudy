package 자바수업13일;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
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


class MainWin extends Frame implements ActionListener
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
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{
				System.exit(0);
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == bt1)
		{
			memberList ml = new memberList();
		}
		if(e.getSource() == bt2)
		{
			memberEdit me = new memberEdit();
		}
		if(e.getSource() == bt3)
		{
			
		}
		if(e.getSource() == bt4)
		{
			
		}
	}
}