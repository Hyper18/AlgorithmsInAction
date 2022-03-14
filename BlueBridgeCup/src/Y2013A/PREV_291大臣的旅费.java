package Y2013A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/14
 * @time 656ms
 * 找无向图的直径
 * <p>
 * 1. 先任取一个图中结点进行深搜
 * 找到其中距离最远的结点
 * 2. 再从该结点出发，
 * 找到离该结点最远的结点
 * 3. 两者间的距离为最大距离
 * 4. 根据距离求旅费（找通项公式）
 * <p>
 * 内存优化？
 * 换用邻接表
 */
public class PREV_291大臣的旅费 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer token = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static int[][] graph;
	private static boolean[] vis;
	static int n, cityIdx = Integer.MIN_VALUE, max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		n = nextInt();
		graph = new int[n + 1][n + 1];
		vis = new boolean[n + 1];
		for (int i = 1; i < n; i++) {
			int p = nextInt();
			int q = nextInt();
			int d = nextInt();
			graph[p][q] = d;
			graph[q][p] = d;
		}

		int startIdx = 1;
		vis[startIdx] = true;
		dfs(startIdx, 0);
		vis[startIdx] = false;

		vis[cityIdx] = true;
		dfs(cityIdx, 0);

		out.println(getDistance(max));

		close();
	}

	private static void dfs(int idx, int distance) {
		if (distance > max) {
			max = distance;
			cityIdx = idx;
		}
		for (int i = 1; i <= n; i++) {
			if (!vis[i] && graph[idx][i] != 0) {
				vis[i] = true;
				distance += graph[idx][i];
				dfs(i, distance);
				distance -= graph[idx][i];
				vis[i] = false;
			}
		}
	}

	private static int getDistance(int n) {
		return n * 11 + n * (n - 1) / 2;
	}

	public static int nextInt() throws IOException {
		while (!token.hasMoreTokens()) {
			token = new StringTokenizer(in.readLine());
		}

		return Integer.parseInt(token.nextToken());
	}

	public static void close() throws IOException {
		in.close();
		out.close();
	}
}
