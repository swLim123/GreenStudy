package 자바수업9일;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class 윈도우과제1
{
	public static void main(String[] args) 
	{
		WinTest9 wt = new WinTest9();
	}
}
class WinTest9 extends Frame implements ItemListener, ActionListener
{
	String id = "admin";
	String pw = "1004";
	String name = "홍길동";
	String hp = "01011112222";
	String gd = "남성";
	private static final long serialVersionUID = 1L;
	Label lbTitle = new Label("회원 정보 수정");
	Label lbId = new Label("아이디:");
	Label lbPw = new Label("패스워드:");
	Label lbName = new Label("이름:");
	Label lbHp = new Label("연락처:");
	Label lbGd = new Label("성별:");
	TextField tflbId = new TextField();
	TextField tflbPw = new TextField();
	TextField tfName = new TextField();
	TextField tfHp = new TextField();
	TextField tfGd = new TextField();
	Button btResult = new Button("수정완료");
	Button btSearch = new Button("찾기");
	Button btCencle = new Button("취소");
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	WinTest9()
	{
		super("회원수정");
		this.setSize(350, 450);
		this.init();
		this.start();
		this.setLocation(400, 200);
		this.setVisible(true);
	}
	void init()
	{
		this.setLayout(null);
		this.add(lbTitle);
		lbTitle.setBounds(100, 40, 270, 30);
		lbTitle.setFont(font25);
		
		this.add(lbId);
		lbId.setBounds(40, 140, 70, 30);
		lbId.setFont(font15);
		
		this.add(tflbId);
		tflbId.setBounds(120, 140, 100, 30);
		tflbId.setFont(font15);
		
		this.add(lbPw);
		lbPw.setBounds(40, 180, 70, 30);
		lbPw.setFont(font15);
		
		this.add(tflbPw);
		tflbPw.setBounds(120, 180, 100, 30);
		tflbPw.setFont(font15);
		
		this.add(lbName);
		lbName.setBounds(40, 220, 70, 30);
		lbName.setFont(font15);
		
		this.add(tfName);
		tfName.setBounds(120, 220, 100, 30);
		tfName.setFont(font15);
		
		this.add(lbHp);
		lbHp.setBounds(40, 260, 70, 30);
		lbHp.setFont(font15);
		
		this.add(tfHp);
		tfHp.setBounds(120, 260, 100, 30);
		tfHp.setFont(font15);
		
		this.add(lbGd);
		lbGd.setBounds(40, 300, 70, 30);
		lbGd.setFont(font15);
		
		this.add(tfGd);
		tfGd.setBounds(120, 300, 100, 30);
		tfGd.setFont(font15);
		
		this.add(btResult);
		btResult.setBounds(110, 340, 120, 30);
		btResult.setFont(font15);
		
		this.add(btCencle);
		btCencle.setBounds(110, 380, 120, 30);
		btCencle.setFont(font15);
		
		this.add(btSearch);
		btSearch.setBounds(235, 140, 100, 30);
		btSearch.setFont(font15);
	}
	public void start() 
	{
		btSearch.addActionListener(this);
		btCencle.addActionListener(this);
		btResult.addActionListener(this);
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
		if(e.getSource() == btCencle)
		{
			tflbId.setText("");
			tflbPw.setText("");
			tfName.setText("");
			tfHp.setText("");
			tfGd.setText("");
		}
		
		if(e.getSource() == btSearch)
		{
			
			if(tflbId.getText().equals(id))
			{
				tflbId.setText(id);
				tflbPw.setText(pw);
				tfName.setText(name);
				tfHp.setText(hp);
				tfGd.setText(gd);
			}
		}
		if(e.getSource() == btResult)
		{
			id = tflbId.getText();
			pw = tflbPw.getText();
			name = tfName.getText();
			hp = tfHp.getText();
			gd = tfGd.getText();
		}
	}
}