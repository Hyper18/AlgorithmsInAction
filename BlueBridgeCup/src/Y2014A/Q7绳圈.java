package Y2014A;

/**
 * @author Hyper
 * @date 2022/03/16
 */
public class Q7绳圈 {
    private static final int MAX = 100 + 1;

    public static void main(String[] args) {
        double[][] dp = new double[MAX][MAX];
        dp[1][1] = 1;
        for (int i = 2; i < MAX; i++) {
            for (int j = 1; j < MAX; j++) {
                if (j > i) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] * (2 * i - 2) / (2 * i - 1) + dp[i][j - 1] / (2 * i - 1);
            }
        }

        int ans = -1;
        double max = -0x3f3f3f3f;
        for (int i = 1; i < MAX; i++) {
            if (dp[100][i] > max) {
                max = dp[100][i];
                ans = i;
            }
        }

        System.out.println(ans);
    }
}
