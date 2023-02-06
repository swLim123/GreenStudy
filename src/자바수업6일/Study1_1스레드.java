package 자바수업6일;

public class Study1_1스레드 
{
	public static void main(String[] args) 
	{
		A1 a1 = new A1();
		B1 b1 = new B1();
		a1.start();
		b1.start();
	}
}
class A1 extends Thread
{
	public void run()
	{
		for(int i = 0; i < 100; i++)
		{
			try {
				sleep(1000);
			} catch (InterruptedException e) {}
			System.out.println("월요일이군..." + i);
		}
	}
}
class B1 extends Thread
{
	public void run()
	{	
		for(int i = 0; i < 100; i++)
		{
			try {
			sleep(1000);
			} catch (InterruptedException e) {}
			System.out.println("자바수업GO = " + i);
		}
	}
}
