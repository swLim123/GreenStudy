package 자바수업3일;
import java.util.Scanner;
public class Study1_1클래스과제2 
{
	public static void main(String[] args) 
	{
		Minam m = new Minam();
	}
}
class Minam
{
	Scanner sc = new Scanner(System.in);
	int MAX = 10;
	String name[] = new String[MAX];
	int age[] = new int[MAX];
	double h[] = new double[MAX];
	double w[] = new double[MAX];
	String memo[] = new String[MAX];
	int mCnt = 0;
	Minam()
	{
		while(true)
		{
			int select;
			System.out.println("1.미남입력");
			System.out.println("2.미남리스트");
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
		System.out.print("이름 : ");
		name[mCnt] = sc.next();
		System.out.print("나이 : ");
		age[mCnt] = sc.nextInt();
		System.out.print("키 : ");
		h[mCnt] = sc.nextDouble();
		System.out.print("몸무게 : ");
		w[mCnt] = sc.nextDouble();
		System.out.print("평점 : ");
		memo[mCnt] = sc.next();
		System.out.println("미남이 입력 되었습니다.");
		mCnt++;
	}
	void output()
	{
		for(int i = 0; i < mCnt; i++)
		{
			System.out.println
			((i+1) + "번 " + name[i] + " " + age[i] + "살/" +
			 h[i] + "cm/" + w[i] + "kg/" + memo[i]);
			if(age[i] > 21 && age[i] < 31 &&
				h[i] > 179 && h[i] < 191 &&
				w[i] > 74 && w[i] < 86)
			{
				System.out.println("< 미남입니다! >");
			}
			else if(h[i] < 180  &&
					w[i] > 74 && w[i] < 85)
			{
				System.out.println("< 보통입니다! >");
			}
			else if(h[i] < 170  && w[i] > 90)
			{
				System.out.println("< 추남입니다! >");
			}
			else 
			{
				System.out.println("< 누구세요? >");
			}
		}
	}
}

