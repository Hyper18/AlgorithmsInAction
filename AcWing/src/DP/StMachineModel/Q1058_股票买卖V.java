package DP.StMachineModel;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/13
 * <p>
 * 分析
 * 相比于题4，主要区别在于：
 * （1）多出了一层状态，即当第i-1天进行了卖出操作后，第i天无法买入
 * --> 转化为模型，则说明f[i][2]状态只能由f[i - 1][1] + w[i]得到
 * --> f[i][0]状态应由f[i - 1][0]，f[i - 1][2]（处于冻结期）转移得到
 * --> 相似地，f[i][1]可由f[i - 1][0]（不持仓，进行了买入操作），f[i - 1][1]转移得到
 * （2）去除了一层限制，即交易次数不在成为限制条件（不设上限）
 * <p>
 * 思路
 * 1. 状态表示
 * 集合：
 * f[i][j]表示考虑前i天，当前的状态为j的方案能得到的最大利润
 * 细分而言，
 * f[i][0]表示前i天中，当前不持有股票、且不处于冷冻期，所能获取的最大利润
 * f[i][1]表示前i天中，当前持有着股票所能获取的最大利润
 * f[i][2]表示前i天中，当前不持有股票、且正处于冷冻期，所能获取的最大利润
 * 属性：Max
 * 2. 状态计算
 * f[i][0] = max(f[i - 1][0], f[i - 1][2])
 * f[i][1] = max(f[i - 1][1], f[i - 1][0] - w[i])
 * f[i][2] = f[i - 1][1] + w[i]
 */
public class Q1058_股票买卖V {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100000 + 10, INF = 0x3f3f3f3f;
    private static int[] w = new int[N];
    private static int[][] f = new int[N][3];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 1; i <= n; i++) {
            w[i] = nextInt();
        }

        // 初始化，设置边界
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], -INF);
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2]);
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - w[i]);
            f[i][2] = f[i - 1][1] + w[i];
        }

        out.println(Math.max(f[n][0], f[n][2]));

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
