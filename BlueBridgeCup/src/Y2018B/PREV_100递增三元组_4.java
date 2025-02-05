package Y2018B;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/04/06
 * 双指针优化
 */
public class PREV_100递增三元组_4 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		int[] A = new int[n];
		int[] B = new int[n];
		int[] C = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = nextInt();
		}
		Arrays.sort(A);
		for (int j = 0; j < n; j++) {
			B[j] = nextInt();
		}
		Arrays.sort(B);
		for (int k = 0; k < n; k++) {
			C[k] = nextInt();
		}
		Arrays.sort(C);

		int pa = 0, pc = 0;
		long ans = 0;
		for (int pb = 0; pb < n; pb++) {
			while (pa < n && A[pa] < B[pb]) {
				pa++;
			}
			while (pc < n && C[pc] <= B[pb]) {
				pc++;
			}
			if (pa == n && pc == n) {
				break;
			}
			ans += (long) pa * (n - pc);
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
