package 자바수업15일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;

public class 계산기윈도우 
{
	public static void main(String[] args) 
	{
		CalcWin cw = new CalcWin();
	}
}
class CalcWin extends Frame implements ActionListener
{
	int iSu1 = 0;
	int iSu2 = 0;
	String yon = ""; // 연산자 변수
	String sSu1 = "";
	String sSu2 = "";
	boolean suCheck = true;
	TextField inputSpace = new TextField();
	Label lbTitle = new Label("계산기");
	Button bt1 = new Button("1");
	Button bt2 = new Button("2");
	Button bt3 = new Button("3");
	Button bt4 = new Button("4");
	Button bt5 = new Button("5");
	Button bt6 = new Button("6");
	Button bt7 = new Button("7");
	Button bt8 = new Button("8");
	Button bt9 = new Button("9");
	Button bt0 = new Button("0");
	Button btC = new Button("C");
	Button btEqual = new Button("=");
	Button btPlus = new Button("+");
	Button btMinus = new Button("-");
	Button btMul = new Button("*");
	Button btDiv = new Button("/");
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	CalcWin()
	{
		super("계산기");
		inputSpace.setEditable(false);
		this.setSize(350, 450);
		this.init();
		this.start();
		this.setLocation(500, 150);
		this.setVisible(true);
	}
	void init()
	{
		this.setLayout(null);
		this.add(lbTitle);
		lbTitle.setBounds(130, 50, 100, 30);
		lbTitle.setFont(font25);
		
		this.add(bt1);
		bt1.setBounds(50, 100, 50, 50);
		bt1.setFont(font15);

		this.add(bt2);
		bt2.setBounds(120, 100, 50, 50);
		bt2.setFont(font15);
		
		this.add(bt3);
		bt3.setBounds(185, 100, 50, 50);
		bt3.setFont(font15);
		
		this.add(btPlus);
		btPlus.setBounds(255, 100, 50, 50);
		btPlus.setFont(font15);
		
		this.add(bt4);
		bt4.setBounds(50, 170, 50, 50);
		bt4.setFont(font15);
		
		this.add(bt5);
		bt5.setBounds(120, 170, 50, 50);
		bt5.setFont(font15);
		
		this.add(bt6);
		bt6.setBounds(185, 170, 50, 50);
		bt6.setFont(font15);
		
		this.add(btMinus);
		btMinus.setBounds(255, 170, 50, 50);
		btMinus.setFont(font15);
		
		this.add(bt7);
		bt7.setBounds(50, 240, 50, 50);
		bt7.setFont(font15);
		
		this.add(bt8);
		bt8.setBounds(120, 240, 50, 50);
		bt8.setFont(font15);
		
		this.add(bt9);
		bt9.setBounds(185, 240, 50, 50);
		bt9.setFont(font15);
		
		this.add(btMul);
		btMul.setBounds(255, 240, 50, 50);
		btMul.setFont(font15);
		
		this.add(btC);
		btC.setBounds(50, 310, 50, 50);
		btC.setFont(font15);
		
		this.add(bt0);
		bt0.setBounds(120, 310, 50, 50);
		bt0.setFont(font15);
		
		this.add(btEqual);
		btEqual.setBounds(185, 310, 50, 50);
		btEqual.setFont(font15);
		
		this.add(btDiv);
		btDiv.setBounds(255, 310, 50, 50);
		btDiv.setFont(font15);
		
		this.add(inputSpace);
		inputSpace.setBounds(50, 380, 255, 30);
		inputSpace.setFont(font15);
	}
	void start()
	{
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);
		bt6.addActionListener(this);
		bt7.addActionListener(this);
		bt8.addActionListener(this);
		bt9.addActionListener(this);
		bt0.addActionListener(this);
		btC.addActionListener(this);
		btEqual.addActionListener(this);
		btPlus.addActionListener(this);
		btMinus.addActionListener(this);
		btMul.addActionListener(this);
		btDiv.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btC)
		{
			suCheck = true;
			sSu1 = "";
			sSu2 = "";
			inputSpace.setText("");
		}
		else if(e.getSource() == btEqual)
		{
			try
			{
				String result;
				iSu2 = Integer.parseInt(sSu2);
				if(yon == "+")
				{
					result = Integer.toString(iSu1 + iSu2);
					inputSpace.setText(result);
				}
				else if(yon == "-")
				{
					result = Integer.toString(iSu1 - iSu2);
					inputSpace.setText(result);
				}
				else if(yon == "*")
				{
					result = Integer.toString(iSu1 * iSu2);
					inputSpace.setText(result);
				}
				else if(yon == "/")
				{
					
					try
					{
						result = Integer.toString(iSu1 / iSu2);
						inputSpace.setText(result);
					}
					catch(Exception e1)
					{
						inputSpace.setText("Do not divition 0");
					}
				}
				sSu1 = "";
				sSu2 = "";
				suCheck = true;
			}
			catch(Exception e2)
			{
				System.out.println("식을 정확히 입력해주세요!");
			}
		}
		else if(e.getSource() == btPlus)
		{
			if(suCheck == true)
			{
				iSu1 = Integer.parseInt(sSu1);
				yon = "+";
				suCheck = false;
				inputSpace.setText("");
			}
			else if(suCheck == false)
			{
				System.out.println("연산자 중복입력 불가!");
			}
		}
		else if(e.getSource() == btMinus)
		{
			if(suCheck == true)
			{	
				try
				{
					iSu1 = Integer.parseInt(sSu1);
					yon = "-";
					suCheck = false;
					inputSpace.setText("");
				}
				catch(Exception e3)
				{
					sSu1 = "-" + sSu1;
				}
			}
			else if(suCheck == false)
			{
				System.out.println("연산자 중복입력 불가!");
			}
		}
		else if(e.getSource() == btMul)
		{
			if(suCheck == true)
			{
				iSu1 = Integer.parseInt(sSu1);
				yon = "*";
				suCheck = false;
				inputSpace.setText("");
			}
			else if(suCheck == false)
			{
				System.out.println("연산자 중복입력 불가!");
			}
		}
		else if(e.getSource() == btDiv)
		{
			if(suCheck == true)
			{
				iSu1 = Integer.parseInt(sSu1);
				yon = "/";
				suCheck = false;
				inputSpace.setText("");
			}
			else if(suCheck == false)
			{
				System.out.println("연산자 중복입력 불가!");
			}
		}
		if(e.getSource() == bt1)
		{
			if(suCheck == true)
			{
				sSu1 += 1;
				inputSpace.setText(sSu1);
			}
			else if(suCheck == false)
			{
				sSu2 += 1;
				inputSpace.setText(sSu2);
			}
		}
		if(e.getSource() == bt2)
		{
			if(suCheck == true)
			{
				sSu1 += 2;
				inputSpace.setText(sSu1);
			}
			else if(suCheck == false)
			{
				sSu2 += 2;
				inputSpace.setText(sSu2);
			}
		}
		if(e.getSource() == bt3)
		{
			if(suCheck == true)
			{
				sSu1 += 3;
				inputSpace.setText(sSu1);
			}
			else if(suCheck == false)
			{
				sSu2 += 3;
				inputSpace.setText(sSu2);
			}
		}
		if(e.getSource() == bt4)
		{
			if(suCheck == true)
			{
				sSu1 += 4;
				inputSpace.setText(sSu1);
			}
			else if(suCheck == false)
			{
				sSu2 += 4;
				inputSpace.setText(sSu2);
			}
		}
		if(e.getSource() == bt5)
		{
			if(suCheck == true)
			{
				sSu1 += 5;
				inputSpace.setText(sSu1);
			}
			else if(suCheck == false)
			{
				sSu2 += 5;
				inputSpace.setText(sSu2);
			}
		}
		if(e.getSource() == bt6)
		{
			if(suCheck == true)
			{
				sSu1 += 6;
				inputSpace.setText(sSu1);
			}
			else if(suCheck == false)
			{
				sSu2 += 6;
				inputSpace.setText(sSu2);
			}
		}
		if(e.getSource() == bt7)
		{
			if(suCheck == true)
			{
				sSu1 += 7;
				inputSpace.setText(sSu1);
			}
			else if(suCheck == false)
			{
				sSu2 += 7;
				inputSpace.setText(sSu2);
			}
		}
		if(e.getSource() == bt8)
		{
			if(suCheck == true)
			{
				sSu1 += 8;
				inputSpace.setText(sSu1);
			}
			else if(suCheck == false)
			{
				sSu2 += 8;
				inputSpace.setText(sSu2);
			}
		}
		if(e.getSource() == bt9)
		{
			if(suCheck == true)
			{
				sSu1 += 9;
				inputSpace.setText(sSu1);
			}
			else if(suCheck == false)
			{
				sSu2 += 9;
				inputSpace.setText(sSu2);
			}
		}
		if(e.getSource() == bt0)
		{
			if(suCheck == true)
			{
				sSu1 += 0;
				inputSpace.setText(sSu1);
			}
			else if(suCheck == false)
			{
				sSu2 += 0;
				inputSpace.setText(sSu2);
			}
		}
	}

}
