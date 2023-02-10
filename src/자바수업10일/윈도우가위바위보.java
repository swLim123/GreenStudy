package 자바수업10일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class 윈도우가위바위보 
{
	public static void main(String[] args) 
	{
		Rps rps = new Rps();
	}
}
class Rps extends Frame implements ActionListener,ItemListener
{
	Label lbTitle = new Label("가위바위보 게임");
	Label lbMe = new Label("내 선택:");
	Label lbCom = new Label("컴퓨터:");
	Label lbComChoice = new Label("대기중...");
	Label lbResult = new Label("결과:");
	Button btnStart = new Button("게임시작");	
	Button btnResult = new Button("통계확인");
	Choice myChoice = new Choice();
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	int playCount = 0;
	int winCount = 0;
	int loseCount = 0;
	int drawCount = 0;
	
	Rps()
	{
		super("가위바위보");
		this.setSize(300, 350);
		this.setLocation(500, 300);
		this.setVisible(true);
		this.start();
		this.init();
	}
	void start()
	{
		myChoice.addItemListener(this);
		btnStart.addActionListener(this);
		btnResult.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	void init()
	{
		this.setLayout(null);
		this.add(lbTitle);
		lbTitle.setBounds(60, 40, 220, 30);
		lbTitle.setFont(font25);
		
		this.add(lbMe);
		lbMe.setBounds(30, 90, 70, 30);
		lbMe.setFont(font15);
		
		this.add(lbCom);
		lbCom.setBounds(30, 150, 70, 30);
		lbCom.setFont(font15);
		
		this.add(myChoice);
		myChoice.setBounds(100, 90, 70, 30);
		myChoice.setFont(font15);
		myChoice.add("가위");
		myChoice.add("바위");
		myChoice.add("보");
		
		this.add(lbComChoice);
		lbComChoice.setBounds(100, 150, 200, 30);
		lbComChoice.setFont(font15);
		
		this.add(btnStart);
		btnStart.setBounds(190, 85, 70, 30);
		btnStart.setFont(font15);
		
		this.add(lbResult);
		lbResult.setBounds(30, 200, 250, 30);
		lbResult.setFont(font15);
		
		this.add(btnResult);
		btnResult.setBounds(100, 250, 90, 40);
		btnResult.setFont(font15);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnStart)
		{
			lbResult.setText("결과:  대기중...");
			ing();
			ResultLable();
		}
		if(e.getSource() == btnResult)
		{
			dlgMsg();
		}
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		
	}
	void ing()
	{
		try {
			Thread.sleep(300);
			lbComChoice.setText("컴퓨터가 생각중.");
			Thread.sleep(300);
			lbComChoice.setText("컴퓨터가 생각중..");
			Thread.sleep(300);
			lbComChoice.setText("컴퓨터가 생각중...");
			Thread.sleep(300);
			lbComChoice.setText("컴퓨터가 생각중.");
			Thread.sleep(300);
			lbComChoice.setText("컴퓨터가 생각중..");
			Thread.sleep(300);
			lbComChoice.setText("컴퓨터가 생각중...");
			Thread.sleep(500);
			lbComChoice.setText("3...");
			Thread.sleep(500);
			lbComChoice.setText("2..");
			Thread.sleep(500);
			lbComChoice.setText("1.");	
			Thread.sleep(500);
			
		} catch (InterruptedException e) {}
	}

	void ResultLable()
	{
		int comChoice = (int)(Math.random()*3);
		String comResult = com(comChoice);
		if(myChoice.getSelectedItem() == "가위")
		{
			if(comResult.equals("가위")) 
			{
				lbResult.setText("결과: 나 = 가위 vs 컴퓨터 = 가위");
				playCount++;
				drawCount++;
			}
			if(comResult.equals("바위")) 
			{
				lbResult.setText("결과: 나 = 가위 vs 컴퓨터 = 바위");
				playCount++;
				loseCount++;
			}
			if(comResult.equals("보")) 
			{
				lbResult.setText("결과: 나 = 가위 vs 컴퓨터 = 보");
				playCount++;
				winCount++;
			}
		}
		else if(myChoice.getSelectedItem() == "바위")
		{
			if(comResult.equals("가위")) 
			{
				lbResult.setText("결과: 나 = 바위 vs 컴퓨터 = 가위");
				playCount++;
				winCount++;
			}
			if(comResult.equals("바위")) 
			{
				lbResult.setText("결과: 나 = 바위 vs 컴퓨터 = 바위");
				playCount++;
				drawCount++;
			}
			if(comResult.equals("보")) 
			{
				lbResult.setText("결과: 나 = 바위 vs 컴퓨터 = 보");
				playCount++;
				loseCount++;
			}
		}
		else if(myChoice.getSelectedItem() == "보")
		{
			if(comResult.equals("가위")) 
			{
				lbResult.setText("결과: 나 = 보 vs 컴퓨터 = 가위");
				playCount++;
				loseCount++;
			}
			if(comResult.equals("바위")) 
			{
				lbResult.setText("결과: 나 = 보 vs 컴퓨터 = 바위");
				playCount++;
				winCount++;
			}
			if(comResult.equals("보")) 
			{
				lbResult.setText("결과: 나 = 보 vs 컴퓨터 = 보");
				playCount++;
				drawCount++;
			}
		}
		lbComChoice.setText(comResult);
	}
	String com(int com)
	{
		if(com == 0) {return "가위";}
		else if(com == 1) {return "바위";}
		else if(com == 2) {return "보";}
		else {return "";}
	}
	void dlgMsg()
	{
		Dialog dlg = new Dialog(this, "통계", true);
		Label lbPlay = new Label("플레이 횟수: " + playCount);
		Label lbWin = new Label("승리 횟수: " + winCount);
		Label lbLose = new Label("패배 횟수: " + loseCount);
		Label lbDraw = new Label("무승부 횟수: " + drawCount);
		Button bt = new Button("확인");		
		dlg.setLayout(null);		
		dlg.add(lbPlay);
		lbPlay.setBounds(50, 50, 200, 30);
		lbPlay.setFont(font15);
		
		dlg.add(lbWin);
		lbWin.setBounds(50, 80, 200, 30);
		lbWin.setFont(font15);
		
		dlg.add(lbLose);
		lbLose.setBounds(50, 110, 200, 30);
		lbLose.setFont(font15);
		
		dlg.add(lbDraw);
		lbDraw.setBounds(50, 140, 200, 30);
		lbDraw.setFont(font15);
		
		dlg.add(bt);
		bt.setBounds(95, 200, 120, 30);
		bt.setFont(font15);		
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
		dlg.setSize(300, 280);
		dlg.setVisible(true);
	}
}
