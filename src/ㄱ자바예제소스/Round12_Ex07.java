class Inner6 {
	int y = 200;

	public Inner6() {
		this.disp();
	}

	public void disp() {
	}
}

public class Round12_Ex07 {
	public static void main(String[] ar) {
		final int x = 100;
		new Inner6() {
			public void disp() {
				System.out.println("Default ������");
				System.out.println("x = " + x);
				System.out.println("y = " + y);
			}
		};
	}
}
