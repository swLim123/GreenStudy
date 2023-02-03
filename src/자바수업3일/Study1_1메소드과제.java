package 자바수업3일;
import java.util.Scanner;
public class Study1_1메소드과제 
{
	static int su1;
	static int su2;
	public static void main(String[] args) 
	{
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
				plus();
			}
			else if(select.equals("-"))
			{
				minus(su1 , su2);
			}
			else if(select.equals("*"))
			{
				System.out.println("결과 : " + multiply());
			}
			else if(select.equals("/"))
			{
				System.out.println("결과 : " + division(su1 , su2));
			}
	}
	static void plus()
	{	
		System.out.println("결과 : " + (su1+su2));
	}
	static void minus(int a, int b)
	{
		System.out.println("결과 : " + (a-b));
	}
	static int multiply()
	{
		return su1 * su2;
	}
	static int division(int a, int b)
	{
		return a / b;
	}
}
