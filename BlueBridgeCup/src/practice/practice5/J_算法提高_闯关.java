package practice.practice5;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/12 25/100
 */
public class J_算法提高_闯关 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer token = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		int m = nextInt();
		long p = nextLong();
		long[] v = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			v[i] = nextLong();
		}

		long[] dp = new long[n + 2];
		dp[1] = v[1] - p;
		for (int i = 1; i <= n; i++) {
			int idx = Math.min(i + m, n);
			long max = 0;
			int j;
			for (j = i + 1; j <= idx; j++) {
				max = Math.max(max, v[i] - p);
			}
			dp[i] = dp[j] + max;
		}

		out.println(dp[n]);

		close();
	}

	public static int nextInt() throws IOException {
		while (!token.hasMoreTokens()) {
			token = new StringTokenizer(in.readLine());
		}

		return Integer.parseInt(token.nextToken());
	}

	public static void close() throws IOException {
		in.close();
		out.close();
	}

	public static long nextLong() throws IOException {
		while (!token.hasMoreTokens()) {
			token = new StringTokenizer(in.readLine());
		}

		return Long.parseLong(token.nextToken());
	}
}
