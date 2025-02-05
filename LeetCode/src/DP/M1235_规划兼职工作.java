package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Hyper
 * @date 2022/10/22
 * <p>
 * 思路
 * 看题干是DP问题
 * <p>
 * 1. 状态表示
 * 集合：f[i]表示到第i份工作时，所能获取的最大利润
 * 属性：Max
 * 2. 状态计算
 * 1） 第i份工作不选择
 * f[i] = f[i - 1]
 * 2） 第i份工作被选择
 * f[i] = f[last] + profit[i - 1]
 * 按完成时间升序排列，依次进行
 * 上一份任务如何选到？-- 二分
 * <p>
 * 注：
 * 1. 进行的时间段不可重叠
 * 2. 恰好完成上一个任务可以直接开始下一个
 * 3. f[i]下标从1开始对应list下标从0开始
 */
public class M1235_规划兼职工作 {
    final int N = 50010;
    int[] f = new int[N];
    List<Job> jobs;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        Collections.sort(jobs);

        for (int i = 1; i <= n; i++) {
            Job job = jobs.get(i - 1);
            // init
            f[i] = Math.max(f[i - 1], job.profit);

            int last = binarySearch(0, i - 1, job.st) + 1;
            if (jobs.get(last - 1).ed > job.st) {
                continue;
            }
            f[i] = Math.max(f[i], f[last] + job.profit);
        }

        return f[n];
    }

    int binarySearch(int l, int r, int target) {
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (jobs.get(mid).ed <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return r;
    }
}

class Job implements Comparable {
    int st;
    int ed;
    int profit;

    public Job(int st, int ed, int profit) {
        this.st = st;
        this.ed = ed;
        this.profit = profit;
    }

    @Override
    public int compareTo(Object o) {
        Job job = (Job) o;
        return ed - job.ed;
    }
}
