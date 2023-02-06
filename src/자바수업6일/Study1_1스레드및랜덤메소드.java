package 자바수업6일;

public class Study1_1스레드및랜덤메소드 
{
	public static void main(String[] args) 
	{
		Lotto l = new Lotto();
		Thread th1 = new Thread(l);
		th1.start();
		
	}
}
class Lotto implements Runnable
{
	public void run()
	{
		for(int i = 0; i < 1000; i++)
		{
			try {
				System.out.println("번호를 추첨합니다!");
				Thread.sleep(500);
				System.out.println("3");
				Thread.sleep(500);
				System.out.println("2");
				Thread.sleep(500);
				System.out.println("1");
				Thread.sleep(500);
			} catch (InterruptedException e) {}
			
			int number = (int)(Math.random()*45 + 1);
			
			System.out.println("로또번호 = " + number);
		}
	}
}