package Greedy;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2025/07/13
 * @file M2410_运动员和训练师的最大匹配数.java
 * <p>
 * 思路
 * 贪心
 */
public class M2410_运动员和训练师的最大匹配数 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int m = players.length, n = trainers.length;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int ans = 0;
        for (int i = 0, j = 0; i < Math.min(m, n); i++, j++) {
            while (j < n && players[i] > trainers[j]) {
                j++;
            }
            if (j < n) {
                ans++;
            }
        }

        return ans;
    }
}
