package DP.StMachineModel;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/12
 * <p>
 * 初步思路 通过6/10测试点
 * 1. 状态表示
 * 集合：
 * f[i][j][0]表示对前i天，当交易次数为j时不持有股票，通过买卖股票所能获取的最大利润
 * f[i][j][1]表示对前i天，当交易次数为j时持有着股票，通过买卖股票所能获取的最大利润
 * 属性：Max
 * 2. 状态计算
 * 1）此时不持有股票
 * 状态转移方程可以从前一天的两种状态转移过来：
 * （1）前一天也不持有股票，对应状态为：f[i - 1][j][0]
 * （2）前一天也持有股票，然后进行了交易（卖出，不消耗交易次数），对应状态为：f[i - 1][j][1] + w[i]
 * 注：根据题目的定义可知，一笔交易包括了买入和卖出，这里选择在买入时对应状态-1
 * f[i][j][0] = max(f[i - 1][j][0], f[i - 1][j][1] + w[i])
 * 2）此时持有者股票
 * （1）前一天也持有着股票，对应状态为：f[i - 1][j][1]
 * （2）前一天不持有股票，然后进行了交易（买入，消耗了交易次数），对应状态为：f[i - 1][j - 1][0] - w[i]
 * <p>
 * 最后统计Max数目时，应只考虑当日不持有（即完成了交易）的情况并遍历之
 */
public class Q1057_股票买卖IV {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100000 + 10, M = 100 + 5, INF = 0x3f3f3f3f;
    private static int[] w = new int[N];
    private static int[][][] f = new int[N][M][2];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        for (int i = 1; i <= n; i++) {
            w[i] = nextInt();
        }

        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[0].length; j++) {
                f[i][j][0] = j == 0 ? 0 : -INF;
                f[i][j][1] = -INF;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j][0] = Math.max(f[i - 1][j][0], f[i - 1][j][1] + w[i]);
                f[i][j][1] = Math.max(f[i - 1][j][1], f[i - 1][j - 1][0] - w[i]);
            }
        }

        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans = Math.max(ans, f[n][i][0]);
        }
        out.println(ans);

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
