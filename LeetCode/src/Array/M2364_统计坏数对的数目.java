package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2025/04/18
 * @file M2364_统计坏数对的数目.java
 * <p>
 * 思路
 * 哈希
 */
public class M2364_统计坏数对的数目 {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += i - mp.getOrDefault(nums[i] - i, 0);
            mp.merge(nums[i] - i, 1, Integer::sum);
        }

        return ans;
    }
}
