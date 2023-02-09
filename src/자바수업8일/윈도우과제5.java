package 자바수업8일;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class 윈도우과제5
{

	public static void main(String[] args) 
	{
		WinTest5 wt5 = new WinTest5();
	}

}
class WinTest5 extends Frame implements ActionListener
{
	TextField tf1 = new TextField();
	TextField tf2 = new TextField();
	TextField tf3 = new TextField();
	TextField tf4 = new TextField();
	Label lb1 = new Label("이름:");
	Label lb2 = new Label("국어:");
	Label lb3 = new Label("영어:");
	Label lb4 = new Label("수학:");
	Label lb5 = new Label("이름없음", Label.CENTER);
	Label lb6 = new Label("점수 대기중...", Label.CENTER);
	Button bt1 = new Button("계산하기");
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	WinTest5()
	{
		super("성적");
		this.setSize(250, 350);
		this.init();
		this.start();
		this.setLocation(300, 300);
		this.setVisible(true);
	}
	void init()
	{
		this.setLayout(null);
		this.add(tf1);
		tf1.setBounds(110, 60, 90, 25);
		tf1.setFont(font15);
		
		this.add(tf2);
		tf2.setBounds(110, 90, 90, 25);
		tf2.setFont(font15);
		
		this.add(tf3);
		tf3.setBounds(110, 120, 90, 25);
		tf3.setFont(font15);
		
		this.add(tf4);
		tf4.setBounds(110, 150, 90, 25);
		tf4.setFont(font15);
		
		this.add(lb1);
		lb1.setBounds(50, 60, 90, 30);
		lb1.setFont(font15);
		
		this.add(lb2);
		lb2.setBounds(50, 90, 90, 30);
		lb2.setFont(font15);
		
		this.add(lb3);
		lb3.setBounds(50, 120, 90, 30);
		lb3.setFont(font15);
		
		this.add(lb4);
		lb4.setBounds(50, 150, 90, 30);
		lb4.setFont(font15);
		
		this.add(lb5);
		lb5.setBounds(90, 260, 80, 30);
		lb5.setFont(font15);
		
		this.add(lb6);
		lb6.setBounds(70, 290, 140, 30);
		lb6.setFont(font15);
		
		this.add(bt1);
		bt1.setBounds(75, 200, 100, 30);
		bt1.setFont(font15);
		
	}
	void start()
	{
		bt1.addActionListener(this);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent e) 
	{
			if(tf1.getText().equals(""))
			{
				return;
			}
			if(tf2.getText().equals(""))
			{
				return;
			}
			if(tf3.getText().equals(""))
			{
				return;
			}
			if(tf4.getText().equals(""))
			{
				return;
			}
			String Name = tf1.getText();
			lb5.setText(Name);
			int kor = Integer.parseInt(tf2.getText());
			int eng = Integer.parseInt(tf3.getText());\
			int mat = Integer.parseInt(tf4.getText());
			int tot = kor + eng + mat;
			int avg = tot/3;
			lb6.setText("총점 : " + tot + "평균 : " + avg);
		
	}
} 