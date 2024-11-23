package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/11/23
 * @file M3238_求出胜利玩家的数目.java
 * <p>
 * 思路
 * 模拟
 */
public class M3238_求出胜利玩家的数目 {
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] cnt = new int[n][11];
        for (int[] p : pick) {
            cnt[p[0]][p[1]]++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int mx = Arrays.stream(cnt[i]).max().getAsInt();
            if (mx >= i + 1) {
                ans++;
            }
        }

        return ans;
    }
}
