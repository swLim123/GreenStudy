import java.io.*;
public class Round15_Ex18 {
	public static void main(String[] args) throws IOException {
		Runtime rt = Runtime.getRuntime();
		System.out.print("1.¥Ÿ¿Ω 2.«¡∏Æ√ß = ");
		int x = System.in.read() - 48;
		System.in.read();
		System.in.read();
		String str = "";
		if(x == 1){
			str = "http://www.daum.net";
		}
		else if(x == 2){
			str = "http://www.freechal.com";
		}
		rt.exec("explorer.exe " + str);
		
	}
}
