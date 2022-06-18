package Y2022BFinal;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class D {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static char[][] g;
	private static int[] pri;

	static class Window {
		int top, left, height, width;
		boolean isActive = true;

		public Window(int top, int left, int height, int width) {
			this.top = top;
			this.left = left;
			this.height = height;
			this.width = width;
		}
	}

	public static void main(String[] args) throws IOException {
		int n = nextInt(), m = nextInt();
		g = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				g[i][j] = '.';
			}
		}
		int q = nextInt();
		pri = new int[q];
		Map<Integer, Window> map = new HashMap<>();
		for (int i = 0; i < q; i++) {
			String op = next();
			int pid = nextInt();
			if ("new".equals(op)) {
				Window w = new Window(nextInt(), nextInt(), nextInt(), nextInt());
				map.put(pid, w);

			} else if ("resize".equals(op)) {
				Window w = map.get(pid);
				int top = w.top, left = w.left, height = nextInt(), width = nextInt();
				map.put(pid, new Window(top, left, height, width));

			} else if ("move".equals(op)) {
				Window w = map.get(pid);
				int top = w.top + nextInt(), left = w.left + nextInt(), height = w.height, width = w.width;
				map.put(pid, new Window(top, left, height, width));

			} else if ("close".equals(op)) {
				map.get(pid).isActive = false;

			} else if ("active".equals(op)) {
				map.get(pid).isActive = true;
			}
			for (int j = 0; j < q; j++) {
				if (pri[j] == pid) {
					pri[j] = 0;
					break;
				}
			}
			pri[i] = pid;
		}

		for (int pid : pri) {
			if (pid == 0) {
				continue;
			}
			Window w = map.get(pid);
			if (!w.isActive) {
				continue;
			}
			int top = w.top, left = w.left, height = w.height, width = w.width;
			int x1 = top, x2 = top + height - 1, y1 = left, y2 = left + width - 1;
			int xr = Math.min(n - 1, x2), yr = Math.min(m - 1, y2);
			for (int i = x1; i <= xr; i++) {
				for (int j = y1; j <= yr; j++) {
					if ((i == x1 && j == y1) || (i == x1 + height - 1 && j == y1) || (i == x1 && j == y1 + width - 1) || (i == x2 && j == y2)) {
						g[i][j] = '+';
					} else if (i == x1 || i == x2) {
						g[i][j] = '-';
					} else if (j == y1 || j == y2) {
						g[i][j] = '|';
					} else {
						g[i][j] = ' ';
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
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
