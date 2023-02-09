package 자바수업9일;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class 윈도우과제1_1
{
	public static void main(String[] args) 
	{
		WinTest9_1 wt = new WinTest9_1();
	}
}
class WinTest9_1 extends Frame implements ItemListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	Choice gc = new Choice();
	Label lbTitle = new Label("회원 정보 삭제");
	Label lbId = new Label("아이디:");
	Label lbName = new Label("이름:");
	Label lbHp = new Label("연락처:");
	Label lbGd = new Label("성별:");
	Label lbName2 = new Label("대기중...");
	Label lbHp2 = new Label("대기중...");
	Label lbGd2 = new Label("대기중...");
	TextField tfId = new TextField();
	Button btResult = new Button("삭제");
	Button btSearch = new Button("찾기");
	Button btCencle = new Button("취소");
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	WinTest9_1()
	{
		super("회원삭제");
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
		
		this.add(tfId);
		tfId.setBounds(120, 140, 100, 30);
		tfId.setFont(font15);
		
		this.add(lbName);
		lbName.setBounds(40, 180, 70, 30);
		lbName.setFont(font15);
		
		this.add(lbName2);
		lbName2.setBounds(120, 180, 100, 30);
		lbName2.setFont(font15);
		
		this.add(lbHp);
		lbHp.setBounds(40, 220, 70, 30);
		lbHp.setFont(font15);
		
		this.add(lbHp2);
		lbHp2.setBounds(120, 220, 100, 30);
		lbHp2.setFont(font15);
		
		this.add(lbGd);
		lbGd.setBounds(40, 260, 70, 30);
		lbGd.setFont(font15);
		
		this.add(lbGd2);
		lbGd2.setBounds(120, 260, 70, 30);
		lbGd2.setFont(font15);
		
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
		gc.addItemListener(this);
		btResult.addActionListener(this);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{
				System.exit(0);
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}
}