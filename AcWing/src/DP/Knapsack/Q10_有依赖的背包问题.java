package DP.Knapsack;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/26
 */
public class Q10_有依赖的背包问题 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100 + 10, M = N;
    private static int[] v = new int[M], w = new int[M];
    private static int[] h = new int[N], e = new int[M], ne = new int[M];
    private static int[][] f = new int[N][N];
    static int idx, n, m;

    private static void addEdge(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        Arrays.fill(h, -1);
        int root = 0;
        for (int i = 1; i <= n; i++) {
            v[i] = nextInt();
            w[i] = nextInt();
            int p = nextInt();
            // 判断当前结点是否为根节点
            if (p == -1) {
                root = i;
            } else {
                addEdge(p, i);
            }
        }
        dfs(root);
        out.println(f[root][m]);
        close();
    }

    private static void dfs(int u) {

        for (int i = h[u]; i != -1; i = ne[i]) { // 物品
            dfs(e[i]);

            // 分组背包
            for (int j = m - v[u]; j >= 0; j--) { // 体积
                for (int k = 0; k <= j; k++) { // 决策
                    f[u][j] = Math.max(f[u][j], f[u][j - k] + f[e[i]][k]);
                }
            }
        }

        // 往背包装入物品
        for (int i = m; i >= v[u]; i--) {
            f[u][i] = f[u][i - v[u]] + w[u];
        }
        for (int i = 0; i < v[u]; i++) {
            f[u][i] = 0;
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
