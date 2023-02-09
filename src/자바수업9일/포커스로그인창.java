package 자바수업9일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class 포커스로그인창 
{
	public static void main(String[] args) 
	{
		LoginWin log = new LoginWin();
	}
}
class LoginWin extends Frame implements FocusListener, ActionListener 
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
		this.start();
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
	public void start() {
		tflbId.addFocusListener(this);
		tflbPw.addFocusListener(this);
		bt.addActionListener(this);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{
				System.exit(0);
			}
		});
	}

	public void focusGained(FocusEvent e) 
	{
		if (e.getSource() == tflbId) 
		{
			
		}
		 else if (e.getSource() == tflbPw) 
		{
			if(tflbId.getText().equals(""))
			{
				tflbId.requestFocus();
				System.out.println("ID input plz...");
			}
			int check = tflbId.getText().trim().length();//아이디의 길이 체크
			if(check>12)
			{
				tflbId.requestFocus();
				tflbId.setText("");
				System.out.println("Id length MAX 12.....");
			}
		}
		
	}
	
	@Override
	public void focusLost(FocusEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bt)
		{
			if(tflbId.getText().equals(""))
			{
				System.out.println("Id input...plz...");
				return;
			}
			if(tflbPw.getText().equals(""))
			{
				System.out.println("Pw input...plz...");
				return;
			}
		}
	}
}