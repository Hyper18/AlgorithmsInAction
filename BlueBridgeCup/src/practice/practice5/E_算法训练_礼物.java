package practice.practice5;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/12
 * @time 343ms
 * 1. 双指针+贪心（超时）
 * 2. 前缀和+二分
 */
public class E_算法训练_礼物 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer token = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static final int MAX = 1000000 + 5;
	private static long[] pre = new long[MAX];
	static int n;
	static long s;

	public static void main(String[] args) throws IOException {
		n = nextInt();
		s = nextLong();
		for (int i = 1; i <= n; i++) {
			pre[i] = pre[i - 1] + nextLong();
		}

		int low = 1;
		int high = n;
		while (low < high) {
			int mid = low + high + 1 >> 1;
			if (check(mid)) {
				low = mid;
			} else {
				high = mid - 1;
			}
		}

		out.println(low * 2);

		close();
	}

	private static boolean check(int mid) {
		for (int i = mid; i <= n - mid; i++) {
			if (pre[i] - pre[i - mid] <= s && pre[i + mid] - pre[i] <= s) {
				return true;
			}
		}
		return false;
	}

	public static long nextLong() throws IOException {
		while (!token.hasMoreTokens()) {
			token = new StringTokenizer(in.readLine());
		}

		return Long.parseLong(token.nextToken());
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
