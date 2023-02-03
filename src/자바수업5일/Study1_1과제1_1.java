package 자바수업5일;

import java.util.Scanner;

public class Study1_1과제1_1 
{
	public static void main(String[] args)
	{
		Login login = new Login();
	}
}
class Login
{
	Scanner sc = new Scanner(System.in);
	private String serverId = "admin";
	private String serverPw = "1004";
	private int money = 10000000;
	Login()
	{
		int select;
		System.out.println("<< 로그인 테스트 >>");
		System.out.println("1. 로그인 ");
		System.out.println("2. 종료 ");
		System.out.print("선택 : ");
		select = sc.nextInt();
		
		if(select == 1)
		{
			System.out.print("ID : ");
			String id = sc.next();
			System.out.print("PW : ");
			String pw = sc.next();
			
			getData(id, pw);
		}
		else if(select == 2)
		{
			System.out.println("<< 프로그램 종료 >>");
		}
	}
	int getData(String id, String pw)
	{
		if(id.equals(serverId))
		{
			return 1;
		}
		
	}
}