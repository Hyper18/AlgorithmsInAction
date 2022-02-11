package Array;

/**
 * @author Hyperspace
 * @date 2022/02/11
 * <p>
 * 思路
 * 1. 暴力 -- 超时。。
 * 2. 忽略查找子串的问题，直接从规律性入手
 * 从首位开始，>0做累加，否则pass；
 * 若sum<=0，则最大和子串一定不在现有子串，找到下一个num值开始
 * 3. 2的实质 -- 动态规划
 */
public class Q53_最大子数组和 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum = sum > 0 ? sum + num : num;
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    public int maxSubArray3(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}
