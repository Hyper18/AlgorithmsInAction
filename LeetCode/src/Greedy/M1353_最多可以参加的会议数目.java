package Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2025/07/07
 * @file M1353_最多可以参加的会议数目.java
 * <p>
 * 思路
 * 贪心，小根堆
 */
public class M1353_最多可以参加的会议数目 {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int ans = 0, mx = 0;
        for (int[] e : events) {
            mx = Math.max(mx, e[1]);
        }
        for (int i = 0, last = 1; last <= mx; last++) {
            while (i < n && last == events[i][0]) {
                q.offer(events[i][1]);
                i++;
            }
            while (!q.isEmpty() && q.peek() < last) {
                q.poll();
            }
            if (!q.isEmpty()) {
                q.poll();
                ans++;
            }
        }

        return ans;
    }

}
