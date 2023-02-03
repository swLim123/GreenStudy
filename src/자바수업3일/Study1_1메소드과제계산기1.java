package 자바수업3일;

import java.util.Scanner;

public class Study1_1메소드과제계산기1 
{

	public static void main(String[] args) 
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
				System.out.println("결과 : " + plus(su1 , su2));
			}
			else if(select.equals("-"))
			{
				System.out.println("결과 : " + minus(su1 , su2));
			}
			else if(select.equals("*"))
			{
				System.out.println("결과 : " + multiply(su1 , su2));
			}
			else if(select.equals("/"))
			{
				System.out.println("결과 : " + division(su1 , su2));
			}
	}
	static int plus(int su1 , int su2)
	{
		return su1 + su2;
	}
	static int minus(int su1 , int su2)
	{
		return su1 - su2;
	}
	static int multiply(int su1 , int su2)
	{
		return su1 * su2;
	}
	static int division(int su1 , int su2)
	{
		return su1 / su2;
	}
}
