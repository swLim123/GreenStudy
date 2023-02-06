package 자바수업6일;

import java.util.Scanner;

public class Study3_응용과제1_업앤다운게임2 {
	public static void main(String[] args) {
		GameUpDown game = new GameUpDown();
	}
}
class GameUpDown 
{
	Scanner sc = new Scanner(System.in);
	static int totCnt=0,winCnt=0, lossCnt=0; //결과용 통계변수
	static int sel;
	int comNumber;  //컴퓨터가 정한 랜덤수 
	static int gameCount=5;//시도횟수	
	CountDown cd = new CountDown();
	Thread th = new Thread(cd);
	
	static boolean gameIng=false; //현재 게임 진행중 체크변수
	GameUpDown()
	{
		th.start();
		
		
		while(true)
		{
			
			System.out.println("1.게임시작");
			System.out.println("2.결과");
			System.out.println("3.종료");
			System.out.print("선택:"); sel = sc.nextInt();
			if( sel == 1)      { gameStart();}
			else if( sel == 2) { history();}
			else if( sel == 3) {System.out.println("프로그램종료.");break;}
			
		}
	}
	void randComNumber()
	{
		if(gameIng ==false)
		{
			comNumber = (int)(Math.random()*50+1);//컴퓨터 숫자생성..
		}
		
	}
	void gameStart()
	{	
		randComNumber();//처음 시작시 생성 
		
		gameIng = true;
		
		CountDown.check = true;//카운트다운시작.
		//System.out.println("컴퓨터정답:"+ comNumber);
		System.out.print("답:"); int myNumber = sc.nextInt();
		
		if(comNumber == myNumber)
		{
			if(gameCount>0)
			{
				System.out.println("정답입니다! 승리!");
				CountDown.check=false;
				CountDown.secondCheck=3;
				winCnt++;
				totCnt++;
				
				gameIng = false;//게임끝
				gameCount=5; //게임끝나서 시도횟수 다시 5개
			}
			else
			{
				System.out.println("패배하였습니다.!");
				CountDown.check=false;
				CountDown.secondCheck=3;
				totCnt++;
				lossCnt++;
				
				gameIng = false;//게임끝
				gameCount=5; //게임끝나서 시도횟수 다시 5개
			}
		}else
		{
			if(gameCount==0)
			{
				System.out.println("패배하였습니다.!");
				CountDown.check=false;
				CountDown.secondCheck=3;
				totCnt++;
				lossCnt++;	
				gameIng = false;//게임끝
				gameCount=5; //게임끝나서 시도횟수 다시 5개
			}
			else
			{
				gameCount--;
				System.out.println("틀렸습니다!(현재시도횟수:"+gameCount+"회)");
				if(comNumber >myNumber)
				{
					System.out.println("업!!!");
				}
				else
				{
					System.out.println("다운!!!");
				}
				
				CountDown.check=false;
				CountDown.secondCheck=3;
				totCnt++;
			}
		}
	}	
	void history()
	{
		System.out.println("총시도횟수 : "+totCnt+" 회");
		System.out.println("승리(5회이내정답): "+winCnt+"회");
		System.out.println("패배(5회초과시): "+lossCnt+"회");
	}	
}

class CountDown implements Runnable{
	static boolean check = false;
	static int secondCheck=3;	
	@Override
	public void run() {
		while(true)
		{
			try {
				Thread.sleep(100);				
				//System.out.println("check:" + check);
			} catch (InterruptedException e) {			
			}
			
			
			if(check == true)
			{
				try {
					System.out.println("\n3...:"+secondCheck);
					Thread.sleep(1000);
					secondCheck--;					
					if(check==false){secondCheck=3;continue;}
					
					System.out.println("2..:"+secondCheck);
					Thread.sleep(1000);
					secondCheck--;
					if(check==false){secondCheck=3;continue;}
					
					System.out.println("1.:"+secondCheck);
					Thread.sleep(1000);
					secondCheck--;				
					if(check==false){secondCheck=3;continue;}
					
					if(secondCheck==0)
					{
						check=false;
						System.out.println("시간초과..패배!");
						GameUpDown.totCnt++;
						GameUpDown.lossCnt++;
						secondCheck=3;//시칸체크 초기화
						
						GameUpDown.gameIng = false;//게임끝
						GameUpDown.gameCount=5; //게임끝나서 시도횟수 다시 5개
					}
				} catch (InterruptedException e) {			
				}
			}
		}
		
	}
}
