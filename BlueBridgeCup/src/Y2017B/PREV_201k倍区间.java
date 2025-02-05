package Y2017B;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/04/02
 * <p>
 * 思路：
 * 前缀和，将每次的和储存起来，计数
 * 相当于统计了每个区间的可能情况
 * 28/100
 */
public class PREV_201k倍区间 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static int[] nums;
    private static int[][] dp;
    static int ans;

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int k = nextInt();
        nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = nextInt();
        }
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + nums[j];
                if (dp[i][j] % k == 0) {
                    ans++;
                }
            }
        }

        out.println(ans);

        close();
    }

    private static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    private static void close() throws IOException {
        in.close();
        out.close();
    }
}
