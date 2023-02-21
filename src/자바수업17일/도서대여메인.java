package 자바수업17일;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class booksBoardMain extends Frame implements ActionListener
{
	Label lbTitle = new Label("메인화면");	
	Button btnManage = new Button("도서 관리");	
	Button btnMember = new Button("회원 관리");
	Button btnInquiry = new Button("관리자 문의");
	Button btnOwner = new Button("관리자 화면");
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	booksBoardMain()
	{
		super("메인화면");
		this.setSize(300,350);
		this.init();//화면레이아웃구성메서드
		this.start();
		this.setLocation(500, 300);
		this.setVisible(true);
	}
	void start()
	{
		btnManage.addActionListener(this);
		btnMember.addActionListener(this);
		btnInquiry.addActionListener(this);
		btnOwner.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				WinClose();
			}
		});
	}
	void init() //레이아웃 구성하기...
	{
		this.setLayout(null);//레이아웃을 직접좌표처리하는방식으로하기위해서...
		this.add(lbTitle);//현재 클래스 내부에 생성해서 넣음...
		lbTitle.setBounds(100, 40, 220, 30);
		lbTitle.setFont(font25);
		
		this.add(btnManage);//현재 클래스 내부에 생성해서 넣음...
		btnManage.setBounds(80, 100, 140, 40);
		btnManage.setFont(font15);	

		this.add(btnMember);//현재 클래스 내부에 생성해서 넣음...
		btnMember.setBounds(80, 150, 140, 40);
		btnMember.setFont(font15);
		
		this.add(btnInquiry);//현재 클래스 내부에 생성해서 넣음...
		btnInquiry.setBounds(80, 200, 140, 40);
		btnInquiry.setFont(font15);
		
		this.add(btnOwner);//현재 클래스 내부에 생성해서 넣음...
		btnOwner.setBounds(80, 250, 140, 40);
		btnOwner.setFont(font15);
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnManage) {bookRentalMain rm = new bookRentalMain();}
		if(e.getSource() == btnMember) {membersMainView mv = new membersMainView();}
		if(e.getSource() == btnInquiry) {bookInquiry bInquiry = new bookInquiry();}
		if(e.getSource() == btnOwner) {booksBoardList.mList.removeAll();//리시트항목 모두제거
										booksBoardList bList = new booksBoardList();}
	}
	void WinClose()
	{
		this.setVisible(false);
	}
}

