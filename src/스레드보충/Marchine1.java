package 스레드보충;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Machine1 extends Frame implements ActionListener
{
	Label lbTitle = new Label("기계1 조작반");
	public static Button btnM1On = new Button("전원ON");
	public static Button btnM1Off = new Button("전원OFF");
	
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	
	Machine1()
	{
		super("기계 가동 제어");
		this.setSize(300,200);
		this.init();
		this.start();
		this.setLocation(700,200);
		this.setVisible(true);
	}
	void init()
	{
		this.setLayout(null);
		
		this.add(lbTitle);
		lbTitle.setBounds(60, 40, 150, 30);
		lbTitle.setFont(font25);
		
		this.add(btnM1On);
		btnM1On.setBounds(50, 100, 70, 40);
		btnM1On.setFont(font15);
		
		this.add(btnM1Off);
		btnM1Off.setBounds(190, 100, 70, 40);
		btnM1Off.setFont(font15);
	}
	void start()
	{
		btnM1On.addActionListener(this);
		btnM1Off.addActionListener(this);
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
