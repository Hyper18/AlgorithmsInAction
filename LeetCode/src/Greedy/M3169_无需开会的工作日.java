package Greedy;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2025/07/11
 * @file M3169_无需开会的工作日.java
 * <p>
 * 思路
 * 排序，贪心
 */
public class M3169_无需开会的工作日 {
    public static int countDays(int days, int[][] meetings) {
        int n = meetings.length;
        int ans = days;
        Arrays.sort(meetings, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int last = -1;
        for (int i = 0; i < n; i++) {
            while (i + 1 < n && meetings[i][0] == meetings[i + 1][0]) {
                i++;
            }
            ans -= meetings[i][1] - Math.max(meetings[i][0], last + 1) + 1;
            if (meetings[i][1] > last) {
                last = meetings[i][1];
            }
            while (i + 1 < n && meetings[i + 1][1] <= last) {
                i++;
            }
        }

        return ans;
    }
}
