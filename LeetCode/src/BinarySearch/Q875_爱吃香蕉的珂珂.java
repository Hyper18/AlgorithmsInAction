package BinarySearch;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2025/03/25
 * @file Q875_爱吃香蕉的珂珂.java
 * <p>
 * 思路
 * 闭区间二分 -- O(nlog_n)
 * 看到题面，就需要考虑如何从 O(n^2) 降下来
 * <p>
 * 注意ans这里爆int
 */
public class Q875_爱吃香蕉的珂珂 {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Arrays.stream(piles).max().getAsInt();
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (check(piles, mid) <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long check(int[] nums, int v) {
        long ans = 0;
        for (int num : nums) {
            ans += num % v == 0 ? num / v : (num + v - 1) / v;
        }

        return ans;
    }
}
