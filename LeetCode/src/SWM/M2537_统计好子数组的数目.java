package SWM;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2025/04/17
 * @file M2537_统计好子数组的数目.java
 * <p>
 * 思路
 * SWM
 */
public class M2537_统计好子数组的数目 {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        long ans = 0;
        for (int l = 0, r = 0, cnt = 0; r < n; r++) {
            cnt += mp.merge(nums[r], 1, Integer::sum) - 1;
            while (cnt >= k) {
                cnt -= mp.merge(nums[l++], -1, Integer::sum);
            }
            ans += l;
        }

        return ans;
    }
}
