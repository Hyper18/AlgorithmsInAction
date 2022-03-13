package practice5;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/13
 * @time 93ms
 * 测试用例离谱，给明m<n却有n=m测试数据
 * dp
 * 反序开始
 */
public class F_算法提高_学生节 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer token = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		int m = nextInt();
		int t = nextInt();
		int[] val = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			val[i] = nextInt();
		}
		int[] time = new int[t];
		for (int i = 0; i < t; i++) {
			time[i] = nextInt();
		}

		int[][] dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = n; j > 0; j--) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + val[i]);
			}
		}

		for (int e : time) {
			out.println(dp[e][m]);
		}

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
}
