package 자바수업3일;

import java.util.Scanner;

public class Study1_1과제 
{

	public static void main(String[] args) 
	{
		int select;
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1.별표 찍기");
			System.out.println("2.구구단 찍기");
			System.out.println("3.종료");
			System.out.println("선택 : ");
			select = sc.nextInt();
			
			if(select == 1)
			{
				star();
			}
			else if(select == 2)
			{
				gugudan();
			}
			else if(select == 3)
			{
				System.out.println("<< 프로그램 종료 >>");
				break;
			}
		}
	}
	static void star()
	{
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j <= i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	static void gugudan()
	{
		for(int dan = 2; dan < 10; dan++)
		{
			for(int su = 1; su < 10; su++)
			{
				System.out.println(dan + "*" + su + "=" + dan*su);
			}
		}
	}
}
