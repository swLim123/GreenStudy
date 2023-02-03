class UpperClass {
	int x;

	int y;

	public UpperClass() {
		x = 10;
		y = 20;
	}

	public UpperClass(int x) {
		this(); // �ڽ��� Ŭ���� public UpperClass() ������ ȣ��
		this.x = x;
	}

	public UpperClass(int x, int y) {
		this(x); // �ڽ��� Ŭ���� public UpperClass(int x) ������ ȣ��
		this.y = y;
	}
}

class LowerClass extends UpperClass {
	int r;

	public LowerClass() {
		super(); // ���� Ŭ������ public UpperClass() ������ ȣ��. ���� ����.
		r = 30;
	}

	public LowerClass(int x) {
		super(x); // ���� Ŭ������ public UpperClass(int x) ������ ȣ��
		r = 30;
	}

	public LowerClass(int x, int y) {
		super(x, y); // ���� Ŭ������ public UpperClass(int x, int y) ������ ȣ��
		r = 30;
	}

	public LowerClass(int x, int y, int r) {
		this(x, y); // �ڽ��� Ŭ���� public LowerClass(int x, int y) ������ ȣ��
		this.r = r;
	}
}

public class Round13_Ex03 {
	public static void main(String[] ar) {
		// �ʿ��� ��ü ���� ����.
	}
}
