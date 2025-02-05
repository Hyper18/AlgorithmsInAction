package Greedy;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/09/18
 * @file M2332_坐上公交的最晚时间.java
 * <p>
 * 思路
 * 1. 排序+贪心
 * 由题干提示知：
 * 1) 数组buses和passengers不一定是有序的，需先升序排列
 * 2) 且不能跟别的乘客同时刻到达，需要额外判断
 * <p>
 * 分类讨论：
 * 1) 有空位的情况
 * 当前车次尚未坐满，ans = t(上一班的发车时间)
 * 2) 需要挤下一人的情况
 * 当前车次已经坐满，ans = t(最后一人登车时间) - 1
 * 2. 排序+双指针
 */
public class M2332_坐上公交的最晚时间 {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        int n = buses.length, m = passengers.length;
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int ans = 0;
        for (int i = 0, j = 0; i < n; i++) {
            int lastBus = buses[i], cnt = 0;
            for (; j < m && cnt < capacity && passengers[j] <= lastBus; j++, cnt++) {
                if (j == 0 || passengers[j - 1] != passengers[j] - 1) {
                    ans = Math.max(ans, passengers[j] - 1);
                }
            }
            if (cnt < capacity && (j == 0 || passengers[j - 1] != lastBus)) {
                ans = Math.max(ans, lastBus);
            }
        }

        return ans;
    }

    public int latestTimeCatchTheBus2(int[] buses, int[] passengers, int capacity) {
        int n = buses.length, m = passengers.length;
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int j = 0, len = 0;
        for (int i = 0; i < n; i++) {
            int lastBus = buses[i];
            for (len = capacity; len > 0 && j < m && passengers[j] <= lastBus; len--) {
                j++;
            }
        }
        j--;
        int ans = len > 0 ? buses[n - 1] : passengers[j];
        while (j >= 0 && ans == passengers[j]) {
            ans--;
            j--;
        }

        return ans;
    }
}
