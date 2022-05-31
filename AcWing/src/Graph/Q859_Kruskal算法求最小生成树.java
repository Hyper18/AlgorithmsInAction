package Graph;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/31
 */
public class Q859_Kruskal算法求最小生成树 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static int N = (int) 1e5 + 10, M = N * 2, INF = 0x3f3f3f3f;
    private static int[] p = new int[N];
    private static Edge[] edges = new Edge[M];
    static int n, m;

    static class Edge implements Comparable<Edge> {
        int a, b, c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return c - o.c;
        }
    }

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        for (int i = 0; i < m; i++) {
            int a = nextInt(), b = nextInt(), c = nextInt();
            edges[i] = new Edge(a, b, c);
        }
        int ans = kruskal();
        out.println(ans == INF ? "impossible" : ans);
        close();
    }

    private static int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private static int kruskal() {
        Arrays.sort(edges, 0, m);
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }

        int ans = 0, cnt = 0;
        for (int i = 0; i < m; i++) {
            int a = edges[i].a, b = edges[i].b, c = edges[i].c;
            a = find(a);
            b = find(b);
            if (a != b) {
                p[a] = b;
                ans += c;
                cnt++;
            }
        }

        return cnt < n - 1 ? INF : ans;
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
