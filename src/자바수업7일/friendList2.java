package 자바수업7일;
import java.io.*;
import java.util.*;

public class friendList2 {
	public static void main(String[] args) throws ClassNotFoundException,
			IOException {
		File dir = new File("c:\\java\\work");
		File file = new File(dir, "myfriends2.dat");
		Vector vc = new Vector();
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(file)));
			vc = (Vector) ois.readObject();
			ois.close();
		}
		while (true) {
			System.out.print("1.친구등록 2.전체보기 3.종료 = ");
			int x = System.in.read() - 48;
			System.in.read();
			System.in.read();
			if (x == 1) {
				friendList ps = new friendList();
				vc.add(ps);
				System.out.println("친구 1명을 등록 하였습니다.");
			} else if (x == 2) {
				for (int i = 0; i < vc.size(); i++) {
					friendList imsi = (friendList) vc.elementAt(i);
					imsi.disp();
				}
			} else if (x == 3) {
				ObjectOutputStream oos = new ObjectOutputStream(
						new BufferedOutputStream(new FileOutputStream(file)));
				oos.writeObject(vc);
				oos.close();
				System.exit(0);
			} else {
				System.out.println("잘못 입력!!");
			}
		}
	}
}