package DP.StMachineModel;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/12
 * 打家劫舍问题 - 无环版
 * 10min内，一遍AC
 * <p>
 * 1. 状态表示
 * 集合：
 * f[i][0]表示前i-1家店所能获取的最大金额
 * f[i][1]表示前i家店所能获取的最大金额
 * 属性：所能获取的最大金额Max
 * 2. 状态计算
 * 1）选取当前第i间店铺 f[i][1] = f[i - 1][0] + a[i]
 * 2）不选当前第i间店铺 f[i][0] = max(f[i - 1][0], f[i - 1][1])
 */
public class Q1049_大盗阿福 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100000 + 10;
    private static int[][] f = new int[N][2];

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        while (t-- > 0) {
            int n = nextInt();
            for (int i = 1; i <= n; i++) {
                f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
                f[i][1] = f[i - 1][0] + nextInt();
            }
            out.println(Math.max(f[n][0], f[n][1]));
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
