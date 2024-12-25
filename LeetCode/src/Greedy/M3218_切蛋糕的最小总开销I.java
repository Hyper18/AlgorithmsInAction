package Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2024/12/25
 * @file M3218_切蛋糕的最小总开销I.java
 * <p>
 * 思路
 * 1. 贪心+优先队列
 * 2. 优化 双指针
 */
public class M3218_切蛋糕的最小总开销I {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < m - 1; i++) {
            q.offer(new int[]{horizontalCut[i], 0});
        }
        for (int j = 0; j < n - 1; j++) {
            q.offer(new int[]{verticalCut[j], 1});
        }
        int hCnt = 1, vCnt = 1, ans = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int cost = p[0], isVertical = p[1];
            if (isVertical == 0) {
                ans += cost * hCnt;
                vCnt++;
            } else {
                ans += cost * vCnt;
                hCnt++;
            }
        }

        return ans;
    }

    public int minimumCost2(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int l = m - 2, r = n - 2, hCnt = 1, vCnt = 1, ans = 0;
        while (l >= 0 || r >= 0) {
            if (r < 0 || (l >= 0 && horizontalCut[l] > verticalCut[r])) {
                ans += horizontalCut[l--] * hCnt;
                vCnt++;
            } else {
                ans += verticalCut[r--] * vCnt;
                hCnt++;
            }
        }

        return ans;
    }
}
