package 자바수업2일;

import java.util.Scanner;

public class Study1_2배열과제2 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int MAX = 3;
		int MAX2 = 20;
		int kor[][] = new int[MAX][MAX2];
		int eng[][] = new int[MAX][MAX2];
		int mat[][] = new int[MAX][MAX2];
		int sum[][]= new int[MAX][MAX2];
		String name[][] = new String[MAX][MAX2];
		int select;
		int count = 0;
		int count2 = 0;
		int count3 = 0;
		int avg[][] = new int[MAX][MAX2];
		while(true)
		{
			System.out.print("1.점수 입력 \n2.점수 출력 \n3.종료 \n선택 : ");
			select = sc.nextInt();
			
			if(select == 1)
			{
				System.out.println("1.A반 / 2.B반 / 3.C반");
				int max  = sc.nextInt();
				if(max == 1)
				{
					sum[0][count] = kor[0][count] + eng[0][count] + mat[0][count];
					avg[0][count] = sum[0][count]/3;
					System.out.print(count+1 + "번 이름 입력 : ");
					name[0][count] = sc.next();
					System.out.print(count+1 + "번 국어 점수 입력 : ");
					kor[0][count] = sc.nextInt();
					System.out.print(count+1 + "번 영어 점수 입력 : ");
					eng[0][count] = sc.nextInt();
					System.out.print(count+1 + "번 수학 점수 입력 : ");
					mat[0][count] = sc.nextInt();
					count++;
				}
				else if(max == 2)
				{
					sum[1][count2] = kor[1][count2] + eng[1][count2] + mat[1][count2];
					avg[1][count2] = sum[1][count2]/3;
					System.out.print(count2+1 + "번 이름 입력 : ");
					name[1][count2] = sc.next();
					System.out.print(count2+1 + "번 국어 점수 입력 : ");
					kor[1][count2] = sc.nextInt();
					System.out.print(count2+1 + "번 영어 점수 입력 : ");
					eng[1][count2] = sc.nextInt();
					System.out.print(count2+1 + "번 수학 점수 입력 : ");
					mat[1][count2] = sc.nextInt();
					count2++;
				}
				else if(max == 3)
				{
					sum[2][count3] = kor[2][count3] + eng[2][count3] + mat[2][count3];
					avg[2][count3] = sum[2][count3]/3;
					System.out.print(count3+1 + "번 이름 입력 : ");
					name[2][count3] = sc.next();
					System.out.print(count3+1 + "번 국어 점수 입력 : ");
					kor[2][count3] = sc.nextInt();
					System.out.print(count3+1 + "번 영어 점수 입력 : ");
					eng[2][count3] = sc.nextInt();
					System.out.print(count3+1 + "번 수학 점수 입력 : ");
					mat[2][count3] = sc.nextInt();
					count3++;
				}
			}
			
			else if(select == 2)
			{
				for(int i = 0; i<count; i++)
					{
						System.out.println(i+1 + "번 이름은 " + name[0][i]);
						System.out.println(i+1 + "번 총점은 " + sum[0][i]);
						System.out.println(i+1 + "번 평균은 " + avg[0][i] + "입니다.");
					}
				for(int i = 0; i<count2; i++)
				{
					System.out.println(i+1 + "번 이름은 " + name[1][i]);
					System.out.println(i+1 + "번 총점은 " + sum[1][i]);
					System.out.println(i+1 + "번 평균은 " + avg[1][i] + "입니다.");
				}
				for(int i = 0; i<count3; i++)
				{
					System.out.println(i+1 + "번 이름은 " + name[2][i]);
					System.out.println(i+1 + "번 총점은 " + sum[2][i]);
					System.out.println(i+1 + "번 평균은 " + avg[2][i] + "입니다.");
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
