package 자바수업1일;

public class Study1_5제어문while과제 
{

	public static void main(String[] args) 
	{
		int dan = 2;
		int su = 1;
		while(dan < 10)
		{
			while(su < 10)
			{
				System.out.println(dan + "x" + su + "=" + dan*su);
				su++;
			}
			su = 1;
			dan++;
		}
		
	}

}
