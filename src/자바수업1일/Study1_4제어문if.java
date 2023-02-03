package 자바수업1일;

import java.util.Scanner;

public class Study1_4제어문if {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int age;
		System.out.println("나이를 입력하십시오 : ");
		age = sc.nextInt();
		
		if(age > 18)
		{
			System.out.println("성인입니다.");
		}
		else
		{
			System.out.println("미성년입니다.");
		}
	}

}
