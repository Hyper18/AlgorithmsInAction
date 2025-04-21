package Array;

/**
 * @author Hyperspace
 * @date 2025/04/21
 * @file M2145_统计隐藏数组数目.java
 * <p>
 * 思路
 * 模拟，前缀和
 * 本质是在一个给定的较大区间内，
 * 找可能的小区间的起始和结束位置
 */
public class M2145_统计隐藏数组数目 {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int mn = 0, mx = 0, cnt = 0, len = upper - lower + 1;
        for (int diff : differences) {
            cnt += diff;
            if (Math.abs(diff) > len || Math.abs(cnt) > len) {
                return 0;
            }
            if (cnt < mn) {
                mn = cnt;
            }
            if (cnt > mx) {
                mx = cnt;
            }
        }

        return mx - mn > len ? 0 : len - mx + mn;
    }
}
