package ㄱ자바예제소스;	
import java.io.*;
	public class Round16_Ex14 implements Serializable {
		private String name;
		private String tel;
		private static transient BufferedReader in;
		static {
			in = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public Round16_Ex14() throws IOException {		
			System.out.print("name = ");
			name = in.readLine();
			System.out.print("tel = ");
			tel = in.readLine();
		}
		public void disp() {
			System.out.println(name + "\t");
			System.out.println(tel + "\t");
		}
	}
