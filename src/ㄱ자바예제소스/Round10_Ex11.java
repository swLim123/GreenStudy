import java.io.*;

public class Round10_Ex11 {
	public static void main(String[] ar) throws IOException {
		System.out.println("��ǥ �� ó��");
		Round10_Ex10 rd = new Round10_Ex10();
		// �� �Է� �ޱ�
		rd.setX();
		rd.setY();
		// ��� ��ǥ ����
		rd.display();
		// ��ǥ�� �ٸ� ������ �ű��
		System.out.println("��ǥ�� 50, 100���� �̵��մϴ�.");
		rd.setX(50);
		rd.setY(100);
		// �ٽ� �ѹ� ��� ��ǥ ����
		rd.display();
	}
}
