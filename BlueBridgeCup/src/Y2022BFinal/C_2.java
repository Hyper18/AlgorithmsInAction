package Y2022BFinal;

import java.io.*;
import java.util.StringTokenizer;

public class C_2 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static int[] p;
	static int n;

	public static void main(String[] args) throws IOException {
		n = nextInt();
		int m = nextInt();
		p = new int[n + 10];
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}

		while (m-- > 0) {
			char c = next().charAt(0);
			int x = nextInt();
			int idx = find(x);
			if (c == 'L') {
				movl(idx, x);
			} else if (c == 'R') {
				movr(idx, x);
			}
		}

		for (int i = 1; i <= n; i++) {
			if (i == n) {
				out.println(p[i]);
				break;
			}
			out.print(p[i] + " ");
		}

		close();
	}

	private static int find(int num) {
		int idx = 0;
		for (int i = 1; i <= n; i++) {
			if (p[i] == num) {
				idx = i;
				break;
			}
		}
		return idx;
	}

	private static void movl(int x, int num) {
		for (int i = x; i > 1; i--) {
			p[i] = p[i - 1];
		}
		p[1] = num;
	}

	private static void movr(int x, int num) {
		for (int i = x; i < n; i++) {
			p[i] = p[i + 1];
		}
		p[n] = num;
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
