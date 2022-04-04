package Y2018A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/04/04
 * 模拟。。
 * 最后一个用例没有优化过不了
 * 83/100
 */
public class PREV_96三体攻击 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static final int MAX = 200;
	private static int[][][] grid;

	public static void main(String[] args) throws IOException {
		int A = nextInt();
		int B = nextInt();
		int C = nextInt();
		int m = nextInt();
		grid = new int[A][B][C];
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < B; j++) {
				for (int k = 0; k < C; k++) {
					grid[i][j][k] = nextInt();
				}
			}
		}
		boolean isExplode = false;
		for (int p = 0; p < m; p++) {
			int lat = nextInt() - 1;
			int rat = nextInt() - 1;
			int lbt = nextInt() - 1;
			int rbt = nextInt() - 1;
			int lct = nextInt() - 1;
			int rct = nextInt() - 1;
			int ht = nextInt();
			if (isExplode) {
				break;
			}
			for (int i = lat; i <= rat; i++) {
				if (isExplode) {
					break;
				}
				for (int j = lbt; j <= rbt; j++) {
					if (isExplode) {
						break;
					}
					for (int k = lct; k <= rct; k++) {
						if (isExplode) {
							break;
						}
						grid[i][j][k] -= ht;
						if (grid[i][j][k] < 0) {
							isExplode = true;
							out.println(p + 1);
						}
					}
				}
			}
		}

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
