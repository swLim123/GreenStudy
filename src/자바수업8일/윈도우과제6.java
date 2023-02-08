package 자바수업8일;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class 윈도우과제6
{

	public static void main(String[] args) 
	{
		WinTest6 wt6 = new WinTest6();
	}

}
class WinTest6 extends Frame implements ActionListener
{
	TextArea ta = new TextArea();
	TextField tfName = new TextField();
	TextField tfPh = new TextField();
	Label lbTitle = new Label("친구목록 리스트 만들기");
	Label lbName = new Label("이름:");
	Label lbPh = new Label("연락처:");
	Label lbList = new Label("친구 리스트");
	Button bt = new Button("추가하기");
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	int count = 0;//친구 수
	String result = "";//친구리스트 결과변수

	WinTest6()
	{
		super("친구");
		this.setSize(300, 350);
		this.init();
		this.start();
		this.setLocation(300, 300);
		this.setVisible(true);
	}
	void List()
	{
		this.setSize(200, 150);
	}
	void init()
	{
		this.setLayout(null);
		this.add(lbTitle);
		lbTitle.setBounds(70, 60, 180, 25);
		lbTitle.setFont(font15);
		
		this.add(tfName);
		tfName.setBounds(110, 100, 90, 25);
		tfName.setFont(font15);
		
		this.add(tfPh);
		tfPh.setBounds(110, 130, 90, 25);
		tfPh.setFont(font15);
		
		this.add(lbName);
		lbName.setBounds(30, 100, 90, 30);
		lbName.setFont(font15);
		
		this.add(lbPh);
		lbPh.setBounds(30, 130, 90, 30);
		lbPh.setFont(font15);
		
		this.add(lbList);
		lbList.setBounds(30, 180, 90, 30);
		lbList.setFont(font15);
		
		this.add(bt);
		bt.setBounds(210, 105, 70, 40);
		bt.setFont(font15);
		
		this.add(ta);
		ta.setBounds(50, 230, 200, 100);
	}
	void start()
	{
		bt.addActionListener(this);
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
		if(tfName.getText().equals(""))
		{
			return;
		}
		if(tfPh.getText().equals(""))
		{
			return;
		}
		String name = tfName.getText();
		String ph = tfPh.getText();
		
		count++;
		result += count + "/" + name + "/" + ph + "\n";
		
		ta.setText(result);
		
		tfName.setText("");
		tfPh.setText("");
	}
} 