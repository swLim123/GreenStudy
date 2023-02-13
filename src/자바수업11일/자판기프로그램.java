package 자바수업11일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.*
;
public class 자판기프로그램 
{
	public static void main(String[] args) 
	{
		VM vm = new VM();
	}
}
class VM extends Frame implements ActionListener
{
	boolean ordercheck1 = false;
	boolean ordercheck2 = false;
	boolean ordercheck3 = false;
	int myMoney = 0;
	int payMoney = 0;
	Label drink = new Label("음료 자판기");
	Label lbCoca = new Label("코카콜라");
	Label lbPepsi = new Label("펩시");
	Label lbSprite = new Label("스프라이트");
	Label lbOrder = new Label("현재주문상품:");
	Label lbPay = new Label("결제 금액");
	Label lbPayMoney = new Label(payMoney + "원");
	Label lbInputMoney = new Label("투입 금액");
	Label lbMyMoney = new Label("현재 잔액:");
	Label lbMoney = new Label(myMoney + "원");
	Button btCoca = new Button("2000원");
	Button btPepsi = new Button("2000원");
	Button btSprite = new Button("2000원");
	Button btCencle1 = new Button("선택취소");
	Button btCencle2 = new Button("선택취소");
	Button btCencle3 = new Button("선택취소");
	Button btIn1000 = new Button("1000원");
	Button btIn5000= new Button("5000원");
	Button btIn10000 = new Button("10000원");
	Button btPay = new Button("결제하기");
	Button btPayCencle = new Button("결제취소");
	Image coca;
	Image pepsi;
	Image sprite;
	Image wating1;
	Image wating2;
	Image wating3;
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	Font font12 = new Font("SansSerif", Font.BOLD, 12);
	
	VM()
	{
		super("음료 자판기");
		this.setSize(400, 500);
		this.setLocation(500, 300);
		this.setVisible(true);
		this.init();
		this.start();
	}
	public void paint(Graphics g)
	{
		g.drawImage(coca, 60, 80, 45, 85, this);
		g.drawImage(pepsi, 175, 70, 50, 100, this);
		g.drawImage(sprite, 285, 75, 55, 87, this);
		g.drawImage(wating1, 140, 250, 70, 90, this);
		g.drawImage(wating2, 220, 250, 70, 90, this);
		g.drawImage(wating3, 300, 250, 70, 90, this);
	}
	void start()
	{
		btCoca.addActionListener(this);
		btPepsi.addActionListener(this);
		btSprite.addActionListener(this);
		btCencle1.addActionListener(this);
		btCencle2.addActionListener(this);
		btCencle3.addActionListener(this);
		btIn1000.addActionListener(this);
		btIn5000.addActionListener(this);
		btIn10000.addActionListener(this);
		btPay.addActionListener(this);
		btPayCencle.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	void init()
	{
		this.setLayout(null);
		this.add(drink);
		drink.setBounds(125, 40, 220, 30);
		drink.setFont(font25);
		
		this.add(lbCoca);
		lbCoca.setBounds(50, 170, 80, 30);
		lbCoca.setFont(font15);
		
		this.add(lbPepsi);
		lbPepsi.setBounds(180, 170, 80, 30);
		lbPepsi.setFont(font15);
		
		this.add(lbSprite);
		lbSprite.setBounds(275, 170, 80, 30);
		lbSprite.setFont(font15);
		
		this.add(lbOrder);
		lbOrder.setBounds(30, 250, 100, 30);
		lbOrder.setFont(font15);
		
		this.add(lbPay);
		lbPay.setBounds(30, 280, 100, 30);
		lbPay.setFont(font15);
		
		this.add(lbPayMoney);
		lbPayMoney.setBounds(30, 310, 100, 30);
		lbPayMoney.setFont(font15);
		
		this.add(lbInputMoney);
		lbInputMoney.setBounds(30, 380, 100, 30);
		lbInputMoney.setFont(font15);
		
		this.add(lbMyMoney);
		lbMyMoney.setBounds(30, 455, 100, 30);
		lbMyMoney.setFont(font15);
		
		this.add(lbMoney);
		lbMoney.setBounds(130, 455, 100, 30);
		lbMoney.setFont(font15);
		
		this.add(btCoca);
		btCoca.setBounds(40, 200, 90, 30);
		btCoca.setFont(font15);
		
		this.add(btPepsi);
		btPepsi.setBounds(155, 200, 90, 30);
		btPepsi.setFont(font15);
		
		this.add(btSprite);
		btSprite.setBounds(270, 200, 90, 30);
		btSprite.setFont(font15);
		
		this.add(btCencle1);
		btCencle1.setBounds(140, 340, 70, 25);
		btCencle1.setFont(font12);
		
		this.add(btCencle2);
		btCencle2.setBounds(220, 340, 70, 25);
		btCencle2.setFont(font12);
		
		this.add(btCencle3);
		btCencle3.setBounds(300, 340, 70, 25);
		btCencle3.setFont(font12);
		
		this.add(btIn1000);
		btIn1000.setBounds(30, 420, 70, 25);
		btIn1000.setFont(font12);
		
		this.add(btIn5000);
		btIn5000.setBounds(110, 420, 70, 25);
		btIn5000.setFont(font12);
		
		this.add(btIn10000);
		btIn10000.setBounds(190, 420, 70, 25);
		btIn10000.setFont(font12);
		
		this.add(btPay);
		btPay.setBounds(280, 400, 90, 35);
		btPay.setFont(font15);
		
		this.add(btPayCencle);
		btPayCencle.setBounds(280, 445, 90, 35);
		btPayCencle.setFont(font15);
		
		coca = Toolkit.getDefaultToolkit().getImage("image/코카콜라.png");
		pepsi = Toolkit.getDefaultToolkit().getImage("image/펩시.png");
		sprite = Toolkit.getDefaultToolkit().getImage("image/스프라이트.png");
		wating1 = Toolkit.getDefaultToolkit().getImage("image/모래시계.png");
		wating2 = Toolkit.getDefaultToolkit().getImage("image/모래시계.png");
		wating3 = Toolkit.getDefaultToolkit().getImage("image/모래시계.png");
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btCoca)
		{
			if(ordercheck1 == false)
			{
				wating1 = coca;
				this.repaint();
				payMoney += 2000;
				lbPayMoney.setText(payMoney + "원");
				ordercheck1 = true;
			}
		}
		if(e.getSource() == btPepsi)
		{
			if(ordercheck2 == false)
			{
				wating2 = pepsi;
				this.repaint();
				payMoney += 2000;
				lbPayMoney.setText(payMoney + "원");
				ordercheck2 = true;
			}
		}
		if(e.getSource() == btSprite)
		{
			if(ordercheck3 == false)
			{
				wating3 = sprite;
				this.repaint();
				payMoney += 2000;
				lbPayMoney.setText(payMoney + "원");
				ordercheck3 = true;
			}
		}
		if(e.getSource() == btIn1000)
		{
			myMoney += 1000;
			lbMoney.setText(myMoney + "원");
		}
		if(e.getSource() == btIn5000)
		{
			myMoney += 5000;
			lbMoney.setText(myMoney + "원");
		}
		if(e.getSource() == btIn10000)
		{
			myMoney += 10000;
			lbMoney.setText(myMoney + "원");
		}
		if(e.getSource() == btPay)
		{
			dlgPay();
		}
		if(e.getSource() == btPayCencle)
		{
			dlgPayCencle();
			myMoney = 0;
			lbMoney.setText(myMoney + "원");
			payMoney = 0;
			lbPayMoney.setText(payMoney + "원");
		}
		if(e.getSource() == btCencle1)
		{
			if(payMoney > 0)
			{
				wating1 = Toolkit.getDefaultToolkit().getImage("image/모래시계.png");
				this.repaint();
				payMoney -= 2000;
				lbPayMoney.setText(payMoney + "원");
				ordercheck1 = false;
			}
			else if(payMoney == 0)
			{
				payMoney = 0;
			}
		}
		if(e.getSource() == btCencle2)
		{
			if(payMoney > 0)
			{
				wating2 = Toolkit.getDefaultToolkit().getImage("image/모래시계.png");
				this.repaint();
				payMoney -= 2000;
				lbPayMoney.setText(payMoney + "원");
				ordercheck2 = false;
			}
			else if(payMoney == 0)
			{
				payMoney = 0;
			}
		}
		if(e.getSource() == btCencle3)
		{
			if(payMoney > 0)
			{
				wating3 = Toolkit.getDefaultToolkit().getImage("image/모래시계.png");
				this.repaint();
				payMoney -= 2000;
				lbPayMoney.setText(payMoney + "원");
				ordercheck3 = false;
			}
			else if(payMoney == 0)
			{
				payMoney = 0;
			}
		}
	}
	void dlgPay()
	{
		Dialog dlg = new Dialog(this, "결제", true);
		Label lbPayCom = new Label("결제가 완료되었습니다!");
		Label lbPayfai1 = new Label("잔액이 부족합니다!");
		Label lbPayfai2 = new Label("상품을 선택해주세요!");
		Button bt = new Button("확인");		
		dlg.setLayout(null);
		
		if(myMoney >= payMoney && payMoney != 0)
		{
			dlg.add(lbPayCom);
			lbPayCom.setBounds(60, 50, 200, 30);
			lbPayCom.setFont(font15);
			myMoney = myMoney - payMoney;
			payMoney = 0;
			lbMoney.setText(myMoney + "원");
			lbPayMoney.setText(payMoney + "원");
			
			wating1 = Toolkit.getDefaultToolkit().getImage("image/모래시계.png");
			this.repaint();
			wating2 = Toolkit.getDefaultToolkit().getImage("image/모래시계.png");
			this.repaint();
			wating3 = Toolkit.getDefaultToolkit().getImage("image/모래시계.png");
			this.repaint();
			
			ordercheck1 = false;
			ordercheck2 = false;
			ordercheck3 = false;
		}
		else if(myMoney < payMoney)
		{
			dlg.add(lbPayfai1);
			lbPayfai1.setBounds(60, 50, 200, 30);
			lbPayfai1.setFont(font15);
		}
		dlg.add(bt);
		bt.setBounds(50, 90, 150, 30);
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
		dlg.setSize(250, 150);
		dlg.setVisible(true);
	}
	void dlgPayCencle()
	{
		Dialog dlg = new Dialog(this, "결제취소", true);
		Label lbPayCencle = new Label("결제를 취소 하겠습니까?");
		Label lbPayError = new Label("환불할 잔액이 없습니다.");
		Button bt = new Button("확인");		
		dlg.setLayout(null);
		
		if(myMoney > 0)
		{
			dlg.add(lbPayCencle);
			lbPayCencle.setBounds(40, 40, 200, 80);
			lbPayCencle.setFont(font15);
			wating1 = Toolkit.getDefaultToolkit().getImage("image/모래시계.png");
			this.repaint();
			wating2 = Toolkit.getDefaultToolkit().getImage("image/모래시계.png");
			this.repaint();
			wating3 = Toolkit.getDefaultToolkit().getImage("image/모래시계.png");
			this.repaint();
			ordercheck1 = false;
			ordercheck2 = false;
			ordercheck3 = false;
		}
		else if(myMoney == 0)
		{
			dlg.add(lbPayError);
			lbPayError.setBounds(40, 40, 200, 80);
			lbPayError.setFont(font15);
		}
	
		dlg.add(bt);
		bt.setBounds(50, 120, 150, 30);
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
		dlg.setSize(250, 200);
		dlg.setVisible(true);
	}
}