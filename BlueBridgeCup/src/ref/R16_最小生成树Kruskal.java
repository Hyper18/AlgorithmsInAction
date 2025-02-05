package ref;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/03/05
 */
public class R16_最小生成树Kruskal {
    private static int MAXD = 100007;
    private static int INF = 0x3f3f3f3f;
    private static int[] parent = new int[MAXD];
    private static Edge[] edges = new Edge[MAXD * 2];
    private static int n;

    public static class Edge implements Comparable<Edge> {
        private int u;
        private int v;
        private int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        n = in.nextInt();
        int m = in.nextInt();

        init(n, m);
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
            edges[i] = new Edge(a, b, w);
        }

        int ans = kruskal(m);

        out.println(ans == INF ? "Not Found" : ans);

        in.close();
        out.close();
    }

    private static void init(int n, int m) {
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    private static int find(int key) {
        while (key != parent[key]) {
            key = parent[key];
        }

        return key;
    }

    private static void join(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);

        if (root1 != root2) {
            parent[root1] = root2;
        }
    }

    private static int kruskal(int m) {
        int res = 0;
        // 记录边的数目
        int cnt = 0;
        Arrays.sort(edges, 0, m);
        for (int i = 0; i < m; i++) {
            int u = edges[i].u;
            int v = edges[i].v;
            int w = edges[i].w;

            if (find(u) != find(v)) {
                join(u, v);
                res += w;
                cnt++;
            }
        }

        return cnt < n - 1 ? INF : res;
    }
}
