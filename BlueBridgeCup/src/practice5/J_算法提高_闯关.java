package practice5;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/12
 * 25/100
 */
public class J_算法提高_闯关 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer token = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		int m = nextInt();
		long p = nextLong();
		long[] v = new long[n];
		for (int i = 0; i < n; i++) {
			v[i] = nextLong();
		}

		long ans = v[0] - p;
		for (int i = 0; i < n; i++) {
			long max = Long.MIN_VALUE;
			int tmp = i;
			while (i < Math.min(i + m, n) - 1) {
				i++;
				if (v[i] - p > max) {
					max = v[i] - p;
					tmp = i;
				}
			}
			i = tmp;
			ans += max == Long.MIN_VALUE ? 0 : max;
		}

		out.println(ans);

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
