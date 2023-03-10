package 스레드보충;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Machine2 extends Frame implements ActionListener
{
	Label lbTitle = new Label("기계2 조작반");
	public static Button btnM2On = new Button("전원ON");
	public static Button btnM2Off = new Button("전원OFF");
	
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	
	Machine2()
	{
		super("기계 가동 제어");
		this.setSize(300,200);
		this.init();
		this.start();
		this.setLocation(1000,200);
		this.setVisible(true);
	}
	void init()
	{
		this.setLayout(null);
		
		this.add(lbTitle);
		lbTitle.setBounds(60, 40, 150, 30);
		lbTitle.setFont(font25);
		
		this.add(btnM2On);
		btnM2On.setBounds(50, 100, 70, 40);
		btnM2On.setFont(font15);
		
		this.add(btnM2Off);
		btnM2Off.setBounds(190, 100, 70, 40);
		btnM2Off.setFont(font15);
	}
	void start()
	{
		btnM2On.addActionListener(this);
		btnM2Off.addActionListener(this);
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
