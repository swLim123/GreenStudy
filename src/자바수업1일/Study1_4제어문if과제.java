package 자바수업1일;

import java.util.Scanner;

public class Study1_4제어문if과제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int grade;
		System.out.print("중등 학년을 입력하세요:");
		grade = sc.nextInt();
		if(grade == 1)
		{
			System.out.println("중등 1학년 입니다.");
		}
		else if(grade == 2)
		{
			System.out.println("중등 2학년 입니다.");
		}
		else if(grade == 3)
		{
			System.out.println("중등 3학년 입니다.");
		}
		else
		{
			System.out.println("유효하지 않은 학년입니다.");
		}
	}

}
