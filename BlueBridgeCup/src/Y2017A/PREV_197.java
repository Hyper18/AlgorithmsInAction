package Y2017A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/31
 */
public class PREV_197 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static final int MAX = 10000 + 1;
	private static boolean[][] isPainted = new boolean[MAX][MAX];
	static int ans;

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		for (int i = 0; i < n; i++) {
			int x1 = nextInt();
			int y1 = nextInt();
			int x2 = nextInt();
			int y2 = nextInt();

			for (int j = x1; j < x2; j++) {
				for (int k = y1; k < y2; k++) {
					if (!isPainted[j][k]) {
						ans++;
						isPainted[j][k] = true;
					}
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
