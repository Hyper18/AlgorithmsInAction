package Array;

/**
 * @author Hyperspace
 * @date 2024/09/23
 * @file M1014_最佳观光组合.java
 * <p>
 * 思路
 * 1. 模拟 TLE
 * 2. 优化 拆为两部分
 */
public class M1014_最佳观光组合 {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.max(ans, values[i] + values[j] + i - j);
            }
        }

        return ans;
    }

    public int maxScoreSightseeingPair2(int[] values) {
        int n = values.length;
        int ans = 0, mx = values[0];
        for (int j = 1; j < n; j++) {
            ans = Math.max(ans, mx + values[j] - j);
            mx = Math.max(mx, values[j] + j);
        }

        return ans;
    }
}
