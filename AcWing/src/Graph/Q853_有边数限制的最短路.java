package Graph;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/29
 * <p>
 * 使用场景：
 * （1）限制了边数，如题干出现字眼”最多经过k条边“
 * （2）需要处理带负权边的情况
 */
public class Q853_有边数限制的最短路 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 500 + 10, M = (int) 1e4 + 10, INF = 0x3f3f3f3f;
    private static Edge[] edges = new Edge[M];
    private static int[] d = new int[N], t = new int[N];
    static int n, m, k;

    public static class Edge {
        int a, b, c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        k = nextInt();
        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(nextInt(), nextInt(), nextInt());
        }
        bellmanFord();
        out.println(d[n] > INF / 2 ? "impossible" : d[n]);
        close();
    }

    private static void bellmanFord() {
        Arrays.fill(d, INF);
        d[1] = 0;

        for (int i = 0; i < k; i++) {
            System.arraycopy(d, 0, t, 0, N);
            for (int j = 0; j < m; j++) {
                Edge e = edges[j];
                d[e.b] = Math.min(d[e.b], t[e.a] + e.c);
            }
        }
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
