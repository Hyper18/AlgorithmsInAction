package Y2022BFinal;

import java.io.*;
import java.util.StringTokenizer;

public class E {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static final int N = 2000 + 10;
	private static int[][] f = new int[N][N];

	public static void main(String[] args) throws IOException {
		int n = nextInt(), m = nextInt();
		while (m-- > 0) {
			int x1 = nextInt(), y1 = nextInt(), x2 = nextInt(), y2 = nextInt();
		}
		out.println((double) n * 3 / 8);

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
