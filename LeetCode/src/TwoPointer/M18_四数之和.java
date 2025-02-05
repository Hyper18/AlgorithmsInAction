package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyper
 * @date 2023/07/15
 * @file M18_四数之和.java
 * <p>
 * 思路
 * 双指针，同Q15
 * 注意不要爆int
 */
public class M18_四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (j < n - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                int l = i + 1, r = j - 1;
                while (l < r) {
                    long sum = (long) nums[i] + nums[l] + nums[r] + nums[j];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r], nums[j]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return res;
    }
}
