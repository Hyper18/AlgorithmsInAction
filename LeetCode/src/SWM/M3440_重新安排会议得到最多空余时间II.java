package SWM;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2025/07/10
 * @file M3440_重新安排会议得到最多空余时间II.java
 * <p>
 * 思路
 * SWM+前缀和+后缀和 -- O(n)
 * 定长滑窗
 * 多了一个所移动时间段能否被塞下的判断
 */
public class M3440_重新安排会议得到最多空余时间II {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] free = new int[n + 1];
        free[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            free[i] = startTime[i] - endTime[i - 1];
        }
        free[n] = eventTime - endTime[n - 1];
        int[] lMax = new int[n], rMax = new int[n];
        Arrays.fill(lMax, Integer.MIN_VALUE);
        Arrays.fill(rMax, Integer.MIN_VALUE);
        lMax[0] = free[0];
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(lMax[i - 1], free[i]);
        }
        rMax[n - 1] = free[n];
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], free[i + 1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, free[i] + free[i + 1]);
            int l = i >= 1 ? lMax[i - 1] : -1, r = i + 1 < n ? rMax[i + 1] : -1;
            int diff = endTime[i] - startTime[i];
            if (l >= diff || r >= diff) {
                ans = Math.max(ans, free[i] + diff + free[i + 1]);
            }
        }

        return ans;
    }
}
