package Y2016C;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/29
 * @time 93ms
 */
public class PREV_145_2 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer(" ");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static final int MAX = 1000 + 10;
	private static int[][] dp = new int[MAX][MAX];
	static int n;

	public static void main(String[] args) throws IOException {
		String x = nextString();
		String y = new StringBuilder().append(x).reverse().toString();
		n = x.length();

		lcs(x.toCharArray(), y.toCharArray());

		out.println(n - dp[n][n]);
		close();
	}

	private static void lcs(char[] x, char[] y) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = x[i - 1] == y[j - 1] ? dp[i - 1][j - 1] + 1 : Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}
	}

	public static String nextString() throws IOException {
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
