package practice.practice5;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/12
 * @time 109ms
 * <p>
 * 思路
 * 1. 贪心
 * 2. dp
 */
public class G_算法提高_最大连续子段和 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer token = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = nextInt();
		}

		int ans = nums[0];
		int sum = 0;
		for (int num : nums) {
			sum = Math.max(sum + num, num);
			ans = Math.max(ans, sum);
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
}
