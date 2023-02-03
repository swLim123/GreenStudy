package 자바수업5일;
import java.util.Scanner;

import com.sun.org.apache.xpath.internal.operations.Equals;

public class Study1_1과제1 
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
			
			if(id.equals(serverId) && pw.equals(serverPw))
			{
				System.out.println("로그인 되었습니다.");
				System.out.println("현재 잔액 : " + getData(this.serverId, this.serverPw));
			}
			else
			{
				System.out.println("!! 로그인 실패 !!");
			}
			
		}
		if(select == 2)
		{
			System.out.println("<< 프로그램 종료 >>");
		}
	}
	int getData(String id, String pw)
	{
		return money;
	}
}
