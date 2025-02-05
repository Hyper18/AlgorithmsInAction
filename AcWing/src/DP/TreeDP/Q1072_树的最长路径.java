package DP.TreeDP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/24
 * <p>
 * 思路
 * 通过数组建立邻接链表
 * 先取树上的任意一个结点a，找距离该结点最远的结点u
 * 再从该结点u出发，找其最远的结点，两者之间的距离即为树的直径
 */
public class Q1072_树的最长路径 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = (int) 1e5 + 10, M = N * 2;
    private static int[] h = new int[N], e = new int[M], ne = new int[M], w = new int[M];
    private static boolean[] vis = new boolean[N];
    static int n, idx, ans;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        Arrays.fill(h, -1);
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt(), b = nextInt(), c = nextInt();
            addEdge(a, b, c);
            addEdge(b, a, c);
        }
        dfs(1);
        out.println(ans);
        close();
    }

    private static int dfs(int u) {
        vis[u] = true;

        int dis = 0, seg1 = 0, seg2 = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (vis[j]) {
                continue;
            }

            int d = dfs(j) + w[i];
            dis = Math.max(dis, d);

            if (d >= seg1) {
                seg2 = seg1;
                seg1 = d;
            } else if (d > seg2) {
                seg2 = d;
            }
        }
        ans = Math.max(ans, seg1 + seg2);

        return dis;
    }

    private static void addEdge(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
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
