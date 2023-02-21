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

class bookManageMentMain extends Frame implements ActionListener{
	Label lbTitle = new Label("메인화면");	
	Button btnBookinput = new Button("책등록");	
	Button btnBookList = new Button("책리스트");
	Button btnBookEdit = new Button("책정보수정");
	Button btnBookDel = new Button("책삭제");
	Button btnClose = new Button("닫기");
	
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	bookManageMentMain()
	{
		super("메인화면");
		this.setSize(300,450);
		this.init();//화면레이아웃구성메서드
		this.start();
		this.setLocation(600, 400);
		this.setVisible(true);
	}
	void start()
	{
		btnBookinput.addActionListener(this);
		btnBookList.addActionListener(this);
		btnBookEdit.addActionListener(this);
		btnBookDel.addActionListener(this);
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
		
		this.add(btnBookinput);//현재 클래스 내부에 생성해서 넣음...
		btnBookinput.setBounds(80, 100, 140, 40);
		btnBookinput.setFont(font15);	

		this.add(btnBookList);//현재 클래스 내부에 생성해서 넣음...
		btnBookList.setBounds(80, 150, 140, 40);
		btnBookList.setFont(font15);
		
		this.add(btnBookEdit);//현재 클래스 내부에 생성해서 넣음...
		btnBookEdit.setBounds(80, 200, 140, 40);
		btnBookEdit.setFont(font15);
		
		this.add(btnBookDel);//현재 클래스 내부에 생성해서 넣음...
		btnBookDel.setBounds(80, 250, 140, 40);
		btnBookDel.setFont(font15);
		
		this.add(btnClose);//현재 클래스 내부에 생성해서 넣음...
		btnClose.setBounds(80, 350, 140, 40);
		btnClose.setFont(font15);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBookinput)      {BookManagement bm = new BookManagement();}
		else if(e.getSource()==btnBookList) {BookList bl = new BookList();}
		else if(e.getSource()==btnBookEdit)  {BookEdit be = new BookEdit();}
		else if(e.getSource()==btnBookDel) {BookDel bd = new BookDel();}
		else if(e.getSource()==btnClose){ System.exit(0);}
	}
	void WinClose()
	{
		this.setVisible(false);
	}
}