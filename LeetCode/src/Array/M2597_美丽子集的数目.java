package Array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Hyperspace
 * @date 2025/03/07
 * @file M2597_美丽子集的数目.java
 * <p>
 * 1. 回溯
 * 核心在于利用map去掉一层for循环，并同回溯的过程结合起来
 * |a - b| = k
 * a = b + k 或 b - k
 * 2. DP@灵茶山艾府
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

    public int beautifulSubsets2(int[] nums, int k) {
        Map<Integer, TreeMap<Integer, Integer>> groups = new HashMap<>();
        for (int num : nums) {
            groups.computeIfAbsent(num % k, i -> new TreeMap<>()).merge(num, 1, Integer::sum);
        }
        int ans = 1;
        for (TreeMap<Integer, Integer> cnt : groups.values()) {
            int m = cnt.size();
            int[] f = new int[m + 1];
            f[0] = 1;
            int i = 1, pre = 0;
            for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
                int x = e.getKey(), c = e.getValue();
                if (i > 1 && x - pre == k) {
                    f[i] = f[i - 1] + f[i - 2] * ((1 << c) - 1);
                } else {
                    f[i] = f[i - 1] << c;
                }
                pre = x;
                i++;
            }
            ans *= f[m];
        }

        return ans - 1;
    }
}
