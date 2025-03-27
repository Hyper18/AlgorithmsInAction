package Greedy;

/**
 * @author Hyperspace
 * @date 2025/03/27
 * @file M2712_使所有字符相等的最小成本.java
 * <p>
 * 思路
 * 贪心
 */
public class M2712_使所有字符相等的最小成本 {
    public long minimumCost(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        long ans = 0;
        for (int i = 1; i < n; i++) {
            if (cs[i - 1] != cs[i]) {
                ans += Math.min(i, n - i);
            }
        }

        return ans;
    }
}
