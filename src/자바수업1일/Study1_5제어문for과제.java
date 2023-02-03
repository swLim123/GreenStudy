package 자바수업1일;

import java.util.Scanner;

public class Study1_5제어문for과제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dan;
		System.out.print("출력단 입력");
		dan = sc.nextInt();
		
		for(int i = 0; i < 9; i++)
		{
			System.out.println(dan + "x" + (i+1) + "=" + dan*(i+1));
		}
	}

}
