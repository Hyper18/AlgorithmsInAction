package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2023/08/28
 * @file M57_插入区间.java
 * <p>
 * 思路
 * 1. 复用一下，乐
 * 2. 二分
 * <p>
 * 待回看
 */
public class M57_插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] mergeIntervals = new int[n + 1][2];
        System.arraycopy(intervals, 0, mergeIntervals, 0, n);
        mergeIntervals[n] = newInterval;

        return merge(mergeIntervals);
    }

    private int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] res = new int[n][2];
        int idx = -1;
        for (int[] i : intervals) {
            int l = i[0], r = i[1];
            if (idx == -1 || res[idx][1] < l) {
                res[++idx] = i;
            } else {
                res[idx][1] = Math.max(res[idx][1], r);
            }
        }

        return Arrays.copyOf(res, idx + 1);
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int x = newInterval[0], y = newInterval[1];
        int low = 0, high = n, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (intervals[mid][1] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int st = high - 1;
        low = 0;
        high = n;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (intervals[mid][0] > y) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        int ed = low;
        int[][] res = new int[(st + 1) + 1 + (n - ed)][2];
        int idx = 0;
        for (int i = 0; i <= st; i++) {
            res[idx++] = intervals[i];
        }
        res[idx][0] = Math.min(x, st + 1 < n ? intervals[st + 1][0] : x);
        res[idx++][1] = Math.max(y, ed - 1 >= 0 ? intervals[ed - 1][1] : y);
        for (int i = ed; i < n; i++) {
            res[idx++] = intervals[i];
        }

        return res;
    }
}
