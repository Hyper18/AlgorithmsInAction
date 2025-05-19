package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2025/05/19
 * @file M3024_三角形类型.java
 * <p>
 * 思路
 * 模拟
 */
public class M3024_三角形类型 {
    public String triangleType(int[] nums) {
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        }
        if (nums[0] + nums[1] > nums[2] && nums[0] + nums[2] > nums[1] && nums[1] + nums[2] > nums[0]) {
            if (nums[0] == nums[1] || nums[0] == nums[2] || nums[1] == nums[2]) {
                return "isosceles";
            }
            return "scalene";
        }

        return "none";
    }

    public String triangleType2(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0], b = nums[1], c = nums[2];
        if (a + b <= c) {
            return "none";
        }
        if (a == c) {
            return "equilateral";
        }
        if (a == b || b == c) {
            return "isosceles";
        }

        return "scalene";
    }
}
