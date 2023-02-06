package 자바수업6일;

public class Study1_1스레드2 {

	public static void main(String[] args) 
	{
		A2 a2 = new A2();
		B2 b2 = new B2();
		Thread th1 = new Thread(a2);
		Thread th2 = new Thread(b2);
		th1.start();
		th2.start();
	}

}
class A2 implements Runnable
{
	public void run()
	{
		for(int i = 0; i < 100; i++)
		{
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {}
			System.out.println("월요일이군..." + i);
		}
	}
}
class B2 implements Runnable
{
	public void run()
	{	
		for(int i = 0; i < 100; i++)
		{
			try {
			Thread.sleep(200);
			} catch (InterruptedException e) {}
			System.out.println("자바수업GO = " + i);
		}
	}
}
