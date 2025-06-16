package Array;

/**
 * @author Hyper
 * @date 2022/02/26，2025/06/16
 * <p>
 * 思路
 * 1. 暴力
 * 2. 前缀和
 */
public class M2016_增量元素之间的最大差值 {
    public int maximumDifference(int[] nums) {
        int max = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = Math.abs(nums[i] - nums[j]);
                if (tmp > max && nums[i] < nums[j]) {
                    max = tmp;
                }
            }
        }

        return max;
    }

    public int maximumDifference2(int[] nums) {
        int ans = -1, pre = nums[0];
        for (int num : nums) {
            if (num > pre) {
                ans = Math.max(ans, num - pre);
            } else {
                pre = num;
            }
        }

        return ans;
    }
}
