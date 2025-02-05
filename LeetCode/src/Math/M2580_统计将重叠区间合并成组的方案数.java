package Math;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Hyper
 * @date 2024/03/27
 * @file M2580_统计将重叠区间合并成组的方案数.java
 * <p>
 * 思路
 * 模拟求方案数，按照左端点顺序升序排序
 * 考虑最简单的情况，如果n个集合互相无交集
 * 则总的方案数为2^n
 * <p>
 * 维护一个现在区间交集的右端点cur
 * 如果目前比cur小，则现在的区间和前一个存在交集，更新cur
 * 否则收集结果，移动到新的端点
 */
public class M2580_统计将重叠区间合并成组的方案数 {
    final int MOD = (int) 1e9 + 7;

    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        int cur = -1, ans = 1;
        for (int[] range : ranges) {
            int l = range[0], r = range[1];
            if (l <= cur) {
                cur = Math.max(cur, r);
            } else {
                ans = ans * 2 % MOD;
                cur = r;
            }

        }

        return ans;
    }
}
