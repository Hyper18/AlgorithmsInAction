package Greedy;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/03/30
 * @file M2952_需要添加的硬币的最小数量.java
 * <p>
 * 思路
 * 贪心，排序
 * 假设[0,...,s−1]已经可以组合得到
 * 新加入一个coins[i]
 * 应当构造出[coins[i], s+coins[i]−1]内的组合
 * 分类讨论
 * 1) coins[i] ≤ s
 * 可以得到[0, s+coins[i]−1]间的所有组合
 * 2) coins[i] > s
 * 添加一个面值为s的新硬币，就可以得到[0, 2s−1]间的所有组合
 */
public class M2952_需要添加的硬币的最小数量 {
    public int minimumAddedCoins(int[] coins, int target) {
        int n = coins.length;
        Arrays.sort(coins);
        int ans = 0, i = 0, s = 1;
        while (s <= target) {
            if (i < n && coins[i] <= s) {
                s += coins[i++];
            } else {
                s <<= 1;
                ans++;
            }
        }

        return ans;
    }
}
