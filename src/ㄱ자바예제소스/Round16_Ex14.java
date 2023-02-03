	import java.io.*;
	public class Round16_Ex14 implements Serializable {
		private String name;
		private String jumin;
		private String tel;
		private String addr;
		private static transient BufferedReader in;
		static {
			in = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public Round16_Ex14() throws IOException {		
			System.out.print("name = ");
			name = in.readLine();
			System.out.print("jumin = ");
			jumin = in.readLine();
			System.out.print("tel = ");
			tel = in.readLine();
			System.out.print("addr = ");
			addr = in.readLine();
		}
		public void disp() {
			System.out.print(name + "\t");
			System.out.print(jumin + "\t");
			System.out.print(tel + "\t");
			System.out.println(addr);
		}
	}
