package 자바수업1일;

import java.util.Scanner;

public class Study1_5제어문while과제2 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int kor;
		int eng;
		int mat;
		int tot;
		double avg;
		do
		{
			System.out.print("국어 점수를 입력하세요 : ");
			kor = sc.nextInt();	
		}
			while(kor > 100 || kor < 0);
		do
		{
			System.out.print("영어 점수를 입력하세요 : ");
			eng = sc.nextInt();	
		}
			while(eng > 100 || eng < 0);
		do
		{
			System.out.print("수학 점수를 입력하세요 : ");
			mat = sc.nextInt();	
		}
			while(mat > 100 || mat < 0);
		
		tot = kor + eng + mat;
		avg = tot/3.0;
		
		System.out.println("총점 : " + tot + "평균 : " + avg);
			
	}

}
