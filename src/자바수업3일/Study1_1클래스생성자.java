package 자바수업3일;

public class Study1_1클래스생성자 
{
	public static void main(String[] args) 
	{
		Construct con = new Construct();
		System.out.println("메인에서 드립니다.");
	}
}
class Construct
{
	//클래스명과 똑같은 이름으로 사용 가능
	//생성자는 리턴값이 없는 메소드처럼 사용 가능
	Construct()
	{
		System.out.println("Construct클래스가 생성되었습니다.");
	}
}