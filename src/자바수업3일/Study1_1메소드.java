package 자바수업3일;

public class Study1_1메소드 
{
	public static void main(String[] args) 
	{
		//메소드의 4가지 규칙
		//1번 유형 리턴x 전달x
		//철수야 놀다가 들어와~
		chulsu();
		//2번 유형 리턴x 전달o
		//철수야 만원 줄테니 햄버거나 사먹어
		chulsu2(10000);
		//3번 유형 리턴o 전달x
		//철수야 올때 가방1개만 가져다줘
		int bag = chulsu3();
		{
			System.out.println("가져다준 가방" + bag + "개 잘 받았음");
		}
		//4번 유형 리턴o 전달o
		//철수야 2만원 줄테니 불고기버거 5천원짜리 4개 사다줘
		System.out.println("불고기버거 " + chulsu4(20000) + "개 잘 받았음");
	}
	static void chulsu()
	{
		System.out.println("철수야 놀다가 들어와~");
	}
	static void chulsu2(int money)
	{
		System.out.println(money + "원 받아서 햄버거 사먹었어요");
	}
	static int chulsu3()
	{
		return 1;
	}
	static int chulsu4(int money)
	{
		int 불고기버거 = 5000;
		return money / 불고기버거;
	}
}
