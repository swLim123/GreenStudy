package 자바수업8일;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class 윈도우과제4
{

	public static void main(String[] args) 
	{
		WinTest4 wt3 = new WinTest4();
	}

}
class WinTest4 extends Frame implements ActionListener
{
	TextField tflb1 = new TextField();
	Label lb2 = new Label("값 대기중...");
	Button bt1 = new Button("버튼 1");
	Button bt2 = new Button("버튼 2");
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	WinTest4()
	{
		super("버튼1,2");
		this.setSize(350, 300);
		this.init();
		this.start();
		this.setLocation(300, 300);
		this.setVisible(true);
	}
	void init()
	{
		this.setLayout(null);
		this.add(tflb1);
		tflb1.setBounds(200, 100, 90, 30);
		tflb1.setFont(font15);
		
		this.add(lb2);
		lb2.setBounds(200, 200, 90, 30);
		lb2.setFont(font15);
		
		this.add(bt1);
		bt1.setBounds(50, 100, 100, 30);
		bt1.setFont(font15);
		
		this.add(bt2);
		bt2.setBounds(50, 200, 100, 30);
		bt2.setFont(font15);
		
	}
	void start()
	{
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==bt1)
		{

		}
		else if(e.getSource()==bt2)
		{
			lb2.setText("대전");
			System.out.println("Button2 clicked");
		}
	}
} 