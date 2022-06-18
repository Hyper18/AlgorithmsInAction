package Y2022BFinal;

import java.io.*;
import java.util.StringTokenizer;

public class G {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static final int N = 10000 + 10;
	private static int[] p = new int[N];

	public static void main(String[] args) throws IOException {
		int n = nextInt(), m = nextInt(), k = nextInt();
		for (int i = 1; i <= n; i++) {
			int v = nextInt(), w = nextInt();
			for (int j = m; j >= v + k; j--) {
				p[j] = Math.max(p[j], Math.max(p[j - v] + w, p[j - v - k] + w * 2));
			}
		}
		out.println(p[m]);
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
