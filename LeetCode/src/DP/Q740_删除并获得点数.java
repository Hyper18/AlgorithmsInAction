package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2022/03/08
 * 1. hash
 * 2. array
 * 由于本题限制了数据上限10^4，因此可以直接用数组代替计数
 * <p>
 * dp -- O(n)
 * dp[i][0] 代表数值i不被选择的最大价值
 * dp[i][1] 代表数值i被选择的最大价值
 * i的上限为max
 */
public class Q740_删除并获得点数 {
    private final int MAX = 10000 + 5;
    private int[] cnt = new int[MAX];

    public int deleteAndEarn2(int[] nums) {
        int max = 0;
        for (int num : nums) {
            cnt[num]++;
            max = max(max, num);
        }

        int[][] dp = new int[max + 1][2];
        for (int i = 1; i <= max; i++) {
            dp[i][1] = dp[i - 1][0] + i * cnt[i];
            dp[i][0] = max(dp[i - 1][1], dp[i - 1][0]);
        }

        return max(dp[max][0], dp[max][1]);
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = max(max, num);
        }

        int[][] dp = new int[max + 1][2];
        for (int i = 1; i <= max; i++) {
            dp[i][1] = dp[i - 1][0] + i * map.getOrDefault(i, 0);
            dp[i][0] = max(dp[i - 1][1], dp[i - 1][0]);
        }

        return max(dp[max][0], dp[max][1]);
    }
}
