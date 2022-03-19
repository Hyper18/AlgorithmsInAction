package practice.practice5;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/12
 * @time 171ms
 */
public class H_算法提高_打包 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer token = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static int[] nums;
	static int m;

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		m = nextInt();
		nums = new int[n];

		int low = 0;
		int high = 0;
		for (int i = 0; i < n; i++) {
			nums[i] = nextInt();
			high += nums[i];
		}

		while (low < high) {
			int mid = high + low >> 1;
			if (check(mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		out.println(low);

		close();
	}

	private static boolean check(int mid) {
		int pack = 1;
		int packWeight = 0;
		for (int weight : nums) {
			if (weight > mid) {
				return false;
			}
			packWeight += weight;
			if (packWeight > mid) {
				packWeight = weight;
				pack++;
			}
		}

		return pack <= m;
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
