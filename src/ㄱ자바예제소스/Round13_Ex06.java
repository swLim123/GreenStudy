class A2 {
	public void disp() {
		System.out.println("A2 Ŭ����");
	}
}

class B2 extends A2 {
	public void disp() {
		super.disp(); // A2 Ŭ������ disp() �޼��带 ȣ��
		System.out.println("B2 Ŭ����");
	}
}

public class Round13_Ex06 {
	public static void main(String[] ar) {
		B2 bp = new B2();
		bp.disp();
	}
}
