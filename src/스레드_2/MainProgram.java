package 스레드_2;

import java.awt.Button;
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


class MainProgram extends Frame implements ActionListener,Runnable{
		
	private Dimension dimen;
	int fullSizeWidth, fullSizeHeight;
	Label lbTitle = new Label("공장 가동 체크 프로그램");	
	static Button btnCom1 = new Button("기계1");	
	static Button btnCom2 = new Button("기계2");
	static Button btnCom3 = new Button("기계3");
	static Button btnCom4 = new Button("기계4");
	static Button btnCom5 = new Button("기계5");
	static Button btnCom6 = new Button("기계6");
	static Button btnAdmin = new Button("관리자");
	
	static Label lbCom1 = new Label("대기중.",Label.CENTER);
	static Label lbCom2 = new Label("대기중.",Label.CENTER);
	static Label lbCom3 = new Label("대기중.",Label.CENTER);
	static Label lbCom4 = new Label("대기중.",Label.CENTER);
	static Label lbCom5 = new Label("대기중.",Label.CENTER);
	static Label lbCom6 = new Label("대기중.",Label.CENTER);
	
	static Label lbCom1Cnt = new Label("기계1출하량:0개",Label.LEFT);
	static Label lbCom2Cnt = new Label("기계2출하량:0개",Label.LEFT);
	static Label lbCom3Cnt = new Label("기계3출하량:0개",Label.LEFT);
	static Label lbCom4Cnt = new Label("기계4출하량:0개",Label.LEFT);
	static Label lbCom5Cnt = new Label("기계5출하량:0개",Label.LEFT);
	static Label lbCom6Cnt = new Label("기계6출하량:0개",Label.LEFT);
	Label lbComTotCnt = new Label("총출하량:0개",Label.LEFT);
	

	Font font35 = new Font("TimesRoman", Font.PLAIN, 35);
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	int tot;//총출하량
	MainProgram()
	{
		super("공장 가동 체크 프로그램");
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		fullSizeWidth = (int) (dimen.getWidth()/2);//모든해상도 화면가로의반
		fullSizeHeight= (int) (dimen.getHeight());//모든해상도 화면세로꽉
		this.setSize(fullSizeWidth,fullSizeHeight);
		this.init();
		this.start();
		this.setLocation(0, 0);
		this.setVisible(true);
		
		System.out.println("사이즈 체크w :"+ dimen.getWidth());
		System.out.println("사이즈 체크h :"+ dimen.getHeight());
		
	}
	void start()
	{	
		
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
		lbTitle.setBounds(170, 40, 1000, 50);
		lbTitle.setFont(font35);
		
		this.add(btnCom1);btnCom1.setFont(font25);
		this.add(btnCom2);btnCom2.setFont(font25);
		this.add(btnCom3);btnCom3.setFont(font25);
		this.add(btnCom4);btnCom4.setFont(font25);
		this.add(btnCom5);btnCom5.setFont(font25);
		this.add(btnCom6);btnCom6.setFont(font25);
		this.add(btnAdmin);btnAdmin.setFont(font25);
		
		this.add(lbCom1);lbCom1.setFont(font25);
		this.add(lbCom2);lbCom2.setFont(font25);
		this.add(lbCom3);lbCom3.setFont(font25);
		this.add(lbCom4);lbCom4.setFont(font25);
		this.add(lbCom5);lbCom5.setFont(font25);
		this.add(lbCom6);lbCom6.setFont(font25);
		
	
		this.add(lbCom1Cnt);lbCom1Cnt.setFont(font25);
		this.add(lbCom2Cnt);lbCom2Cnt.setFont(font25);
		this.add(lbCom3Cnt);lbCom3Cnt.setFont(font25);
		this.add(lbCom4Cnt);lbCom4Cnt.setFont(font25);
		this.add(lbCom5Cnt);lbCom5Cnt.setFont(font25);
		this.add(lbCom6Cnt);lbCom6Cnt.setFont(font25);
		this.add(lbComTotCnt);lbComTotCnt.setFont(font25);
		
		btnCom3.setBounds(50,100,200,200);btnCom4.setBounds(300,100,200,200);btnCom5.setBounds(550,100,200,200);
		btnCom2.setBounds(50,400,200,200);									 btnCom6.setBounds(550,400,200,200);
		btnCom1.setBounds(50,700,200,200);									 btnAdmin.setBounds(550,700,200,200);
		
		lbCom3.setBounds(50,300,200,30);lbCom4.setBounds(300,300,200,30);  lbCom5.setBounds(550,300,200,30);
		lbCom2.setBounds(50,600,200,30);									 lbCom6.setBounds(550,600,200,30);
		lbCom1.setBounds(50,900,200,30);
		
		lbCom1Cnt.setBounds(300,400,250,40);	
		lbCom2Cnt.setBounds(300,450,250,40);	
		lbCom3Cnt.setBounds(300,500,250,40);	
		lbCom4Cnt.setBounds(300,550,250,40);	
		lbCom5Cnt.setBounds(300,600,250,40);	
		lbCom6Cnt.setBounds(300,650,250,40);	
		lbComTotCnt.setBounds(300,700,250,40);
		
		
	
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	@Override
	public void run() {		
		while(true)
		{
			//바로 인식이 안되서 살짝 딜레이주기...
			try {Thread.sleep(500);} catch (InterruptedException e) {}			
			
			
			tot = SubCom1.com1Cnt+SubCom2.com2Cnt+SubCom3.com3Cnt+
					SubCom4.com4Cnt+SubCom5.com5Cnt+SubCom6.com6Cnt;
			lbComTotCnt.setText("총 출하량:"+tot+"개");
			
		}
		
	}

}



