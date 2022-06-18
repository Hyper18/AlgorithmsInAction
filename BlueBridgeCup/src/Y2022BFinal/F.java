package Y2022BFinal;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class F {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static final int N = (int) 1e8 + 10;
	private static int[] p = new int[N];

	public static void main(String[] args) throws IOException {
		int n = nextInt(), m = nextInt();
		for (int i = 1; i <= n; i++) {
			p[i] = 1;
		}
		while (m-- > 0) {
			int k = nextInt();
			int[] tmp = new int[k * 2];
			for (int i = 0; i < k * 2; i++) {
				tmp[i] = nextInt();
			}
			char t = next().charAt(0);
			if (t == '=') {
				for (int i = 0; i < k * 2; i++) {
					p[tmp[i]]--;
				}
			} else if (t == '>') {
				Arrays.fill(p, -1);
				for (int i = k; i < k * 2; i++) {
					p[tmp[i]] = 1;
				}
			} else {
				Arrays.fill(p, -1);
				for (int i = 0; i < k; i++) {
					p[tmp[i]] = 1;
				}
			}
		}

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (p[i] > 0) {
				ans++;
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
