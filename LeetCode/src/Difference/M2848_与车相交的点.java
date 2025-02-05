package Difference;

import java.util.Comparator;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/09/15
 * @file M2848_与车相交的点.java
 * <p>
 * 思路
 * 1. 区间合并
 * 核心为控制左端点，找最大可行右端点，超出时开始下一个区间
 * 2. 差分
 * 核心为统计出现次数大于1的个数
 */
public class M2848_与车相交的点 {
    public int numberOfPoints(List<List<Integer>> nums) {
        nums.sort(Comparator.comparingInt(a -> a.get(0)));
        int preL = nums.get(0).get(0), preR = nums.get(0).get(1), ans = 0;
        for (List<Integer> num : nums) {
            int l = num.get(0), r = num.get(1);
            if (preR < l) {
                ans += preR - preL + 1;
                preL = l;
                preR = r;
                continue;
            }
            preR = Math.max(preR, r);
        }
        ans += preR - preL + 1;

        return ans;
    }

    final int N = 105;
    private int[] diff = new int[N];

    public int numberOfPoints2(List<List<Integer>> nums) {
        for (List<Integer> num : nums) {
            diff[num.get(0)]++;
            --diff[num.get(1) + 1];
        }
        int ans = 0, t = 0;
        for (int d : diff) {
            t += d;
            if (t > 0) {
                ans++;
            }
        }

        return ans;
    }
}
