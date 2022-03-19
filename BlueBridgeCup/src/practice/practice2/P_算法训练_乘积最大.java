package practice.practice2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/07
 * @time 109ms
 * 动态规划
 */
public class P_算法训练_乘积最大 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int k = nextInt();
        String str = nextString();
        int[][] nums = new int[n + 2][n + 1];
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i][i] = Integer.parseInt(String.valueOf(str.charAt(i - 1)));
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                nums[i][j] = nums[i][j - 1] * 10 + nums[j][j];
            }
            nums[n + 1][i] = 1;
        }

        System.arraycopy(nums[1], 0, dp[0], 0, n + 1);

        for (int i = 1; i <= k; i++) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = 1;
                for (int l = i; l < j; l++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][l] * nums[l + 1][j]);
                }
            }
        }

        out.println(dp[k][n]);

        close();
    }

    public static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(token.nextToken());
    }

    public static String nextString() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return token.nextToken();
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
