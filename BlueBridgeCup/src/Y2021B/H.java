package Y2021B;

import java.io.*;
import java.util.StringTokenizer;

public class H {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static int[][] f;

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		getF(n);

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (f[i][j] == n) {
					out.println((i - 1) * i / 2 + j);
				}
			}
		}

		close();
	}

	private static void getF(int n) {
		f = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			f[i][1] = 1;
			f[i][i] = 1;
			for (int j = 1; j <= n; j++) {
				if (i >= 3 && j > 1 && j < n) {
					f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
				}
			}
		}
	}

	public static int nextInt() throws IOException {
		while (!tk.hasMoreTokens()) {
			tk = new StringTokenizer(in.readLine());
		}
		return Integer.parseInt(tk.nextToken());
	}

	public static void close() throws IOException {
		in.close();
		out.close();
	}
}
