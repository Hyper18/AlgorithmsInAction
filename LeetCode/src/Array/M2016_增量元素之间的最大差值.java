package Array;

/**
 * @author Hyperspace
 * @date 2022/02/26
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
        int max = -1;
        int n = nums.length;
        int pre = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > pre) {
                max = Math.max(max, nums[i] - pre);
            } else {
                pre = nums[i];
            }
        }

        return max;
    }
}
