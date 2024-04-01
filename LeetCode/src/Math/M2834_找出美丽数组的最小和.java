package Math;

/**
 * @author Hyperspace
 * @date 2024/03/08
 * @file M2834_找出美丽数组的最小和.java
 * <p>
 * 思路
 * 贪心，等差数列求和
 * <p>
 * 注意MOD的另一种写法
 */
public class M2834_找出美丽数组的最小和 {
    final int MOD = (int) 1e9 + 7;
    // final int MOD = 1_000_000_007;

    public int minimumPossibleSum(int n, int target) {
        long m = Math.min(target / 2, n);
        return (int) ((m * (m + 1) + (n - m - 1 + target * 2) * (n - m)) / 2 % MOD);
    }
}
