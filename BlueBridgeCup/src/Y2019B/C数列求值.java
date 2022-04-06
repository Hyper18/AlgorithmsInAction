package Y2019B;

/**
 * @author Hyperspace
 * @date 2022/04/06
 */
public class C数列求值 {
    private static int[] dp = new int[20190324 + 10];

    public static void main(String[] args) {
        dp[1] = dp[2] = dp[3] = 1;
        for (int i = 4; i <= 20190324; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 10000;
        }

        System.out.println(dp[20190324]);
    }
}
