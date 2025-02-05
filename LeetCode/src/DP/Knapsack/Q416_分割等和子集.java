package DP.Knapsack;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/03/19
 * 01背包问题
 * 首先找dp含义
 * 对原模型
 * dp[i][j]表示
 * 外层循环表示从0 ~ i遍历物品
 * 内层循环表示从背包容量 ~ 能装入最小物品的容量
 * <p>
 * 而对于本问题，背包容量为数组所有元素和的一半
 * 结合“两个子集的元素和相等”的描述，为恰等于背包容量
 * <p>
 * 还可以直接把dp设为boolean数组，以压缩空间占用
 * 初始化dp[j = 0]
 * <p>
 * 注意i应对齐物品的下标
 * <p>
 * 还可以对时间复杂度做进一步优化：
 * 当数组中的最大数仍比half大（大于背包容量）时
 * 直接返回false
 */
public class Q416_分割等和子集 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        int[] dp = new int[half + 1];
        for (int i = 0; i < n; i++) {
            for (int j = half; nums[i] <= j; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        if (dp[half] == half) {
            return true;
        }

        return false;
    }

    public boolean canPartition2(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = half; nums[i] <= j; j--) {
                dp[j] = dp[j] | dp[j - nums[i]];
            }
        }

        return dp[half];
    }

    public boolean canPartition3(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int max = -1;
        for (int num : nums) {
            sum += num;
            max = num > max ? num : max;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        if (max > half) {
            return false;
        }
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = half; nums[i] <= j; j--) {
                dp[j] = dp[j] | dp[j - nums[i]];
            }
        }

        return dp[half];
    }
}
