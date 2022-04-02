package Y2017C;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/04/02
 * @time 140ms
 */
public class PREV_202Excel地址 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		int[] ans = new int[50];
		int cnt = 0;
		while (n > 0) {
			if (n % 26 == 0) {
				ans[cnt++] = 26;
				n /= 26;
				n -= 1;
			} else {
				ans[cnt++] = n % 26;
				n /= 26;
			}
		}
		for (int i = cnt - 1; i >= 0; i--) {
			out.printf("%c", 'A' + (ans[i] - 1));
		}
		out.println();

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
