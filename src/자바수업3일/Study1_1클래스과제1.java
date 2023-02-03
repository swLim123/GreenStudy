package 자바수업3일;

import java.util.Scanner;

public class Study1_1클래스과제1 
{

	public static void main(String[] args) 
	{
		Score score = new Score();
	}

}
class Score
{
	Scanner sc = new Scanner(System.in);
	int kor, eng, mat, tot;
	int select;
	double avg;
	Score()
	{
		while(true)
		{
			System.out.println("1.점수 입력");
			System.out.println("2.점수 출력");
			System.out.println("3.종료");
			System.out.print("선택 : ");
			select = sc.nextInt();
			
			if(select == 1)
			{
				input();
			}
			else if(select == 2)
			{
				output();
			}
			else if(select == 3)
			{
				System.out.println("<< 프로그램 종료 >>");
				break;
			}
		}
		
	}
	void input()
	{
		System.out.print("국어점수 : ");
		kor = sc.nextInt();
		System.out.print("영어점수 : ");
		eng = sc.nextInt();
		System.out.print("수학점수 : ");
		mat = sc.nextInt();
		tot = kor + eng + mat;
		avg = tot/3.0;
	}
	void output()
	{
		System.out.println("국어:" + kor + " 영어:" + eng + " 수학:" + mat);
		System.out.println("총점:" + tot + " 평균:" + avg);
	}
}