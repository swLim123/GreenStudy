package 자바수업4일;
import java.util.Scanner;
public class Study1_1상속과제1 
{
	public static void main(String[] args) 
	{
		Aban aban = new Aban();
		Bban bban = new Bban();
	}
}
class Score
{
	Scanner sc = new Scanner(System.in);
	int kor, eng, mat, tot;
	double avg;
	void scoreInput()
	{
		System.out.print("국어 : ");
		kor = sc.nextInt();
		System.out.print("영어 : ");
		eng = sc.nextInt();
		System.out.print("수학 : ");
		mat = sc.nextInt();
	}
	void scoreOutput()
	{
		tot = kor + eng + mat;
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + mat);
	}
}

class Aban extends Score
{
	Scanner sc = new Scanner(System.in);
	int social;
	int science;
	int tot;
	double avg;
	Aban()
	{
		System.out.println("A반 클래스가 생성되었습니다.");
		while(true)
		{
			int select2;
			System.out.println("1.점수 입력");
			System.out.println("2.점수 출력");
			System.out.println("3.종료");
			System.out.print("4.선택 : ");
			select2 = sc.nextInt();
			
			if(select2 == 1)
			{
				scoreInput();
				abanInput();
			}
			else if(select2 == 2)
			{
				scoreOutput();
				abanOutput();
			}
			else if(select2 == 3)
			{
				System.out.println("A반 종료");
				break;
			}
		}
	}
	void abanInput()
	{
		System.out.print("사회 : ");
		social = sc.nextInt();
		System.out.print("과학 : ");
		science = sc.nextInt();
	}
	void abanOutput()
	{
		tot = social + science;
		tot = this.tot + super.tot;
		avg = tot/5.0;
		System.out.println("사회 : " + social);
		System.out.println("과학 : " + science);
		System.out.println("총점 : " + tot + " 평균 : " + avg);
	}
}

class Bban extends Score
{
	Scanner sc = new Scanner(System.in);
	int music;
	int art;
	int tot;
	double avg;
	Bban()
	{
		System.out.println("B반 클래스가 생성되었습니다.");
		while(true)
		{
			int select2;
			System.out.println("1.점수 입력");
			System.out.println("2.점수 출력");
			System.out.println("3.종료");
			System.out.print("4.선택 : ");
			select2 = sc.nextInt();
			
			if(select2 == 1)
			{
				scoreInput();
				bbanInput();
			}
			else if(select2 == 2)
			{
				scoreOutput();
				bbanOutput();
			}
			else if(select2 == 3)
			{
				System.out.println("B반 종료");
				break;
			}
		}
	}
	void bbanInput()
	{
		System.out.print("음악 : ");
		music = sc.nextInt();
		System.out.print("미술 : ");
		art = sc.nextInt();
	}
	void bbanOutput()
	{
		tot = music + art;
		tot = this.tot + super.tot;
		avg = tot/5.0;
		System.out.println("음악 : " + music);
		System.out.println("미술 : " + art);
		System.out.println("총점 : " + tot + " 평균 : " + avg);
	}
}