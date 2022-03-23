package Y2015B;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/23
 * 无根图转化为有根图
 * 实际上可以把问题转化为一个树形动态规划问题
 * 因此，实际上必须使用dfs来拆解当前问题为更小的子问题
 * 从而递归地解决本问题
 * 50/100
 */
public class PREV_173 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tk = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static List<Integer>[] g;
	private static long[] w;
	static int n;
	static long ans;

	public static void main(String[] args) throws IOException {
		n = nextInt();
		w = new long[n + 1];
		initG();
		for (int i = 1; i <= n; i++) {
			w[i] = nextLong();
		}
		for (int i = 0; i < n - 1; i++) {
			int u = nextInt();
			int v = nextInt();
			g[u].add(v);
			g[v].add(u);
		}

		dfs(1, 0);

		out.println(ans);

		close();
	}

	private static void dfs(int u, int v) {
		for (int i = 0; i < g[u].size(); i++) {
			int child = g[u].get(i);
			if (child == v) {
				continue;
			}
			dfs(child, u);
			if (w[child] > 0) {
				w[u] += w[child];
			}
		}
		if (w[u] > ans) {
			ans = w[u];
		}
	}

	private static void initG() {
		g = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			g[i] = new ArrayList<>();
		}
	}

	private static int nextInt() throws IOException {
		while (!tk.hasMoreTokens()) {
			tk = new StringTokenizer(in.readLine());
		}
		return Integer.parseInt(tk.nextToken());
	}

	private static long nextLong() throws IOException {
		while (!tk.hasMoreTokens()) {
			tk = new StringTokenizer(in.readLine());
		}
		return Long.parseLong(tk.nextToken());
	}


	private static void close() throws IOException {
		in.close();
		out.close();
	}
}
