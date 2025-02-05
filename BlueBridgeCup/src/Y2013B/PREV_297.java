package Y2013B;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/15
 * 幸运数
 * 待看，过不了测试用例
 */
public class PREV_297 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer token = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		int m = nextInt();
		int n = nextInt();

		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i * 2 + 1;
		}
		int idx = 1;
		while (true) {
			int p = idx + 1;
			for (int i = idx + 1; i < n; i++) {
				if ((i + 1) % nums[idx] != 0) {
					nums[p++] = nums[i];
				}
				if (nums[i] > n) {
					break;
				}
			}
			idx++;
			if (nums[idx] >= n) {
				break;
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] >= n) {
				break;
			}
			if (nums[i] > m) {
				ans++;
			}
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
