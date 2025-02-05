package Array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Hyper
 * @date 2024/05/18
 * @file M826_安排工作以达到最大收益.java
 * <p>
 * 思路
 * 1. 贪心，优先队列 TLE
 * 2. 贪心 优化
 */
public class M826_安排工作以达到最大收益 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int n = difficulty.length, len = worker.length;
        for (int i = 0; i < n; i++) {
            q.offer(new int[]{difficulty[i], profit[i]});
        }

        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            PriorityQueue<int[]> t = new PriorityQueue<>(q);
            while (!t.isEmpty() && worker[i] < t.peek()[0]) {
                t.poll();

            }
            if (t.isEmpty()) {
                continue;
            }
            ans += t.peek()[1];
        }

        return ans;
    }

    public int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] idxs = new int[n][2];
        for (int i = 0; i < n; i++) {
            idxs[i][0] = difficulty[i];
            idxs[i][1] = profit[i];
        }
        Arrays.sort(idxs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);
        int ans = 0, mx = 0, j = 0;
        for (int w : worker) {
            while (j < n && idxs[j][0] <= w) {
                mx = idxs[j][1] > mx ? idxs[j++][1] : mx;
            }
            ans += mx;
        }

        return ans;
    }
}
