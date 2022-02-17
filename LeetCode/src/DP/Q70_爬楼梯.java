package DP;

/**
 * @author Hyperspace
 * @date 2022/02/17
 * <p>
 * 1. 对重复子问题作记忆化递归
 * 2. dp table
 * 3. 状压dp
 */
public class Q70_爬楼梯 {
    private int[] cache;

    private int calWays(int n) {
        if (cache[n] != 0) {
            return cache[n];
        }
        if (n < 2) {
            return n;
        }
        cache[n] = calWays(n - 1) + calWays(n - 2);
        return cache[n];
    }

    public int climbStairs(int n) {
        cache = new int[n + 1];
        return calWays(n);
    }

    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs2_2(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs3(int n) {
        int pre = 1;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = pre + curr;
            pre = curr;
            curr = tmp;
        }
        return curr;
    }

    public int climbStairs3_2(int n) {
        if (n < 2) {
            return n;
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
