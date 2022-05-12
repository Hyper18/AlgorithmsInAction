package DP.Knapsack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/12
 * <p>
 * 思路 分组背包问题
 * 1. 状态表示
 * 集合：f[i][j]表示考虑前i个分公司，分配j台机器所能产出的最大盈利
 * 属性：Max
 * 2. 状态计算
 * 1）不选 f[i][j] = f[i - 1][j]
 * 2）选取 f[i][j] = f[i - 1][j - k] + w[i][k]
 * <p>
 * 注：本题重点在于，得到Max后还需输出该方案下的具体情况
 * 从最后一个状态开始，当第i - 1层的价值减去价值k与现状态相同，记录之
 * 反向操作直到第1件物品（分公司）为止
 */
public class Q1013_机器分配 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 10 + 3, M = 15 + 3;
    private static int[][] w = new int[N][M], f = new int[N][M];
    private static int[] res = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                w[i][j] = nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k <= j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - k] + w[i][k]);
                }
            }
        }
        out.println(f[n][m]);

        int j = m;
        for (int i = n; i > 0; i--) {
            for (int k = 0; k <= j; k++) {
                if (f[i][j] == f[i - 1][j - k] + w[i][k]) {
                    res[i] = k;
                    j -= k;
                    break;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            out.println(i + " " + res[i]);
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
