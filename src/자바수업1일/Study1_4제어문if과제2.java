package 자바수업1일;

import java.util.Scanner;

public class Study1_4제어문if과제2 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int grade;
		System.out.print("학년을 입력하세요:");
		grade = sc.nextInt();
		
		switch(grade)
		{
			case 1 : System.out.println("1학년 입니다.");
			break;
		
			case 2 : System.out.println("2학년 입니다.");
			break;
		
			case 3 : System.out.println("3학년 입니다.");
			break;
		
			default : System.out.println("유효하지 않은 학년입니다.");
			break;
		}
		
	}

}
