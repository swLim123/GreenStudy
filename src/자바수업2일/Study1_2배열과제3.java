package 자바수업2일;

import java.util.Scanner;

public class Study1_2배열과제3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String data[] = {"홍길동"  , "아무개" , "둘리"};
		while(true)
		{
			System.out.println("찾을 이름 입력 : ");
			String name = sc.next();
			
			for(int i = 0; i < data.length; i++)
			{
				if(name.equals(data[i]))
				{
					System.out.println("해당 이름이 존재합니다.");
					break;
				}
			}
			System.out.print("계속 하시겠습니까?(y , n)");
			String yNo = sc.next();
			if(yNo.equals("n"))
			{
				break;
			}
		}
	}

}
