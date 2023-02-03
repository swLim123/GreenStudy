package 자바수업3일;

import java.util.Scanner;

public class Study1_1메소드과제계산기2 
{

	public static void main(String[] args) 
	{
		calc();
	}
	static void calc()
	{
		int su1;
		int su2;
		Scanner sc = new Scanner(System.in);
		String select;

		System.out.print("수1 : ");
		su1 = sc.nextInt();
		System.out.print("수2 : ");
		su2 = sc.nextInt();
		System.out.print("연산자 선택\n( + , - , * , / ) : ");
		select = sc.next();
		
		if(select.equals("+"))
		{
			System.out.println("결과 : " + (su1 + su2));
		}
		else if(select.equals("-"))
		{
			System.out.println("결과 : " + (su1 - su2));
		}
		else if(select.equals("*"))
		{
			System.out.println("결과 : " + (su1 * su2));
		}
		else if(select.equals("/"))
		{
			System.out.println("결과 : " + (su1 / su2));
		}
	}
}
