package 자바수업5일;

public class Study1_1예제1 {

	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2 = new Test(1000000);
		Test t3 = new Test("01089446799");
		Test t4 = new Test(22, 177.5,"홍길동"); t4.output();
		Test t5 = new Test(95.5);
	}
}
class Test{
	int age; double height; String name;
	Test()	{System.out.println("TEST클래스가 생성되었습니다.");	}
	Test(int money)	{System.out.println("TEST클래스가 "+money+"원을 가지고생성");}
	Test(String hp)	{System.out.println("최쌤전번은 "+hp+"다. 일생기면연락하자");	}
	Test(int age, double height, String name)	
	{
		this.age = age; this.height = height; this.name = name;
		System.out.println("나이는:"+age+"살");	
		System.out.println("키는:"+height+"cm");
		System.out.println("이름은:"+name+"이다");
	}
	Test(double weight)	
	{
		System.out.println("나이는:"+age+"살");	
		System.out.println("키는:"+height+"cm");
		System.out.println("이름은:"+name+"이다");
		System.out.println("몸무게는:"+weight+"kg이다");
	}
	void output()
	{
		System.out.println("나이는:"+age+"살");	
		System.out.println("키는:"+height+"cm");
		System.out.println("이름은:"+name+"이다");
	}
	
	
}

