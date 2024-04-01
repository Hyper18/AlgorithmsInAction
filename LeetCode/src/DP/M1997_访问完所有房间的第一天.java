package DP;

/**
 * @author Hyperspace
 * @date 2024/03/28
 * @file M1997_访问完所有房间的第一天.java
 * <p>
 * 思路
 * 前缀和，DP
 * 1. 状态表示
 * 集合：f[i]为第一次到达房间i需要的天数
 * 属性：cnt
 * 2. 状态计算
 * 对区间[j, i - 1]
 * f[i] = 2 + pre[i] - pre[j]
 * +2：从i-1到nextVisit[i-1]，最后从i-1到i
 * <p>
 * 注意取模避免负数，f中后面的天数值可能更小
 */
public class M1997_访问完所有房间的第一天 {
    final long MOD = 1_000_000_007;

    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        long[] pre = new long[n];
        for (int i = 0; i < n - 1; i++) {
            pre[i + 1] = (2 + pre[i] * 2 - pre[nextVisit[i]] + MOD) % MOD;
        }

        return (int) pre[n - 1];
    }
}
