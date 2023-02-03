interface A1 {
	int w = 10;

	static int x = 20;

	final int y = 30;

	public static final int z = 40;
}

public class Round14_Ex01 {
	public static void main(String[] ar) {
		//A1 ap = new A1(); // Compile Error
		//A1.w = 100; // Compile Error
		System.out.println("w = " + A1.w); // w = 10
		System.out.println("x = " + A1.x); // x = 20
		System.out.println("y = " + A1.y); // y = 30
		System.out.println("z = " + A1.z); // z = 40
	}
}
