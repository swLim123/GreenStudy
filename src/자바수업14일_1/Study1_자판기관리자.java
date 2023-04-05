package 자바수업14일_1;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Study1_자판기관리자 
{
	public static void main(String[] args) 
	{
		Japangi_1 jp = new Japangi_1();
	}
}
class Japangi_1 extends Frame implements ItemListener, ActionListener
{
	//디비관련 클래스변수들...
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/test_db?useUnicode=true&characterEncoding=utf8";	
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		//////////////////////////////////////////////////////////
	Label lbTitle = new Label("관리자 화면");
	Label goodsMng = new Label("상품관리");
	Label goodsName_1 = new Label("이름:");
	TextField goodsName_2 = new TextField();
	Label goodsPrice_1 = new Label("가격:");
	TextField tfgoodsPrice = new TextField();
	Label goodsInputMng = new Label("입고관리");
	Label goodsName2_1 = new Label("상품명:");
	Label goodsName2_2 = new Label(" -  -  - ");
	Label goodsInv_1 = new Label("현재재고:");
	Label goodsInv_2 = new Label(" -  -  - ");
	Label goodsCnt_1 = new Label("수량:");
	TextField goodsCnt_2 = new TextField();
	Button btApply1 = new Button("적용");
	Button btApply2 = new Button("적용");
	Button btApply3 = new Button("적용");
	Button btSales = new Button("매출현황");
	Button btAddGoods = new Button("상품추가");
	Choice chgoods1 = new Choice();
	Choice chgoods2 = new Choice();
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	
	//디비에서 데이타를 읽어들일 공간...
		int MAX = 100;
		String goodsName[] = new String[MAX];
		String goodsPrice[] = new String[MAX];
		String goodsCount[] = new String[MAX];
		String sellcount[] = new String[MAX];
		String paycount[] = new String[MAX];
	Japangi_1()
	{
		super("상품관리자");
		this.setSize(400, 500);
		this.init();
		dbCon();
		dbDataLoad();
		this.start();
		this.setLocation(400, 200);
		this.setVisible(true);
		
	}
	void dbCon()
	{
		////////////////////////////////////////
		///데이타베이스접속..	
		try {	Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {System.exit(0);}	

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		////////////////////////////////////////////
	}
	void dbDataLoad() 
	{
		String query = "select * from japangi";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			int i=0;
			while (rs.next()) 
			{
			//결과값읽어오는곳 여기서 화면에 뿌려주면됨.
				 goodsName[i] = rs.getString("name");
				 goodsPrice[i] = rs.getString("price");
				 goodsCount[i] = rs.getString("count");
				 sellcount[i] = rs.getString("sellcount");
				 paycount[i] = rs.getString("paycount");
				 i++;
				 
			}
			
				} catch (SQLException ee) {
				System.err.println("error = " + ee.toString());
				}
	}
	void init()
	{
		this.setLayout(null);
		this.add(lbTitle);							
		lbTitle.setBounds(130, 30, 200, 50);
		lbTitle.setFont(font25);
		
		this.add(goodsMng);
		goodsMng.setBounds(50, 80, 100, 30);
		goodsMng.setFont(font15);
		
		this.add(goodsName_1);
		goodsName_1.setBounds(150, 110, 40, 30);
		goodsName_1.setFont(font15);
		
		this.add(goodsName_2);
		goodsName_2.setBounds(200, 110, 90, 30);
		goodsName_2.setFont(font15);
		
		this.add(goodsPrice_1);
		goodsPrice_1.setBounds(150, 140, 40, 30);
		goodsPrice_1.setFont(font15);
		
		this.add(tfgoodsPrice);
		tfgoodsPrice.setBounds(200, 140, 90, 30);
		tfgoodsPrice.setFont(font15);
		
		this.add(goodsInputMng);
		goodsInputMng.setBounds(50, 230, 100, 30);
		goodsInputMng.setFont(font15);
		
		this.add(goodsName2_1);
		goodsName2_1.setBounds(150, 260, 60, 30);
		goodsName2_1.setFont(font15);
		
		this.add(goodsName2_2);
		goodsName2_2.setBounds(210, 260, 100, 30);
		goodsName2_2.setFont(font15);
		
		this.add(goodsInv_1);
		goodsInv_1.setBounds(133, 290, 80, 30);
		goodsInv_1.setFont(font15);
		
		this.add(goodsInv_2);
		goodsInv_2.setBounds(210, 290, 80, 30);
		goodsInv_2.setFont(font15);
		
		this.add(goodsCnt_1);
		goodsCnt_1.setBounds(150, 320, 40, 30);
		goodsCnt_1.setFont(font15);
		
		this.add(goodsCnt_2);
		goodsCnt_2.setBounds(200, 320, 90, 30);
		goodsCnt_2.setFont(font15);
		
		this.add(btApply1);
		btApply1.setBounds(300, 110, 50, 25);
		btApply1.setFont(font15);
		
		this.add(btApply2);
		btApply2.setBounds(300, 140, 50, 25);
		btApply2.setFont(font15);
		
		this.add(btApply3);
		btApply3.setBounds(300, 320, 50, 25);
		btApply3.setFont(font15);
		
		this.add(btSales);
		btSales.setBounds(160, 380, 80, 35);
		btSales.setFont(font15);
		
		this.add(btAddGoods);
		btAddGoods.setBounds(160, 425, 80, 35);
		btAddGoods.setFont(font15);
		
		this.add(chgoods1);
		chgoods1.setBounds(50, 115, 70, 30);
		chgoods1.add("상품1");
		chgoods1.add("상품2");
		chgoods1.add("상품3");
		
		this.add(chgoods2);
		chgoods2.setBounds(50, 265, 70, 30);
		chgoods2.add("상품1");
		chgoods2.add("상품2");
		chgoods2.add("상품3");
	}
	public void start() 
	{
		btAddGoods.addActionListener(this);
		chgoods1.addItemListener(this);
		chgoods2.addItemListener(this);
		btApply1.addActionListener(this);
		btApply2.addActionListener(this);
		btApply3.addActionListener(this);
		btSales.addActionListener(this);
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
		if (e.getSource() == btApply1) 
		{
			if(chgoods1.getSelectedItem().equals("상품1"))
			{
				goodsName[0] = goodsName_2.getText();
				dlgMsg("상품명이 변경 되었습니다.");
				goodsNameUpdate(1,goodsName[0]);
			}
			else if(chgoods1.getSelectedItem().equals("상품2"))
			{
				goodsName[2] = goodsName_2.getText();
				dlgMsg("상품명이 변경 되었습니다.");
				goodsNameUpdate(2,goodsName[1]);
			}
			else if(chgoods1.getSelectedItem().equals("상품3"))
			{
				goodsName[3] = goodsName_2.getText();
				dlgMsg("상품명이 변경 되었습니다.");
				goodsNameUpdate(3,goodsName[2]);
			}
		}
		if (e.getSource() == btApply2) 
		{
			if(chgoods1.getSelectedItem().equals("상품1"))
			{
				goodsPrice[0] = tfgoodsPrice.getText();
				dlgMsg("상품가격이 변경 되었습니다.");
				goodsPriceUpdate(1,goodsPrice[0]);
			}
			else if(chgoods1.getSelectedItem().equals("상품2"))
			{
				goodsPrice[1] = tfgoodsPrice.getText();
				dlgMsg("상품가격이 변경 되었습니다.");
				goodsPriceUpdate(2,goodsPrice[1]);
			}
			else if(chgoods1.getSelectedItem().equals("상품3"))
			{
				goodsPrice[2] = tfgoodsPrice.getText();
				dlgMsg("상품가격이 변경 되었습니다.");
				goodsPriceUpdate(3,goodsPrice[2]);
			}
		}
		if (e.getSource() == btApply3) 
		{
			if(chgoods1.getSelectedItem().equals("상품1"))
			{
				goodsCount[0] = goodsCnt_2.getText();
				dlgMsg("상품수량이 변경 되었습니다.");
				goodsCountUpdate(1,goodsCount[0]);
			}
			else if(chgoods1.getSelectedItem().equals("상품2"))
			{
				goodsCount[2] = goodsCnt_2.getText();
				dlgMsg("상품수량이 변경 되었습니다.");
				goodsCountUpdate(2,goodsCount[1]);
			}
			else if(chgoods1.getSelectedItem().equals("상품3"))
			{
				goodsCount[3] = goodsCnt_2.getText();
				dlgMsg("상품수량이 변경 되었습니다.");
				goodsCountUpdate(3,goodsCount[2]);
			}
		}
		if (e.getSource() == btSales) 
		{
			dlgGoods();
		}
		if (e.getSource() == btAddGoods)
		{
			dlgAddGoods();
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		if (e.getSource() == chgoods1) 
		{
			if(chgoods1.getSelectedItem().equals("상품1"))
			{
				goodsName_2.setText(goodsName[0]);
				tfgoodsPrice.setText(goodsPrice[0]);
				return;
			}
			else if(chgoods1.getSelectedItem().equals("상품2"))
			{
				goodsName_2.setText(goodsName[1]);
				tfgoodsPrice.setText(goodsPrice[1]);
				return;
			}
			else if(chgoods1.getSelectedItem().equals("상품3"))
			{
				goodsName_2.setText(goodsName[2]);
				tfgoodsPrice.setText(goodsPrice[2]);
				return;
			}
		}
		if (e.getSource() == chgoods2) 
		{
			if(chgoods2.getSelectedItem().equals("상품1"))
			{
				goodsName2_2.setText(goodsName[0]); //아래이름
				goodsInv_2.setText(goodsCount[0]);   //현재재고 
				return;//수량 텍스트필드
			}
			else if(chgoods2.getSelectedItem().equals("상품2"))
			{
				goodsName2_2.setText(goodsName[1]);
				goodsInv_2.setText(goodsCount[1]);
				return;
			}
			else if(chgoods2.getSelectedItem().equals("상품3"))
			{
				goodsName2_2.setText(goodsName[2]);
				goodsInv_2.setText(goodsCount[2]);
				return;
			}
		}
	}
	void dlgGoods()
	{
		Dialog dlg = new Dialog(this, "자판기알림!", true);
		Label lbTitle = new Label("매출현황 다이얼로그");
		Label lbGoods1 = new Label("상품1: " + goodsName[0] + " / 현재 " + goodsCount[0] + 
									"개 /" + " 누적판매량" + sellcount[0] + "개 /" + " 현재 단가 " + 
									goodsPrice[0] + "원 / " + "총 매출:" +  paycount[0]);
		Label lbGoods2 = new Label("상품2: " + goodsName[1] + " / 현재 " + goodsCount[1] + 
									"개 /" + " 누적판매량" + sellcount[1] + "개 /" + "현재 단가 " + 
									goodsPrice[1] + "원 / " + "총 매출:" +  paycount[1]);
		Label lbGoods3 = new Label("상품3: " + goodsName[2] + " / 현재 " + goodsCount[2] + 
									"개 /" + " 누적판매량" + sellcount[2] + "개 /" + "현재 단가 " + 
									goodsPrice[2] + "원 / " + "총 매출:" +  paycount[2]);
		Button bt = new Button("확인");
		
		dlg.setLayout(null);		
		dlg.add(lbTitle);
		lbTitle.setBounds(230, 50, 250, 30);
		lbTitle.setFont(font25);
		
		dlg.add(lbGoods1);
		lbGoods1.setBounds(80, 110, 600, 30);
		lbGoods1.setFont(font15);
		
		dlg.add(lbGoods2);
		lbGoods2.setBounds(80, 140, 600, 30);
		lbGoods2.setFont(font15);
		
		dlg.add(lbGoods3);
		lbGoods3.setBounds(80, 170, 600, 30);
		lbGoods3.setFont(font15);
		
		dlg.add(bt);		 
		bt.setBounds(280, 230, 120, 30);	
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
		dlg.setLocation(300,400);
		dlg.setSize(700, 300);
		dlg.setVisible(true);
	}
	void dlgMsg(String msg)
	{
		Dialog dlg = new Dialog(this, "자판기알림!", true);
		Label lbContent = new Label(msg);
		Button bt = new Button("확인");		
		dlg.setLayout(null);		
		dlg.add(lbContent);	 lbContent.setFont(font15);
		dlg.add(bt);		 bt.setFont(font15);
		lbContent.setBounds(50, 50, 200, 30);
		bt.setBounds(80, 120, 120, 30);		
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
		dlg.setSize(300, 200);
		dlg.setVisible(true);
	}
	void dlgAddGoods()
	{
		Dialog dlg = new Dialog(this, "자판기알림!", true);
		Label lbTitle = new Label("상품 등록하기");
		Label lbGoodsName = new Label("삼품명:");
		Label lbGoodsPrice = new Label();
		Label lbGoodsCnt = new Label();
		TextField tfGoodsName = new TextField();
		TextField tfGoodsPrice = new TextField();
		TextField tfGoodsCnt = new TextField();
		Button bt = new Button("상품등록");
		
		dlg.setLayout(null);		
		dlg.add(lbTitle);
		lbTitle.setBounds(80, 50, 250, 30);
		lbTitle.setFont(font25);
		
		dlg.add(lbGoodsName);
		lbGoodsName.setBounds(50, 100, 60, 30);
		lbGoodsName.setFont(font15);
		
		dlg.add(lbGoodsPrice);
		lbGoodsPrice.setBounds(50, 130, 60, 30);
		lbGoodsPrice.setFont(font15);
		
		dlg.add(lbGoodsCnt);
		lbGoodsCnt.setBounds(50, 160, 60, 30);
		lbGoodsCnt.setFont(font15);
		
		dlg.add(tfGoodsName);
		tfGoodsName.setBounds(130, 100, 120, 30);
		tfGoodsName.setFont(font15);
		
		dlg.add(tfGoodsPrice);
		tfGoodsPrice.setBounds(130, 130, 120, 30);
		tfGoodsPrice.setFont(font15);
		
		dlg.add(tfGoodsCnt);
		tfGoodsCnt.setBounds(130, 160, 120, 30);
		tfGoodsCnt.setFont(font15);
		
		dlg.add(bt);
		bt.setBounds(90, 200, 120, 30);
		bt.setFont(font15);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlgMsg("상품이 등록되었습니다!");
				dlg.setVisible(false);
			}
		});
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});		
		dlg.setLocation(300,400);
		dlg.setSize(300, 250);
		dlg.setVisible(true);
	}
	void goodsNameUpdate(int idx, String name)
	{
		String query = "update japangi set name = ? where idx = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setInt(2, idx);
			pstmt.executeUpdate();
			pstmt.close();			
		} catch (SQLException ee) {
			System.err.println("자판기 정보변경 실패!!");
			System.err.println("에러내용:"+ee.getMessage());
		
		}
		
	}
	void goodsPriceUpdate(int idx, String Price)
	{
		String query = "update japangi set price = ? where idx = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, Price);
			pstmt.setInt(2, idx);
			pstmt.executeUpdate();
			pstmt.close();			
		} catch (SQLException ee) {
			System.err.println("자판기 정보변경 실패!!");
			System.err.println("에러내용:"+ee.getMessage());
		
		}
		
	}
	void goodsCountUpdate(int idx, String count)
	{
		String query = "update japangi set name = ? where idx = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, count);
			pstmt.setInt(2, idx);
			pstmt.executeUpdate();
			pstmt.close();			
		} catch (SQLException ee) {
			System.err.println("자판기 정보변경 실패!!");
			System.err.println("에러내용:"+ee.getMessage());
		
		}
		
	}
}