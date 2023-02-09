package 자바수업9일;

import java.awt.*;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class 윈도우다이얼로그 
{
	public static void main(String[] args) 
	{
		LoginWin2 lw2 = new LoginWin2();
	}
}
class LoginWin2 extends Frame implements ItemListener, ActionListener
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

	LoginWin2()
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
		bt2.addActionListener(this);
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
	
			Dialog dlg = new Dialog(this, "OK", true);
			Button bt = new Button();
			Label lb = new Label("아이디가 중복 되었습니다.");
			dlg.setLayout(null);
			dlg.add(lb);
			dlg.add(bt);
			lb.setFont(font15);
			lb.setBounds(50, 50, 200, 30);
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
	}
