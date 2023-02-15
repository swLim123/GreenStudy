package ㄱ자바예제소스;
import java.sql.*;
import java.io.*;

public class Round27_Ex11 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Round27_Ex10 dao = new Round27_Ex10();
		while (true) {
			System.out.print("1.회원가입\n2.로그인\n3.정보수정\n4.정보삭제\n5.회원리스트\n6.종료 = ");
			int x = System.in.read() - 48;
			System.in.read();
			System.in.read();
			if (x == 1) {
				System.out.println("회원가입 페이지 입니다.");
				System.out.print("ID : ");
				String id = in.readLine();
				System.out.print("Password : ");
				String pass = in.readLine();
				System.out.print("Name : ");
				String name = in.readLine();
				System.out.print("Hp : ");
				String hp = in.readLine();
				System.out.print("Sex : ");
				String sex = in.readLine();
				boolean bool = dao.registerMember(id, pass, name, hp, sex);
				if (bool)
					System.out.println("회원가입에 성공하였습니다~!");
				else
					System.out.println("회원가입에 실패하였습니다!!");
				System.out.println();
			} else if (x == 2) {
				System.out.println("로그인 페이지 입니다.");
				System.out.print("ID : ");
				String id = in.readLine();
				System.out.print("Password : ");
				String pass = in.readLine();
				boolean bool = dao.loginMember(id, pass);
				if (bool)
					System.out.println("로그인에 성공하였습니다~!");
				else
					System.out.println("로그인에 실패하였습니다");
				System.out.println();
			} else if (x == 3) {
				System.out.println("정보수정 페이지 입니다.");
				System.out.print("ID : ");
				String id = in.readLine();
				System.out.print("password : ");
				String pass = in.readLine();
				System.out.print("name : ");
				String name = in.readLine();
				System.out.print("hp : ");
				String hp = in.readLine();
				System.out.print("sex : ");
				String sex = in.readLine();
				boolean bool = dao.editMember(id, pass, name, hp, sex);
				if (bool)
					System.out.println("회원정보를 수정하였습니다~!");
				else
					System.out.println("회원정보를 수정하지 못하였습니다!!");
				System.out.println();
			} else if (x == 4) {
				System.out.println("정보삭제 페이지 입니다.");
				System.out.print("ID : ");
				String id = in.readLine();
				boolean bool = dao.deleteMember(id);
				if (bool)
					System.out.println("회원정보가 삭제되었습니다~!");
				else
					System.out.println("회원정보를 삭제하지 못하였습니다!!");
				System.out.println();
			} else if (x == 5) {
				dao.ViewMember();
			}else if (x == 6) {
				System.exit(0);
			} else {
				System.err.println("잘못 입력!!");
			}
		}
	}
}
