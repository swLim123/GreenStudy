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

class bookRentalMain extends Frame implements ActionListener{
	Label lbTitle = new Label("메인화면");	
	Button btnBookRental = new Button("도서대여");	
	Button btnBookReturn = new Button("도서반납");
	Button btnBookRenList = new Button("대여가능책 리스트");
	Button btnBookRetList = new Button("미반남회원 리스트");
	Button btnBookmng = new Button("책 관리");
	Button btnClose = new Button("닫기");
	
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	bookRentalMain()
	{
		super("메인화면");
		this.setSize(300,450);
		this.init();//화면레이아웃구성메서드
		this.start();
		this.setLocation(550, 350);
		this.setVisible(true);
	}
	void start()
	{
		btnBookmng.addActionListener(this);
		btnBookRental.addActionListener(this);
		btnBookReturn.addActionListener(this);
		btnBookRenList.addActionListener(this);
		btnBookRetList.addActionListener(this);
		btnClose.addActionListener(this);
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
		
		this.add(btnBookRental);//현재 클래스 내부에 생성해서 넣음...
		btnBookRental.setBounds(80, 100, 140, 40);
		btnBookRental.setFont(font15);	

		this.add(btnBookReturn);//현재 클래스 내부에 생성해서 넣음...
		btnBookReturn.setBounds(80, 150, 140, 40);
		btnBookReturn.setFont(font15);
		
		this.add(btnBookRenList);//현재 클래스 내부에 생성해서 넣음...
		btnBookRenList.setBounds(80, 200, 140, 40);
		btnBookRenList.setFont(font15);
		
		this.add(btnBookRetList);//현재 클래스 내부에 생성해서 넣음...
		btnBookRetList.setBounds(80, 250, 140, 40);
		btnBookRetList.setFont(font15);
		
		this.add(btnBookmng);//현재 클래스 내부에 생성해서 넣음...
		btnBookmng.setBounds(80, 300, 140, 40);
		btnBookmng.setFont(font15);
		
		this.add(btnClose);//현재 클래스 내부에 생성해서 넣음...
		btnClose.setBounds(80, 350, 140, 40);
		btnClose.setFont(font15);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBookRental)      {BookRental br = new BookRental();}
		else if(e.getSource()==btnBookReturn) {BookReturn bt = new BookReturn();}
		else if(e.getSource()==btnBookRenList)  {BookRentalList rl = new BookRentalList();}
		else if(e.getSource()==btnBookRetList) {BookNReturnList bn = new BookNReturnList();}
		else if(e.getSource()==btnBookmng) {bookManageMentMain bm = new bookManageMentMain();}
		else if(e.getSource()==btnClose){ System.exit(0);}
	}
	void WinClose()
	{
		this.setVisible(false);
	}
}