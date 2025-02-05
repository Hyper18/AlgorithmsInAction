package practice.practice5;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/13
 * @time 93ms
 */
public class M_算法提高_秘密行动 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer token = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		int[] nums = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			nums[i] = nextInt();
		}

		int[][] dp = new int[n + 1][2];
		dp[1][0] = nums[1];
		dp[1][1] = 0;
		for (int i = 2; i <= n; i++) {
			dp[i][0] = min(dp[i - 1][0], dp[i - 1][1]) + nums[i];
			dp[i][1] = min(dp[i - 1][0], dp[i - 2][0]);
		}

		out.println(min(dp[n][0], dp[n][1]));

		close();
	}

	private static int min(int a, int b) {
		return a < b ? a : b;
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
}
