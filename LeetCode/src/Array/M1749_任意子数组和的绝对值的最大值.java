package Array;

/**
 * @author Hyperspace
 * @date 2023/08/08
 * @file M1749_任意子数组和的绝对值的最大值.java
 * <p>
 * 思路
 * 前缀和
 */
public class M1749_任意子数组和的绝对值的最大值 {
    public int maxAbsoluteSum(int[] nums) {
        int preSum = 0, maxSum = 0, minSum = 0;
        for (int n : nums) {
            preSum += n;
            maxSum = Math.max(maxSum, preSum);
            minSum = Math.min(minSum, preSum);
        }

        return maxSum + Math.abs(minSum);
    }
}
