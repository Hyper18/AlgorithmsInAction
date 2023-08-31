package TwoPointer;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2023/07/10
 * @file M16_最接近的三数之和.java
 */
public class M16_最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0, diff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int minSum = nums[i] + nums[i + 1] + nums[i + 2];
            if (minSum > target) {
                if (minSum - target < diff) {
                    ans = minSum;
                }
                break;
            }
            int maxSum = nums[i] + nums[n - 1] + nums[n - 2];
            if (maxSum < target) {
                if (target - maxSum < diff) {
                    diff = target - maxSum;
                    ans = maxSum;
                }
                continue;
            }
            int low = i + 1, high = n - 1;
            while (low < high) {
                int s = nums[i] + nums[low] + nums[high];
                if (s == target) {
                    return target;
                }
                if (s > target) {
                    if (s - target < diff) {
                        diff = s - target;
                        ans = s;
                    }
                    high--;
                } else {
                    if (target - s < diff) {
                        diff = target - s;
                        ans = s;
                    }
                    low++;
                }
            }
        }

        return ans;
    }
}
