package 자바수업2일;

import java.util.Scanner;

public class Study1_2배열과제 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int MAX = 100;
		int kor[] = new int[MAX];
		int eng[] = new int[MAX];
		int mat[] = new int[MAX];
		int sum[] = new int[MAX];
		String name[] = new String[MAX];
		int select;
		int count = 0;
		double avg[] = new double[MAX];
		while(true)
		{
			System.out.print("1.점수 입력 \n2.점수 출력 \n3.종료 \n선택 : ");
			select = sc.nextInt();
			
			if(select == 1)
			{
				System.out.print(count+1 + "번 이름 입력 : ");
				name[count] = sc.next();
				System.out.print(count+1 + "번 국어 점수 입력 : ");
				kor[count] = sc.nextInt();
				System.out.print(count+1 + "번 영어 점수 입력 : ");
				eng[count] = sc.nextInt();
				System.out.print(count+1 + "번 수학 점수 입력 : ");
				mat[count] = sc.nextInt();
				count++;
			}
			
			else if(select == 2)
			{
				for(int i = 0; i<count; i++)
				{
					sum[i] = kor[i] + eng[i] + mat[i];
					avg[i] = sum[i]/3.0;
					System.out.println(i+1 + "번 이름은 " + name[i]);
					System.out.println(i+1 + "번 총점은 " + sum[i]);
					System.out.println(i+1 + "번 평균은 " + avg[i] + "입니다.");
				}
			}
			else if(select == 3)
			{
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
}
