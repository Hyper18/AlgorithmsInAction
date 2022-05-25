package DP.TreeDP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/25
 * <p>
 * 思路
 * 分为两种情况：
 * 1）向上走
 * 2）向下走：经过或不经过当前结点
 * <p>
 * 此题为 换根DP 模板题。一般分为三个步骤：
 * 1）指定任意一个根节点
 * 2）一次dfs遍历，统计出当前子树内的节点对当前节点的贡献
 * 3）一次dfs遍历，统计出当前节点的父节点对当前节点的贡献，然后合并统计答案
 * <p>
 * 1. 状态表示
 * 集合：对于树中i号节点，其子节点的贡献为f1,i，父节点的贡献为 f2,i
 * 属性：Max
 * 2. 状态计算
 * up[j] = max(up[u], d2[u]) + w[i]
 * up[j] = max(up[u], d1[u]) + w[i]
 */
public class Q1073_树的中心 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = (int) 1e4 + 10, M = N * 2, INF = 0x3f3f3f3f;
    private static int[] h = new int[N], e = new int[M], ne = new int[M], w = new int[M];
    private static int[] d1 = new int[N], d2 = new int[N], parents = new int[N], up = new int[N];
    private static boolean[] isLeaf = new boolean[N];
    static int n, idx;

    private static void addEdge(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) throws IOException {
        n = nextInt();
        Arrays.fill(h, -1);
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt(), b = nextInt(), c = nextInt();
            addEdge(a, b, c);
            addEdge(b, a, c);
        }
        dfsDown(1, -1);
        dfsUp(1, -1);

        int ans = d1[1];
        for (int i = 2; i <= n; i++) {
            ans = isLeaf[i] ? Math.min(ans, up[i]) : Math.min(ans, Math.max(d1[i], up[i]));
        }
        out.println(ans);

        close();
    }

    private static int dfsDown(int u, int par) {
//        d1[u] = d2[u] = -INF; // 若含负权边，则应初始化
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == par) {
                continue;
            }

            int d = dfsDown(j, u) + w[i];
            if (d >= d1[u]) {
                d2[u] = d1[u];
                d1[u] = d;
                parents[u] = j;
            } else if (d > d2[u]) {
                d2[u] = d;
            }
        }
        // 判断当前是否为叶子结点
        if (d1[u] == -INF) {
//            d1[u] = d2[u] = 0;
            isLeaf[u] = true;
        }

        return d1[u];
    }

    private static void dfsUp(int u, int par) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == par) {
                continue;
            }

            // 判断是否走过当前结点
            if (parents[u] == j) {
                up[j] = Math.max(up[u], d2[u]) + w[i];
            } else {
                up[j] = Math.max(up[u], d1[u]) + w[i];
            }

            dfsUp(j, u);
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
