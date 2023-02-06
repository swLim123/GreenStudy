package 자바수업6일;
import java.util.Scanner;
public class Study1_1스레드가위바위보 
{
	public static void main(String[] args) 
	{
		Rps rps = new Rps();
	}
}
class Rps
{
	int sel;
	int mySel; // 1. 가위 2. 바위 3. 보
	int comSel;
	int playCount = 0;
	int drawCount = 0;
	int vicCount = 0;
	int faiCount = 0;
	Scanner sc = new Scanner(System.in);
	CountDown cd = new CountDown();
	Thread th = new Thread(cd);
	Rps()
	{
		while(true)
		{
			System.out.println("1. 게임 시작");
			System.out.println("2. 결과");
			System.out.println("3. 종료");
			System.out.print("선택 : ");
			sel = sc.nextInt();
			if(sel == 1)
			{
				comSel = (int)(Math.random()*3+1);
				gameStart();
			}
			else if(sel == 2)
			{
				history();
			}
			else if(sel == 3)
			{
				System.out.println("게임을 종료합니다.");
				break;
			}
		}
	}
	void gameStart()
	{
		
		System.out.println("컴퓨터가 생각중입니다");
		System.out.println("내 선택 : 1.가위/2.바위/3.보");
		mySel = sc.nextInt();
		th.start();
		if( mySel == 1 && comSel == 1 ||
			mySel == 2 && comSel == 2 ||
			mySel == 3 && comSel == 3)
		{
			System.out.println("컴퓨터 : " + comSel + " 나 : " + mySel);
			System.out.println("무승부 입니다.");
			playCount++;
			drawCount++;
		}
		else if(mySel == 1 && comSel == 2 ||
				mySel == 2 && comSel == 3 ||
				mySel == 3 && comSel == 1)
		{
			System.out.println("컴퓨터 : " + comSel + " 나 : " + mySel);
			System.out.println("패배 하였습니다.");
			playCount++;
			faiCount++;
		}
		else if(mySel == 1 && comSel == 3 ||
				mySel == 2 && comSel == 1 ||
				mySel == 3 && comSel == 2)
		{
			System.out.println("컴퓨터 : " + comSel + " 나 : " + mySel);
			System.out.println("승리 하였습니다.");
			playCount++;
			vicCount++;
		}
	}
	void history()
	{
		System.out.println("총 플레이 횟수 : " + playCount);
		System.out.println("승리 횟수 : " + vicCount);
		System.out.println("패배 횟수 : " + faiCount);
		System.out.println("무승부 횟수 : " + drawCount);
	}
	void run()
	{
		try {
			Thread.sleep(500);
			System.out.println("3...");
			Thread.sleep(500);
			System.out.println("2...");
			Thread.sleep(500);
			System.out.println("1...");
		} catch (InterruptedException e) {}
	}
}
