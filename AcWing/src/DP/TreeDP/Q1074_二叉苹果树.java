package DP.TreeDP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/26
 * <p>
 * 思路
 * 1. 状态表示
 * 集合：在以i为根的子树中，选取j条边的最大价值
 * 属性：Max
 * 2. 状态计算
 * f[u][j] = max(f[u][j], f[u][j - k - 1] + f[e[i]][k] + w[i])
 */
public class Q1074_二叉苹果树 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100 + 10, M = N * 2;
    private static int[] h = new int[N], e = new int[M], ne = new int[M], w = new int[M];
    private static int[][] f = new int[N][N];
    static int idx, n, m;

    private static void addEdge(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        Arrays.fill(h, -1);
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt(), b = nextInt(), c = nextInt();
            addEdge(a, b, c);
            addEdge(b, a, c);
        }
        dfs(1, -1);
        out.println(f[1][m]);
        close();
    }

    private static void dfs(int u, int par) {
        for (int i = h[u]; i != -1; i = ne[i]) { // 物品组
            if (par == e[i]) {
                continue;
            }
            dfs(e[i], u);
            for (int j = m; j > 0; j--) { // 体积
                for (int k = 0; k + 1 <= j; k++) { // 决策
                    f[u][j] = Math.max(f[u][j], f[u][j - k - 1] + f[e[i]][k] + w[i]);
                }
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
