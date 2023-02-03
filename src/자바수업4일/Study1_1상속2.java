package 자바수업4일;
public class Study1_1상속2 
{
	public static void main(String[] args) 
	{
		나 me = new 나();
	}
}
class 부모님
{
	int money = 200000000;
	String car = "벤츠";
	String house = "아파트";
}
class 나 extends 부모님
{
	나()
	{
		System.out.println("나 클래스가 생성되었습니다.");
		System.out.println("내 돈 : " + money);
		System.out.println("내 차 : " + car);
		System.out.println("내 집 : " + house);
		System.out.println("부모님 돈 : " + super.money);
		System.out.println("부모님 차 : " + super.car);
	}
	int money = 20000;
	String car = "아반떼";
}
