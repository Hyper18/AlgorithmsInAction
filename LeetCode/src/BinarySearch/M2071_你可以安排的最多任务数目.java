package BinarySearch;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Hyperspace
 * @date 2025/05/01
 * @file M2071_你可以安排的最多任务数目.java
 * <p>
 * 思路@灵茶山艾府
 * 二分+贪心
 */
public class M2071_你可以安排的最多任务数目 {
    private int[] tasks, workers;
    private int m, n, pills, strength;

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        this.tasks = tasks;
        this.workers = workers;
        m = tasks.length;
        n = workers.length;
        this.pills = pills;
        this.strength = strength;
        Arrays.sort(tasks);
        Arrays.sort(workers);

        return binarySearch(0, Math.min(m, n));
    }

    private int binarySearch(int low, int high) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (check(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private boolean check(int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int i = 0, cnt = pills;
        for (int j = n - k; j < n; j++) {
            int worker = workers[j];
            while (i < k && tasks[i] <= worker + strength) {
                q.addLast(tasks[i++]);
            }
            if (q.isEmpty()) {
                return false;
            }
            if (worker >= q.peekFirst()) {
                q.pollFirst();
                continue;
            }
            if (cnt == 0) {
                return false;
            }
            cnt--;
            q.pollLast();
        }

        return true;
    }
}
