package Y2022BFinal;

import java.io.*;
import java.util.StringTokenizer;

public class J {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	static long ans;

	public static void main(String[] args) throws IOException {
		int l = nextInt(), r = nextInt();
		for (int i = l; i <= r; i++) {
			String s = String.valueOf(i);
			if (s.indexOf("2022") >= 0) {
				ans += i;
			}
		}
		out.println(ans);
		close();
	}

	public static int nextInt() throws IOException {
		while (!tk.hasMoreTokens()) {
			tk = new StringTokenizer(in.readLine());
		}
		return Integer.parseInt(tk.nextToken());
	}

	public static String next() throws IOException {
		while (!tk.hasMoreTokens()) {
			tk = new StringTokenizer(in.readLine());
		}
		return tk.nextToken();
	}

	public static void close() throws IOException {
		in.close();
		out.close();
	}
}
