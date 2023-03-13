package 스레드_2;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


class SubCom4 extends Frame implements ActionListener,Runnable{
	private Dimension dimen;
	int fullSizeWidth, fullSizeHeight;
	int x,y;
	Label lbTitle = new Label("기계4 조작반");	
	Button btnCom1 = new Button("전원ON");	
	Button btnCom2 = new Button("전원OFF");

	Font font35 = new Font("TimesRoman", Font.PLAIN, 35);
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	static int com4Cnt;
	
	static boolean com4Start=false;
	SubCom4()
	{
		super("기계4 조작반");
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		fullSizeWidth = (int) (dimen.getWidth()/4);//모든해상도 화면가로의반
		fullSizeHeight= (int) (dimen.getHeight()/3);//모든해상도 화면세로꽉
		x = (int) dimen.getWidth()/2 + (int) dimen.getWidth()/4;
		y = 0;
		this.setSize(fullSizeWidth,fullSizeHeight);
		this.init();
		this.start();
		this.setLocation(x, y);
		this.setVisible(true);
		
		System.out.println("사이즈 체크w :"+ dimen.getWidth());
		System.out.println("사이즈 체크h :"+ dimen.getHeight());
		
	}
	void start()
	{
		btnCom1.addActionListener(this);
		btnCom2.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	void init() //레이아웃 구성하기...
	{
		this.setLayout(null);//레이아웃을 직접좌표처리하는방식으로하기위해서...
		this.add(lbTitle);//현재 클래스 내부에 생성해서 넣음...
		lbTitle.setBounds(100, 50, 300, 50);
		lbTitle.setFont(font25);
		
		this.add(btnCom1);btnCom1.setFont(font25);
		this.add(btnCom2);btnCom2.setFont(font25);		
		
		btnCom1.setBounds(50,130,120,50);		
		btnCom2.setBounds(250,130,120,50);

		
	
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCom1)      {
			MainProgram.btnCom4.enable(false);
			MainProgram.lbCom4.setForeground(Color.RED);
			MainProgram.lbCom4.setText("가동중.");
			com4Start =true;   }
		else if(e.getSource() == btnCom2) {
			MainProgram.btnCom4.enable(true);
			MainProgram.lbCom4.setForeground(Color.BLACK);
			MainProgram.lbCom4.setText("대기중.");
			com4Start =false;}
	}
	@Override
	public void run() {
		while(true)
		{
			//바로 인식이 안되서 살짝 딜레이주기...
			try {Thread.sleep(100);} catch (InterruptedException e) {}	
			
			if(com4Start==true)
			{
				com4Cnt++;
				try {Thread.sleep(2000);MainProgram.lbCom4Cnt.setText("기계4출하량:"+com4Cnt+"개");
				} catch (InterruptedException e) {}
			}
		}
		
	}

}



