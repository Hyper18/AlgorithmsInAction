package Y2021BFinal;

import java.io.*;
import java.util.StringTokenizer;

public class G_和与乘积 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static final int N = (int) 2e5 + 10;
	private static long[] add = new long[N];
	private static long[] mul = new long[N];

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		mul[0] = 1;
		for (int i = 1; i <= n; i++) {
			int x = nextInt();
			add[i] = add[i - 1] + x;
			mul[i] = mul[i - 1] * x;
		}

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				long x = add[j] - add[i - 1];
				double y = (double) mul[j] / mul[i - 1];
				if (Math.floor(y) != y) {
					continue;
				}
				if (x == y) {
					ans++;
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
