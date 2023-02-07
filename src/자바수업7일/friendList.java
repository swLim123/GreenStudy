package 자바수업7일;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
public class friendList implements Serializable
{
	private String name;
	private String tel;
	private static transient Scanner sc;
	static
	{
	sc = new Scanner(System.in);
	}
	public friendList() throws IOException {		
		System.out.print("name = ");
		name = sc.next();
		System.out.print("tel = ");
		tel = sc.next();
	}
	public void disp() {
		System.out.println(name + "\t");
		System.out.println(tel + "\t");
	}

}
