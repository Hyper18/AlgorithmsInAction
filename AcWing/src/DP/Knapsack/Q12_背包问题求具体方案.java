package DP.Knapsack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/12
 * <p>
 * 思路 求背包问题的方案数
 * 分析：输出方案 其实就是输出方案的 转移路径
 * 如果出现 分叉转移，我们就优先 选 当前物品
 * 以使得输出的 字典序最小
 * <p>
 * 1. 状态表示
 * 集合：对前i件物品，当背包的容积为j时所能装入的最大价值
 * 属性：Max
 * 2. 状态计算
 * 1）不选 f[i][j] = f[i + 1][j]（沿用上一层的状态）
 * 2）选取 f[i][j] = max(f[i][j], f[i + 1][j - v[i]] + w[i])（更新当前的Max）
 */
public class Q12_背包问题求具体方案 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000 + 10;
    private static int[] v = new int[N], w = new int[N];
    private static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = nextInt();
            w[i] = nextInt();
        }
        // 因为最后一件物品存储的是最终状态，所以从最后一件物品进行循环
        for (int i = n; i >= 1; i--) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i + 1][j];
                if (v[i] > j) {
                    continue;
                }
                f[i][j] = Math.max(f[i][j], f[i + 1][j - v[i]] + w[i]);
            }
        }
        int j = m;
        for (int i = 1; i <= n; i++) {
            // 选了第i件物品
            if (j >= v[i] && f[i][j] == f[i + 1][j - v[i]] + w[i]) {
                out.print(i + " ");
                j -= v[i];
            }
        }
        close();
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
