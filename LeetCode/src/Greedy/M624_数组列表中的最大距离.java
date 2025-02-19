package Greedy;

import java.util.List;

/**
 * @author Hyper
 * @date 2025/02/19
 * @file M624_数组列表中的最大距离.java
 * <p>
 * 思路
 * 贪心
 * 想比写简单的一道题
 * 核心在于题目已经排好序
 * 每次只需取出最左侧和右侧的最小、最大值进行比较
 */
public class M624_数组列表中的最大距离 {
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        int curMax = Integer.MIN_VALUE, preMax = Integer.MIN_VALUE, curMin = Integer.MAX_VALUE, preMin = Integer.MAX_VALUE;
        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < n; i++) {
            List<Integer> li = arrays.get(i);
            int t1 = li.get(0), t2 = li.get(li.size() - 1);
            if (t1 < curMin) {
                preMin = curMin;
                curMin = t1;
                idx2 = i;
            } else if (t1 < preMin) {
                preMin = t1;
            }
            if (t2 > curMax) {
                preMax = curMax;
                curMax = t2;
                idx1 = i;
            } else if (t2 > preMax) {
                preMax = t2;
            }
        }
        int diff = 0;
        if (idx1 == idx2) {
            diff = Math.min(curMax - preMax, preMin - curMin);
        }

        return curMax - curMin - diff;
    }

    public int maxDistance2(List<List<Integer>> arrays) {
        int ans = 0, mx = -10000, mn = 10000;
        for (List<Integer> li : arrays) {
            int t1 = li.get(0), t2 = li.get(li.size() - 1);
            ans = Math.max(ans, Math.max(mx - t1, t2 - mn));
            mx = Math.max(mx, t2);
            mn = Math.min(mn, t1);
        }

        return ans;
    }
}
