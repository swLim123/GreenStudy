package 자바수업3일;
import java.util.Scanner;
public class Study1_1클래스과제3 
{
	public static void main(String[] args) 
	{
		Car car = new Car();
	}
}
class Car
{
	Scanner sc = new Scanner(System.in);
	String carName;
	int fuel = 0;
	int speed = 0;
	boolean engine = false;
	Car()
	{
		System.out.println("<< 자동차 시뮬레이션 >>");
		System.out.print("자동차 이름 입력 : ");
		carName = sc.next();
		System.out.println(carName + "클래스가 생성되었습니다.");
		
		while(true)
		{
			int select;
			System.out.println("< 현재 " + carName + "상태 >");
			System.out.println("[시동 : " + engine + " 속도 : " + speed + " 연료 : " + fuel + "]");
			System.out.println("1.연료 주입");
			System.out.println("2.시동 걸기");
			System.out.println("3.시뮬레이션 종료");
			System.out.print("선택 : ");
			select = sc.nextInt();
			
			if(select == 1)
			{
				System.out.println("< 연료를 주입하였습니다. >");
				fuel += 50;
				if(fuel > 100)
				{
					System.out.println("!!! 연료가 가득 찼습니다 !!!");
					fuel = 100;
				}
			}
			else if(select == 2)
			{
				bootOn()
			}
			else if(select == 3)
			{
				System.out.println("< 시뮬레이션이 종료되었습니다. >");
				break;
			}
		}
	}
	void bootOn()
	{
		if(fuel == 0)
		{
			System.out.println("연료를 주입하십시오.");
		}
		else
		{
			engine = true;
			System.out.println("< 시동이 걸렸습니다! >");
			while(true)
			{
				int select2;
				System.out.println("현재 " + carName + "상태 - 운행중");
				System.out.println("[시동 : " + engine + " 속도 : " + speed + " 연료 : " + fuel);
				System.out.println("1.가속하기");
				System.out.println("2.브레이크");
				System.out.println("3.시동끄기");
				System.out.print("선택 : ");
				select2 = sc.nextInt();
				if(select2 == 1)
				{
					speedUp();
				}
				else if(select2 == 2)
				{
					brake();
				}
				else if(select2 == 3)
				{
					bootOff();
					break;
				}
			}
		}
	}
	void bootOff()
	{
		System.out.println("시동이 꺼졌습니다.");
		engine = false;
		speed = 0;
	}
	void speedUp()
	{
		System.out.println("10km 차가 가속합니다.");
		speed += 10;
		fuel--;
		if(speed > 100)
		{
			System.out.println("100km의 속도가 최대치 입니다!");
			speed = 100;
			fuel++;
		}
		if(fuel < 0)
		{
			engine = false;
			speed = 0;
			fuel = 0;
		}
	}
	void brake()
	{
		System.out.println("10km 차가 감속합니다.");
		speed -=10;
		fuel--;
		if(speed < 0)
		{
			System.out.println("현재 속도가 0으로 멈춰있습니다.");
			speed = 0;
			fuel++;
		}
		if(fuel < 0 )
		{
			engine = false;
			speed = 0;
			fuel = 0;
		}
	}
}