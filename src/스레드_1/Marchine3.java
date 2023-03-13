package 스레드_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Machine3 extends Frame implements ActionListener
{
	Label lbTitle = new Label("기계3 조작반");
	public static Button btnM3On = new Button("전원ON");
	public static Button btnM3Off = new Button("전원OFF");
	
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	
	Machine3()
	{
		super("기계 가동 제어");
		this.setSize(300,200);
		this.init();
		this.start();
		this.setLocation(700,400);
		this.setVisible(true);
	}
	void init()
	{
		this.setLayout(null);
		
		this.add(lbTitle);
		lbTitle.setBounds(60, 40, 150, 30);
		lbTitle.setFont(font25);
		
		this.add(btnM3On);
		btnM3On.setBounds(50, 100, 70, 40);
		btnM3On.setFont(font15);
		
		this.add(btnM3Off);
		btnM3Off.setBounds(190, 100, 70, 40);
		btnM3Off.setFont(font15);
	}
	void start()
	{
		btnM3On.addActionListener(this);
		btnM3Off.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}
	
}
