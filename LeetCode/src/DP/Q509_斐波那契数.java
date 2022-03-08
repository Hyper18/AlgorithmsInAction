package DP;

/**
 * @author Hyperspace
 * @date 2022/02/17
 * <p>
 * 思路
 * 1. DP table
 * 2. 滚动数组 + 状压DP
 */
public class Q509_斐波那契数 {
    public int fib(int n) {
        int[] dp = new int[35];
        dp[0] = 0;
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int fib2(int n) {
        if (n < 1) {
            return 0;
        }
        int pre = 1;
        int curr = 1;
        for (int i = 3; i <= n; i++) {
            int tmp = pre + curr;
            pre = curr;
            curr = tmp;
        }

        return curr;
    }
}
