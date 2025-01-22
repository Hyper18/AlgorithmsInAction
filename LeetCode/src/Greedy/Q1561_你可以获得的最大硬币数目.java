package Greedy;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2025/01/22
 * @file Q1561_你可以获得的最大硬币数目.java
 * <p>
 * 思路
 * 贪心
 */
public class Q1561_你可以获得的最大硬币数目 {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        Arrays.sort(piles);
        int ans = 0;
        for (int l = 0, r = n - 1; l < r - 1; l++, r -= 2) {
            ans += piles[r - 1];
        }

        return ans;
    }

    public int maxCoins2(int[] piles) {
        int n = piles.length;
        Arrays.sort(piles);
        int ans = 0;
        for (int i = 0, r = n - 2; i < n / 3; i++, r -= 2) {
            ans += piles[r];
        }

        return ans;
    }
}
