package 자바수업11일;
import java.awt.*;
import javax.swing.*;

public class image 
{
	public static void main(String[] args) 
	{
		image1 img = new image1();
	}
}
class image1 extends JFrame
{
	image1()
	{
		ImageIcon iconCoca = new ImageIcon("image/코카콜라.png");
		Image imgCoca = iconCoca.getImage();
		Image changeCoca = imgCoca.getScaledInstance(50, 100, Image.SCALE_SMOOTH);
		ImageIcon changeCoca2 = new ImageIcon(changeCoca);
		JLabel labelCoca = new JLabel(changeCoca2);
		
		add(labelCoca);
		labelCoca.setBounds(50, 100, 50, 100);
		setTitle("코카콜라");
		setSize(500, 500);
		setVisible(true);
	}
}