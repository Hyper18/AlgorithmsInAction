package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/08/28
 */
public class M1464_数组中两元素的最大乘积 {
    public int maxProduct(int[] nums) {
        // 暴力
        int len = nums.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int tmp = (nums[i] - 1) * (nums[j] - 1);
                if (tmp > ans) {
                    ans = tmp;
                }
            }
        }

        return ans;
    }

    public int maxProduct2(int[] nums) {
        // 快排得到最大两数
        int len = nums.length;
        Arrays.sort(nums);
        return (nums[len - 1] - 1) * (nums[len - 2] - 1);
    }

    public int maxProduct3(int[] nums) {
        // 用a和b分别维护最大和次大值
        int a = nums[0], b = nums[1], len = nums.length;
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        for (int i = 2; i < len; i++) {
            if (nums[i] > a) {
                b = a;
                a = nums[i];
            } else if (nums[i] > b) {
                b = nums[i];
            }
        }

        return (a - 1) * (b - 1);
    }
}
