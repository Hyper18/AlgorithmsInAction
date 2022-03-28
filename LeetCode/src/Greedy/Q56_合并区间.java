package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2022/03/28
 */
public class Q56_合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            int last = res.size() - 1;
            if (res.size() == 0 || res.get(last)[1] < left) {
                res.add(new int[]{left, right});
            } else {
                res.get(last)[1] = Math.max(res.get(last)[1], right);
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int n = intervals.length;
        int[][] res = new int[n][2];
        int idx = -1;
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            if (idx == -1 || res[idx][1] < left) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(res[idx][1], right);
            }
        }

        return Arrays.copyOf(res, idx + 1);
    }
}
