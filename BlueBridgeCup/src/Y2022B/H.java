package Y2022B;

import java.io.*;
import java.util.StringTokenizer;

public class H {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static final int MAX = 100 * 2 + 10;
	private static boolean[][] vis = new boolean[MAX][MAX];

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		String movements = next();

		int x = 100;
		int y = 100;
		vis[x][y] = true;
		for (char c : movements.toCharArray()) {
			switch (c) {
				case 'U':
					vis[x - 1][y] = true;
					x--;
					break;
				case 'D':
					vis[x + 1][y] = true;
					x++;
					break;
				case 'L':
					vis[x][y - 1] = true;
					y--;
					break;
				case 'R':
					vis[x][y + 1] = true;
					y++;
					break;
			}
		}

		int left = Integer.MAX_VALUE;
		int right = Integer.MIN_VALUE;
		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;

		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				if (vis[i][j]) {
					left = Math.min(left, i);
					right = Math.max(right, i);
					low = Math.min(low, j);
					high = Math.max(high, j);
				}
			}
		}
//		out.printf("%d %d %d %d", left, right, low, high);

		char[][] g = new char[right - left + 3][high - low + 3];
		int len1 = g.length;
		int len2 = g[0].length;
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[0].length; j++) {
				g[i][j] = '*';
			}
		}
		g[0][0] = g[len1 - 1][len2 - 1] = g[len1 - 1][0] = g[0][len2 - 1] = ' ';

		for (int i = left; i <= right; i++) {
			for (int j = low; j <= high; j++) {
				if (vis[i][j]) {
					g[i - left + 1][j - low + 1] = ' ';
				}
			}
		}

		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[0].length; j++) {
				out.print(g[i][j]);
			}
			out.println();
		}

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
