package 자바수업1일;

import java.util.Scanner;

public class Study1_5제어문for 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int repeatCnt;
		
		System.out.println("반복횟수 입력");
		repeatCnt = sc.nextInt();
		
		for(int i = 0; i < repeatCnt; i++)
		{
			System.out.println(i+1 + "번 동작");
		}
	}

}
