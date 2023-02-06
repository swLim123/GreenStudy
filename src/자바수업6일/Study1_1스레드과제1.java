package 자바수업6일;
import java.util.Scanner;
public class Study1_1스레드과제1 
{
	public static void main(String[] args) 
	{
		UpDown up = new UpDown();
		CDown cd = new CDown();
		Thread th1 = new Thread(up);
		Thread th2 = new Thread(cd);
		th1.start();
		th2.start();
	}
}
class UpDown implements Runnable
{
	int pCount = 0;
	int vic = 0;
	int fai = 0;
	Scanner sc = new Scanner(System.in);
	public void run()
	{
		while(true)
		{
			int select;
			System.out.println("1. 게임 시작");
			System.out.println("2. 결과");
			System.out.println("3. 종료");
			System.out.print("선택 : ");
			select = sc.nextInt();
			
			if(select == 1)
			{
				System.out.println("컴퓨터가 정답을 생성하였습니다!");
				int number = (int)(Math.random()*50 + 1);
				for(int i = 0; i < 4; i++)
				{
					
					int su;
					System.out.print("답 : ");
					su = sc.nextInt();
					if(number < su)
					{
						System.out.println("다운!");
					}
					else if(number > su)
					{
						System.out.println("업!");
					}
					else if(number == su)
					{
						System.out.println("정답입니다!");
						pCount++;
						vic++;
						break;
					}
					
					if(i == 0)
					{
						System.out.println("3회 남았습니다!");
					}
					else if(i == 1)
					{
						System.out.println("2회 남았습니다!");
					}
					else if(i == 2)
					{
						System.out.println("1회 남았습니다!");
					}
					else if(i == 3)
					{
						System.out.println("패배 하였습니다!");
						pCount++;
						fai++;
					}
				}
				
			}
			else if(select == 2)
			{
				System.out.println("총 시도 횟수 : " + pCount);
				System.out.println("승리 횟수 : " + vic);
				System.out.println("패배 횟수 : " + fai);
			}
			else if(select == 3)
			{
				System.out.println("< 게임을 종료합니다 >");
				break;
			}
		}
	}
}
class CDown implements Runnable
{
	static boolean check = true;
	public void run()
	{
		while(true)
		{
			try
			{
				System.out.println("3");
				Thread.sleep(1000);
				System.out.println("2");
				Thread.sleep(1000);
				System.out.println("1");
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}
