package TwoPointer;

/**
 * @author Hyperspace
 * @date 2024/07/10
 * @file M2970_统计移除递增子数组的数目I.java
 * <p>
 * 思路
 * 分类讨论
 * 1. 已经为有序数组的情况，即无需调整
 * 可移除的数目为所有情况的组合
 * 2. 需要调整，双指针
 */
public class M2970_统计移除递增子数组的数目I {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int l = 0;
        while (l < n - 1 && nums[l] < nums[l + 1]) {
            l++;
        }
        if (l == n - 1) {
            return (n * (n + 1)) >> 1;
        }
        int ans = l + 2;
        for (int r = n - 1; r == n - 1 || nums[r] < nums[r + 1]; r--) {
            while (l >= 0 && nums[l] >= nums[r]) {
                l--;
            }
            ans += l + 2;
        }

        return ans;
    }
}
