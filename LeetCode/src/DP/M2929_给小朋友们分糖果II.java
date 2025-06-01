package DP;

/**
 * @author Hyperspace
 * @date 2025/06/01
 * @file M2929_给小朋友们分糖果II.java
 * <p>
 * 思路
 * 模拟
 * 1. TLE
 * 2. 优化
 */
public class M2929_给小朋友们分糖果II {
    public long distributeCandies(int n, int limit) {
        long ans = 0;
        limit = Math.min(limit, n);
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= Math.min(limit, n - i); j++) {
                if (n - i - j <= limit) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public long distributeCandies2(int n, int limit) {
        long ans = 0;
        for (int i = 0; i <= Math.min(limit, n); i++) {
            if (n - i > limit * 2) {
                continue;
            }
            ans += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
        }

        return ans;
    }
}
