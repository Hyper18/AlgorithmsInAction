package DP.TreeDP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/25
 * <p>
 * 思路
 * 对于每一个约数x，它的和y是唯一的
 * 因此可以将y看作x的父节点
 * 逐一构建树，得到一个森林
 * <p>
 * -- 实质：树的最长路径问题
 * 做法一：素数线性筛
 * 做法二：
 * 1）任取一点a，找到该点的最远结点u
 * 2）从u出发，找到离u最远的结点为树的直径
 */
public class Q1075_数字转换 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = (int) 5e4 + 10, M = N;
    private static int[] h = new int[N], e = new int[M], ne = new int[M], sum = new int[M];
    private static boolean[] vis = new boolean[N];
    static int n, idx, ans;

    private static void addEdge(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) throws IOException {
        n = nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= n / i; j++) {
                sum[i * j] += i;
            }
        }
        Arrays.fill(h, -1);
        for (int i = 2; i <= n; i++) {
            if (sum[i] < i) {
                addEdge(sum[i], i);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs(i);
            }
        }
        out.println(ans);

        close();
    }

    private static int dfs(int u) {
        vis[u] = true;

        int dis = 0, d1 = 0, d2 = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (vis[j]) {
                continue;
            }

            int d = dfs(j);
            dis = Math.max(dis, d);
            if (d >= d1) {
                d2 = d1;
                d1 = d;
            } else if (d > d2) {
                d2 = d;
            }
        }
        ans = Math.max(ans, d1 + d2);

        return dis + 1;
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
