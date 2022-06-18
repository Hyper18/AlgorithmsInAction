package Y2022BFinal;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static final int N = 2000 + 10, INF = 0x3f3f3f3f;
	private static int[] a = new int[N], b = new int[N];
	private static double[][] f = new double[N + N][2];

	public static void main(String[] args) throws IOException {
		int n = nextInt(), m = nextInt(), d = nextInt();
		for (int i = 1; i <= n; i++) {
			a[i] = nextInt();
		}
		for (int i = 1; i <= m; i++) {
			b[i] = nextInt();
		}
		Arrays.sort(a, 1, n);
		Arrays.sort(b, 1, m);

		for (int i = 0; i < N + N; i++) {
			f[i][0] = INF;
			f[i][1] = INF;
		}
		f[1][0] = a[1];
		f[1][1] = Math.sqrt(b[1] * b[1] + d * d);
		for (int i = 2; i <= n + m; i++) {
			int da = a[i] - a[i - 1], db = b[i] - b[i - 1];
			f[i][1] = f[i - 1][0] + da + d;
			f[i][0] = f[i - 1][1] + db + d;
		}

		out.println(Math.min(f[n + m][0], f[n + m][1]));

		close();
	}

	public static int nextInt() throws IOException {
		while (!tk.hasMoreTokens()) {
			tk = new StringTokenizer(in.readLine());
		}
		return Integer.parseInt(tk.nextToken());
	}

	public static String next() throws IOException {
		while (!tk.hasMoreTokens()) {
			tk = new StringTokenizer(in.readLine());
		}
		return tk.nextToken();
	}

	public static void close() throws IOException {
		in.close();
		out.close();
	}
}
