package Y2021B;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class I {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		int m = nextInt();
		Integer[] nums = new Integer[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}
		while (m-- > 0) {
			int p = nextInt();
			int q = nextInt();
			if (p == 0) {
				Arrays.sort(nums, 0, q, Collections.reverseOrder());
			} else if (p == 1) {
				Arrays.sort(nums, q - 1, n);
			}
		}

		for (int i = 0; i < n; i++) {
			if (i == n - 1) {
				out.println(nums[i]);
				break;
			}
			out.print(nums[i] + " ");
		}

		close();
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
