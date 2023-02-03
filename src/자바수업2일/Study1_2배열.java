package 자바수업2일;

public class Study1_2배열 
{

	public static void main(String[] args) 
	{
		int num[] = new int[5];
		num[0] = 100;
		num[1] = 100;
		num[2] = 100;
		num[3] = 100;
		num[4] = 100;
		
		int number[] = {1,2,3,4,5,6};
		int[] number2 = {1,2,3,4,5,6};
		int []number3 = {1,2,3,4,5,6};
		
		for(int i = 0; i<num.length; i++)
		{
			System.out.println("num[" + i + "] = " + num[i]);
		}
	}

}
