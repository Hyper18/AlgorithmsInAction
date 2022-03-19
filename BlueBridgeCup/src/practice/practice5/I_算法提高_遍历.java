package practice.practice5;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/13 无向图，但是两边边权不同。。。
 */
class Edge {
	int start;
	int end;
	int weight;

	public Edge(int start, int end, int weight) {
		super();
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}

public class I_算法提高_遍历 {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer token = new StringTokenizer("");
	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static final int MAX = 100 + 5;
	private static Edge[] edges = new Edge[MAX];

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		int m = nextInt();
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int w = nextInt();
				if (i != j) {
					edges[idx++] = new Edge(i, j, w);
				}
			}
		}


		close();
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
