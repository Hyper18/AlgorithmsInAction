package Y2022B;

import java.io.*;
import java.util.StringTokenizer;

public class F {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static int[][] grid;

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		int m = nextInt();
		grid = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = nextInt();
			}
		}
		int limit = nextInt();

		int origin_n = n;
		int origin_m = m;
		int n_diff = 0;
		int m_diff = 0;
		while (true) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			if (n_diff != 0 || m_diff != 0) {
				for (int p = 0; p <= n_diff; p++) {
					for (int q = 0; q <= m_diff; q++) {
						max = Integer.MIN_VALUE;
						min = Integer.MAX_VALUE;
						for (int i = p; i < n + p; i++) {
							for (int j = q; j < m + q; j++) {
								if (grid[i][j] > max) {
									max = grid[i][j];
								}
								if (grid[i][j] < min) {
									min = grid[i][j];
								}
							}
						}
						if (max - min <= limit) {
							out.print(m * n);
							close();
							return;
						}
					}
				}
			} else {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if (grid[i][j] > max) {
							max = grid[i][j];
						}
						if (grid[i][j] < min) {
							min = grid[i][j];
						}
					}
				}
				if (max - min <= limit) {
					out.print(m * n);
					close();
					return;
				}
			}

			if (m >= n) {
				m--;
				m_diff++;
			} else {
				n--;
				n_diff++;
			}
		}
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
