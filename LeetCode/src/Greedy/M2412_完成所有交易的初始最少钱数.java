package Greedy;

/**
 * @author Hyper
 * @date 2025/01/25
 * @file M2412_完成所有交易的初始最少钱数.java
 * <p>
 * 思路
 * 贪心
 */
public class M2412_完成所有交易的初始最少钱数 {
    public long minimumMoney(int[][] transactions) {
        long tot = 0, mx = 0;
        for (int[] t : transactions) {
            tot += Math.max(t[0] - t[1], 0);
            mx = Math.max(mx, Math.min(t[0], t[1]));
        }

        return tot + mx;
    }
}
