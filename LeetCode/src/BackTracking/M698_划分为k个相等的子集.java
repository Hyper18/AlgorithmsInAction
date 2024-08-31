package BackTracking;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/08/25
 * @file M698_划分为k个相等的子集.java
 * <p>
 * 思路
 * 回溯
 * <p>
 * 有一个很重要的优化
 * idx > 0 && pos[idx] == pos[idx - 1]
 * 若当前元素和与上一次相同，其选法没有区别，可剪枝
 */
public class M698_划分为k个相等的子集 {
    int[] nums, pos;
    int target;
    boolean ans;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        pos = new int[k];
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        target = sum / k;
        int t;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i] >= nums[j]) {
                    t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
        backtrack(0);

        return ans;
    }

    private void backtrack(int i) {
        if (i == nums.length) {
            ans = true;
            return;
        }
        for (int idx = 0; idx < pos.length; idx++) {
            if (pos[idx] + nums[i] > target || (idx > 0 && pos[idx] == pos[idx - 1])) {
                continue;
            }
            pos[idx] += nums[i];
            backtrack(i + 1);
            pos[idx] -= nums[i];
        }
    }
}
