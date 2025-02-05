package Y2018B;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/04/06
 * 枚举 -- O(n^3)
 * 75/100
 */
public class PREV_100递增三元组 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		int[] A = new int[n + 1];
		int[] B = new int[n + 1];
		int[] C = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			A[i] = nextInt();
		}
		for (int j = 1; j <= n; j++) {
			B[j] = nextInt();
		}
		for (int k = 1; k <= n; k++) {
			C[k] = nextInt();
		}

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (A[i] < B[j] && B[j] < C[k]) {
						ans++;
					}
				}
			}
		}

		out.println(ans);

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
