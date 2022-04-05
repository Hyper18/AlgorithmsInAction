package Y2018A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/04/05
 * @time 968ms
 * <p>
 * 问题转化：
 * （a+b+c)%k=0 等价于 (a%k+b%k+c%k)%k=0
 * <p>
 * 优化：
 * 转化为01背包问题
 * w[i]：根据余数的情况0， 1， 2为背包的体积
 * dp[i][j]为选i个数，对k的余数为j对应的最大和
 * <p>
 * 待回看
 */
public class PREV_98倍数问题_2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer(" ");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAX = 100000 + 10;
    private static int[][] dp = new int[3 + 1][MAX];
    private static int[] w = new int[MAX];
    private static int[] v = new int[MAX];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int K = nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = nextInt();
            w[i] = v[i] % K;
        }
        // 枚举每个数：背包可装的物品
        for (int i = 1; i <= n; i++) {
            // 枚举余数的范围，k-1 ~ 0
            for (int j = 3 - 1; j >= 0; j--) {
                for (int k = K - 1; k >= 0; k--) {
                    // 背包可以再装入物品，更新选j+1个时dp值
                    if ((j == 0 && k == 0) || dp[j][k] != 0) {
                        dp[j + 1][(k + w[i]) % K] = Math.max(dp[j][k] + v[i], dp[j + 1][(k + w[i]) % K]);
                    }
                }
            }
        }

        out.println(dp[3][0]);

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
