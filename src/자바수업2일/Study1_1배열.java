package 자바수업2일;

import java.util.Scanner;

public class Study1_1배열 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int kor = 0; 
		int eng = 0;
		int mat = 0;
		int sum;
		int select;
		double avg;
		while(true)
		{
			System.out.print("1.점수 입력 \n2.점수 출력 \n3.종료 \n선택 : ");
			select = sc.nextInt();
			
			if(select == 1)
			{
				System.out.println("국어 점수 입력 : ");
				kor = sc.nextInt();
				System.out.println("영어 점수 입력 : ");
				eng = sc.nextInt();
				System.out.println("수학 점수 입력 : ");
				mat = sc.nextInt();
			}
			
			else if(select == 2)
			{
				sum = kor + eng + mat;
				avg = sum/3.0;
				System.out.println("국어 점수는 " + kor + "입니다.");
				System.out.println("영어 점수는 " + eng + "입니다.");
				System.out.println("수학 점수는 " + mat + "입니다.");
				System.out.println("총점은 " + sum + "입니다.");
				System.out.println("평균은 " + avg + "입니다.");
			}
			else if(select == 3)
			{
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

}
