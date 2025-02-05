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
 * 集合
 * f[i][0]表示对前i名职员，其与直接上司一同参会的情况 -- 从所有以i为根节点的子树中选择，不选择当前结点的情况
 * f[i][1]表示对前i名职员，其不与直接上司一同参会的情况 -- 从所有以i为根节点的子树中选择，选择当前结点的情况
 * 属性：Max
 * 2. 状态计算
 * f[u][1] += f[j][0];
 * f[u][0] += Math.max(f[j][0], f[j][1]);
 */
public class Q285_没有上司的舞会 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 6000 + 10;
    private static int[] h = new int[N], e = new int[N], ne = new int[N], w = new int[N];
    private static int[][] f = new int[N][2];
    private static boolean[] hasPar = new boolean[N];
    static int n, idx;

    private static void addEdge(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) throws IOException {
        n = nextInt();
        for (int i = 1; i <= n; i++) {
            w[i] = nextInt();
        }
        Arrays.fill(h, -1);
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt(), b = nextInt();
            addEdge(b, a);
            hasPar[a] = true;
        }
        // 根据题意只有一个根结点
        int root = 1;
        while (hasPar[root]) {
            root++;
        }
        dfs(root);
        out.println(Math.max(f[root][0], f[root][1]));
        close();
    }

    private static void dfs(int u) {
        f[u][1] = w[u];
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            dfs(j);

            f[u][1] += f[j][0];
            f[u][0] += Math.max(f[j][0], f[j][1]);
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
