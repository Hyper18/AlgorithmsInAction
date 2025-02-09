package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Hyper
 * @date 2022/03/28，2023/08/27，2025/02/08
 * <p>
 * 思路
 * 左端点排序，模拟
 */
public class Q56_合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] in : intervals) {
            int l = in[0], r = in[1], last = res.size() - 1;
            if (res.isEmpty() || res.get(last)[1] < l) {
                res.add(new int[]{l, r});
            } else {
                res.get(last)[1] = Math.max(res.get(last)[1], r);
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] res = new int[n][2];
        int i = -1;
        for (int[] in : intervals) {
            int l = in[0], r = in[1];
            if (i == -1 || res[i][1] < l) {
                res[++i] = in;
            } else {
                res[i][1] = Math.max(res[i][1], r);
            }
        }

        return Arrays.copyOf(res, i + 1);
    }

    public int[][] merge3(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] res = new int[n][2];
        int i = -1;
        for (int[] in : intervals) {
            int l = in[0], r = in[1];
            if (i == -1 || res[i][1] < l) {
                res[++i] = in;
            } else if (res[i][1] < r) {
                res[i][1] = r;
            }
        }

        return Arrays.copyOf(res, i + 1);
    }
}
