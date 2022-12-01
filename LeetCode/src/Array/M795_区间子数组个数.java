package Array;

/**
 * @author Hyperspace
 * @date 2022/11/24
 * @file M795_区间子数组个数.java
 * <p>
 * 思路
 * 双指针，区间计数
 */
public class M795_区间子数组个数 {
    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        // r初值不能赋0，原因nums[0]不一定 >= left
        int l = 0, r = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > right) {
                l = i + 1;
            }
            if (nums[i] >= left) {
                r = i;
            }
            ans += r - l + 1;
        }

        return ans;
    }
}
