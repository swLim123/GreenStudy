package 자바수업3일;
public class Study1_1클래스 
{
	public static void main(String[] args) 
	{
		Test test = new Test();
		test.hello();
		System.out.println("Test변수 name값 : " + test.name);
	}
}

class Test
{
	String name = "홍길동";
	int age = 23;
	
	void hello()
	{
		System.out.println("Test 클래스에 온 것을 환영!");
	}
}