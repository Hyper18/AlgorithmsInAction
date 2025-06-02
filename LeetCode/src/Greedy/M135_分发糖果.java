package Greedy;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2025/06/02
 * @file M135_分发糖果.java
 * <p>
 * 思路
 * 贪心
 */
public class M135_分发糖果 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] diff = new int[n];
        Arrays.fill(diff, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                diff[i] = diff[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                diff[i] = Math.max(diff[i], diff[i + 1] + 1);
            }
        }
        int ans = 0;
        for (int x : diff) {
            ans += x;
        }

        return ans;
    }
}
