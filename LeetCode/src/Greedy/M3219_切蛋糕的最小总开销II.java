package Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2024/12/25
 * @file M3219_切蛋糕的最小总开销II.java
 * <p>
 * 思路
 * 同3218
 */
public class M3219_切蛋糕的最小总开销II {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < m - 1; i++) {
            q.offer(new int[]{horizontalCut[i], 0});
        }
        for (int j = 0; j < n - 1; j++) {
            q.offer(new int[]{verticalCut[j], 1});
        }
        int hCnt = 1, vCnt = 1;
        long ans = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int cost = p[0], isVertical = p[1];
            if (isVertical == 0) {
                ans += (long) cost * hCnt;
                vCnt++;
            } else {
                ans += (long) cost * vCnt;
                hCnt++;
            }
        }

        return ans;
    }

    public long minimumCost2(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int l = m - 2, r = n - 2, hCnt = 1, vCnt = 1;
        long ans = 0;
        while (l >= 0 || r >= 0) {
            if (r < 0 || (l >= 0 && horizontalCut[l] > verticalCut[r])) {
                ans += (long) horizontalCut[l--] * hCnt;
                vCnt++;
            } else {
                ans += (long) verticalCut[r--] * vCnt;
                hCnt++;
            }
        }

        return ans;
    }
}
