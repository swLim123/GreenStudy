package 자바수업10일;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class 메모파일만들기시험 
{
	public static void main(String[] args) throws IOException 
	{
		Memo mo = new Memo();
	}
}
class Memo
{
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd ");
	Calendar c1 = Calendar.getInstance();
	Memo() throws IOException 
	{
		System.out.println("< 메모 프로그램 >");
		while(true)
		{
			int sel;
			System.out.println("1. 메모하기");
			System.out.println("2. 메모보기");
			System.out.println("3. 종료");
			System.out.print("선택 : ");
			sel = sc.nextInt();
			if(sel == 1)
			{
				MemoWrite();
			}
			else if(sel == 2)
			{
				MemoPrint();
			}
			else if(sel == 3)
			{
				System.out.println("< 프로그램을 종료합니다 >");
				break;
			}
		}
	}
	void MemoWrite() throws IOException 
	{
		System.out.print("메모를 입력하세요 : ");
		try (PrintWriter pw = new PrintWriter("c:/memo.txt")) {
			String data = 
			sc.nextLine();
			sc.nextLine();
			pw.println(sdf.format(c1.getTime()) + data);
			
			pw.close();
		}
	}
	void MemoPrint() throws FileNotFoundException 
	{
		File file = new File("c:/memo.txt");
		Scanner sc2 = new Scanner(file);
		System.out.println(sc2.nextLine());
	}
}
