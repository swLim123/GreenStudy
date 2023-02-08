package 자바수업8일;
import java.util.Scanner;
public class clac 
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
				minus();
			}
			else if(select.equals("*"))
			{
				multiply();
			}
			else if(select.equals("/"))
			{
				division();
			}
	}
	
	static void plus()
	{	
		System.out.println("결과 : " + (su1+su2));
	}
	static void minus()
	{
		System.out.println("결과 : " + (su1-su2));
	}
	static void multiply()
	{
		System.out.println("결과 : " + (su1*su2));
	}
	static void division()
	{
		System.out.println("결과 : " + (su1/su2));
	}
}
