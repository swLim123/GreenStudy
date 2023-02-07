package 자바수업6일;
import java.util.Scanner;
public class Study1_1스레드에어컨
{
	public static void main(String[] args) 
	{
		Aircon air = new Aircon();
	}
}
class Aircon
{
	int tem = 25;
	int selTem;
	int sel;
	Scanner sc = new Scanner(System.in);
	Aircon()
	{
		while(true)
		{
			System.out.println("[[현재온도 : " + tem + "도]]");
			System.out.println("[[설정온도 : " + selTem + "도]]");
			System.out.println("1. 온도 설정");
			System.out.println("2. 에어컨 가동");
			System.out.println("3. 종료");
			System.out.print("선택 : ");
			sel = sc.nextInt();
			
			if(sel == 1)
			{
				TempSelect();
			}
			else if(sel == 2)
			{
				BootStart();
			}
			else if(sel == 3)
			{
				BootStop();
			}
			else if(sel == 4)
			{
				System.out.println("에어컨이 종료되었습니다.");
				break;
			}
		}
	}
	void TempSelect()
	{
		System.out.println("설정 온도를 입력하세요 : ");
		selTem = sc.nextInt();
		if(selTem < 29 && selTem > 17)
		{
			System.out.println("온도가 설정되었습니다.");
		}
		else
		{
			System.out.println("유효하지 않은 설정온도입니다.");
		}
	}
	void BootStart()
	{
		if(selTem == 0)
		{
			System.out.println("온도를 설정해주세요.");
		}
		else
		{
			Booting();
		}
		int sel2;
		System.out.println("에어컨이 가동됩니다.");
		System.out.println("[[현재온도 : " + tem + "도]]");
		System.out.println("[[설정온도 : " + selTem + "도]]");
		System.out.println("1. 온도 설정");
		System.out.println("2. 에어컨 중단");
		System.out.println("3. 종료");
		System.out.print("선택 : ");
		sel2 = sc.nextInt();
		if(sel2 == 1)
		{
			TempSelect();
		}
	}
	void BootStop()
	{
		
	}
	void Booting()
	{
		while(true)
		{
			try {
				Thread.sleep(1000);
				tem = tem - (int)(Math.random()*2);
			} catch (InterruptedException e) {}
			System.out.println("<<현재온도 : " + tem + ">>");
			if(tem == selTem)
			{
				System.out.println("전원이 꺼졌습니다. 중단");
				break;
			}
		}
	}
}
