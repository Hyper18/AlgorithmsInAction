package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2025/03/07
 * @file M2597_美丽子集的数目.java
 * <p>
 * |a - b| = k
 * a = b + k 或 b - k
 */
public class M2597_美丽子集的数目 {
    private Map<Integer, Integer> mp = new HashMap<>();
    private int[] nums;
    private int k, ans;

    public int beautifulSubsets(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        backtrack(0);

        return ans - 1;
    }

    private void backtrack(int i) {
        if (i == nums.length) {
            ans++;
            return;
        }
        backtrack(i + 1);
        if (mp.getOrDefault(nums[i] + k, 0) == 0 && mp.getOrDefault(nums[i] - k, 0) == 0) {
            mp.merge(nums[i], 1, Integer::sum);
            backtrack(i + 1);
            mp.merge(nums[i], -1, Integer::sum);
        }
    }
}
