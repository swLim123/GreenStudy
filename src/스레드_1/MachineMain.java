package 스레드_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
	
class MachineMain extends Frame implements Runnable, ActionListener
{
	int m1Count = 0;
	int m2Count = 0;
	int m3Count = 0;
	int m4Count = 0;
	int m5Count = 0;
	int m6Count = 0; 
	int totCount = 0;
	boolean btn1Check = false;
	boolean btn2Check = false;
	boolean btn3Check = false;
	boolean btn4Check = false;
	boolean btn5Check = false;
	boolean btn6Check = false;
	
	Label lbTitle = new Label("공장 가동 체크 프로그램");
	Label lbMachine1 = new Label("기계1 출하량: " + m1Count + "개");
	Label lbMachine2 = new Label("기계2 출하량: " + m2Count + "개");
	Label lbMachine3 = new Label("기계3 출하량: " + m3Count + "개");
	Label lbMachine4 = new Label("기계4 출하량: " + m4Count + "개");
	Label lbMachine5 = new Label("기계5 출하량: " + m5Count + "개");
	Label lbMachine6 = new Label("기계6 출하량: " + m6Count + "개");
	Label lbTotMachine = new Label("총 출하량:" +( m1Count + m2Count + m3Count +
												m4Count + m5Count + m6Count ) + "개");
	Label lbM1Start = new Label("가동중");
	Label lbM2Start = new Label("가동중");
	Label lbM3Start = new Label("가동중");
	Label lbM4Start = new Label("가동중");
	Label lbM5Start = new Label("가동중");
	Label lbM6Start = new Label("가동중");
	Button btnMachine1 = new Button("기계1");
	Button btnMachine2 = new Button("기계2");
	Button btnMachine3 = new Button("기계3");
	Button btnMachine4 = new Button("기계4");
	Button btnMachine5 = new Button("기계5");
	Button btnMachine6 = new Button("기계6");
	Button btnAdmin = new Button("관리자");
	
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	
	MachineMain()
	{
		super("기계 가동 제어");
		this.setSize(500,500);
		this.init();
		this.start();
		this.setLocation(200,300);
		this.setVisible(true);
		run();
	}
	public void init()
	{
		this.setLayout(null);
		
		this.add(lbTitle);
		lbTitle.setBounds(90, 40, 300, 30);
		lbTitle.setFont(font25);
		
		this.add(lbMachine1);
		lbMachine1.setBounds(180, 250, 150, 30);
		lbMachine1.setFont(font15);
		
		this.add(lbMachine2);
		lbMachine2.setBounds(180, 280, 150, 30);
		lbMachine2.setFont(font15);
		
		this.add(lbMachine3);
		lbMachine3.setBounds(180, 310, 150, 30);
		lbMachine3.setFont(font15);
		
		this.add(lbMachine4);
		lbMachine4.setBounds(180, 340, 150, 30);
		lbMachine4.setFont(font15);
		
		this.add(lbMachine5);
		lbMachine5.setBounds(180, 370, 150, 30);
		lbMachine5.setFont(font15);
		
		this.add(lbMachine6);
		lbMachine6.setBounds(180, 400, 150, 30);
		lbMachine6.setFont(font15);
		
		this.add(lbTotMachine);
		lbTotMachine.setBounds(180, 430, 150, 30);
		lbTotMachine.setFont(font15);
		
		this.add(btnMachine1);
		btnMachine1.setBounds(60, 130, 90, 90);
		btnMachine1.setFont(font15);
		btnMachine1.setEnabled(true);
		
		this.add(btnMachine2);
		btnMachine2.setBounds(60, 250, 90, 90);
		btnMachine2.setFont(font15);
		btnMachine2.setEnabled(true);
		
		this.add(btnMachine3);
		btnMachine3.setBounds(60, 370, 90, 90);
		btnMachine3.setFont(font15);
		btnMachine3.setEnabled(true);
		
		this.add(btnMachine4);
		btnMachine4.setBounds(200, 130, 90, 90);
		btnMachine4.setFont(font15);
		btnMachine4.setEnabled(true);
		
		this.add(btnMachine5);
		btnMachine5.setBounds(340, 130, 90, 90);
		btnMachine5.setFont(font15);
		btnMachine5.setEnabled(true);
		
		this.add(btnMachine6);
		btnMachine6.setBounds(340, 250, 90, 90);
		btnMachine6.setFont(font15);
		btnMachine6.setEnabled(true);
		
		this.add(btnAdmin);
		btnAdmin.setBounds(340, 370, 90, 90);
		btnAdmin.setFont(font15);
		
		this.add(lbM1Start);
		lbM1Start.setBounds(60, 220, 60, 30);
		lbM1Start.setFont(font15);
		lbM1Start.setForeground(Color.RED);
		lbM1Start.setVisible(false);
		
		this.add(lbM2Start);
		lbM2Start.setBounds(60, 340, 60, 30);
		lbM2Start.setFont(font15);
		lbM2Start.setForeground(Color.RED);
		lbM2Start.setVisible(false);
		
		this.add(lbM3Start);
		lbM3Start.setBounds(60, 460, 60, 30);
		lbM3Start.setFont(font15);
		lbM3Start.setForeground(Color.RED);
		lbM3Start.setVisible(false);
		
		this.add(lbM4Start);
		lbM4Start.setBounds(200, 220, 60, 30);
		lbM4Start.setFont(font15);
		lbM4Start.setForeground(Color.RED);
		lbM4Start.setVisible(false);
		
		this.add(lbM5Start);
		lbM5Start.setBounds(340, 220, 60, 30);
		lbM5Start.setFont(font15);
		lbM5Start.setForeground(Color.RED);
		lbM5Start.setVisible(false);
		
		this.add(lbM6Start);
		lbM6Start.setBounds(340, 340, 60, 30);
		lbM6Start.setFont(font15);
		lbM6Start.setForeground(Color.RED);
		lbM6Start.setVisible(false);
		
	}
	void start()
	{
		Machine1.btnM1On.addActionListener(this);
		Machine1.btnM1Off.addActionListener(this);
		Machine2.btnM2On.addActionListener(this);
		Machine2.btnM2Off.addActionListener(this);
		Machine3.btnM3On.addActionListener(this);
		Machine3.btnM3Off.addActionListener(this);
		Machine4.btnM4On.addActionListener(this);
		Machine4.btnM4Off.addActionListener(this);
		Machine5.btnM5On.addActionListener(this);
		Machine5.btnM5Off.addActionListener(this);
		Machine6.btnM6On.addActionListener(this);
		Machine6.btnM6Off.addActionListener(this);
		btnAdmin.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == Machine1.btnM1On)
		{
			btnMachine1.setEnabled(false);
			lbM1Start.setVisible(true);
			btn1Check = true;
		}
		else if(e.getSource() == Machine1.btnM1Off)
		{
			btnMachine1.setEnabled(true);
			lbM1Start.setVisible(false);
			btn1Check = false;
		}
		else if(e.getSource() == Machine2.btnM2On)
		{
			btnMachine2.setEnabled(false);
			lbM2Start.setVisible(true);
			btn2Check = true;
		}
		else if(e.getSource() == Machine2.btnM2Off)
		{
			btnMachine2.setEnabled(true);
			lbM2Start.setVisible(false);
			btn2Check = false;
		}
		else if(e.getSource() == Machine3.btnM3On)
		{
			btnMachine3.setEnabled(false);
			lbM3Start.setVisible(true);
			btn3Check = true;
		}
		else if(e.getSource() == Machine3.btnM3Off)
		{
			btnMachine3.setEnabled(true);
			lbM3Start.setVisible(false);
			btn3Check = false;
		}
		else if(e.getSource() == Machine4.btnM4On)
		{
			btnMachine4.setEnabled(false);
			lbM4Start.setVisible(true);
			btn4Check = true;
		}
		else if(e.getSource() == Machine4.btnM4Off)
		{
			btnMachine4.setEnabled(true);
			lbM4Start.setVisible(false);
			btn4Check = false;
		}
		else if(e.getSource() == Machine5.btnM5On)
		{
			btnMachine5.setEnabled(false);
			lbM5Start.setVisible(true);
			btn5Check = true;
		}
		else if(e.getSource() == Machine5.btnM5Off)
		{
			btnMachine5.setEnabled(true);
			lbM5Start.setVisible(false);
			btn5Check = false;
		}
		else if(e.getSource() == Machine6.btnM6On)
		{
			btnMachine6.setEnabled(false);
			lbM6Start.setVisible(true);
			btn6Check = true;
		}
		else if(e.getSource() == Machine6.btnM6Off)
		{
			btnMachine6.setEnabled(true);
			lbM6Start.setVisible(false);
			btn6Check = false;
		}
	}
	public void run()
	{
		try
		{
			while(true)
			{
				Thread.sleep(2000);
				
				if(btn1Check == true)
				{
					m1Count++;
					lbMachine1.setText("기계1 출하량: " + m1Count + "개");
				}
				if(btn2Check == true)
				{
					m2Count++;
					lbMachine2.setText("기계1 출하량: " + m2Count + "개");
				}
				if(btn3Check == true)
				{
					m3Count++;
					lbMachine3.setText("기계1 출하량: " + m3Count + "개");
				}
				if(btn4Check == true)
				{
					m4Count++;
					lbMachine4.setText("기계1 출하량: " + m4Count + "개");
				}
				if(btn5Check == true)
				{
					m5Count++;
					lbMachine5.setText("기계1 출하량: " + m5Count + "개");
				}
				if(btn6Check == true)
				{
					m6Count++;
					lbMachine6.setText("기계1 출하량: " + m6Count + "개");
				}
				lbTotMachine.setText("총 출하량:" +( m1Count + m2Count + m3Count +
						m4Count + m5Count + m6Count ) + "개");
			}
		} 
		catch (InterruptedException e)
		{
			System.out.println("스레드 오류!");
			e.printStackTrace();
		}
	}
}
