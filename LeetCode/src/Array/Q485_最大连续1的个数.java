package Array;

/**
 * @author Hyperspace
 * @date 2023/02/28
 * @file Q485_最大连续1的个数.java
 */
public class Q485_最大连续1的个数 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int ans = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                ans = Math.max(ans, cnt);
            }
        }

        return Math.max(ans, cnt);
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int ans = 0, cnt = 0;
        for (int n : nums) {
            if (n == 1) {
                cnt++;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 0;
            }
        }

        return Math.max(ans, cnt);
    }
}
