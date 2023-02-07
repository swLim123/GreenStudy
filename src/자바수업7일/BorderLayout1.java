package 자바수업7일;
import java.awt.*;
public class BorderLayout1 
{
	private Frame fr;
	
	public BorderLayout1(String str)
	{
		initialize(str);
	}
	public static void main(String[] args)
	{
		BorderLayout1 lay = new BorderLayout1("연습용 창");
		lay.fr.setVisible(true);
	}
	private void initialize(String str) 
	{
		fr = new Frame(str);
		Button b1 = new Button("North");
		Button b2 = new Button("South");
		Button b3 = new Button("East");
		Button b4 = new Button("West");
		Button b5 = new Button("Center");
		fr.setLayout(new BorderLayout(0, 0));
		fr.add(b1, BorderLayout.NORTH);
		fr.add(b2, BorderLayout.SOUTH);
		fr.add(b3, BorderLayout.EAST);
		fr.add(b4, BorderLayout.WEST);
		fr.add(b5, BorderLayout.CENTER);
		fr.setSize(200, 200);
		//
	}
}
