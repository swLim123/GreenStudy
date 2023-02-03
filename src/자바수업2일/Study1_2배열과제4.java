package 자바수업2일;

import java.util.Scanner;

public class Study1_2배열과제4 {

	public static void main(String[] args) 
	{
		int MAX = 100; //총 등록 인원제한
		String name[] = new String[MAX];
		String pNumber[] = new String[MAX];
		String add[] = new String[MAX];
		String memo[] = new String[MAX];
		int friCount = 0; //친구 추가시 카운트
		System.out.println("<< 친구 관리 프로그램 >>");
		Scanner sc = new Scanner(System.in);
		int select;
		
		while(true)
		{
			System.out.println("1. 친구 추가");
			System.out.println("2. 친구 보기");
			System.out.println("3. 친구 정보 수정");
			System.out.println("4. 친구 삭제");
			System.out.print("선택 : ");
			select = sc.nextInt();
			
			if(select == 1)
			{
				System.out.println("<친구 정보 입력>");
				System.out.print("이름 : ");
				name[friCount] = sc.next();
				System.out.print("전화번호 : ");
				pNumber[friCount] = sc.next();
				System.out.print("주소 : ");
				add[friCount] = sc.next();
				System.out.print("메모 : ");
				memo[friCount] = sc.next();
				System.out.println("친구가 추가되었습니다.");
				friCount++;
			}
			else if(select == 2)
			{
				System.out.println("< 친구 목록 >");
				for(int i = 0; i < friCount; i++)
				{
					System.out.println(name[i] + "/" + pNumber[i] + "/" + add[i] + "/" + memo[i]);
				}
			}
			else if(select == 3)
			{
				
				
				System.out.println("찾을 이름 입력 : ");
				String findName = sc.next();
				
				for(int i = 0; i < name.length; i++)
				{
					if(findName.equals(name[i]))
					{
						System.out.println("< 정보를 다시 입력하여 수정 >");
						System.out.print("이름 : ");
						name[i] = sc.next();
						System.out.print("전화번호 : ");
						pNumber[i] = sc.next();
						System.out.print("주소 : ");
						add[i] = sc.next();
						System.out.print("메모 : ");
						memo[i] = sc.next();
						System.out.println("정보가 수정 되었습니다.");
						break;
					}
				}
			}
			else if(select == 4)
			{
				System.out.print("삭제할 친구 입력 : ");
				String deleteName = sc.next();
				for(int i = 0; i < friCount; i++)
				{
					if(deleteName.equals(name[i]))
					{
						for(int del = i; del < friCount; del++)
						{
							name[del] = name[del+1];
							pNumber[del] = pNumber[del+1];
							add[del] = add[del+1];
							memo[del]	= memo[del+1];			
							System.out.println("친구가 삭제되었습니다.");
						}
						friCount--;
						break;
					}
				}
			}
			else if(select == 5)
			{
				System.out.println("-프로그램 종료-");
				break;
			}
		}
		
	}

}
