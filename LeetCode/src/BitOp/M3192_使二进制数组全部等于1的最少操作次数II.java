package BitOp;

/**
 * @author Hyperspace
 * @date 2024/10/19
 * @file M3192_使二进制数组全部等于1的最少操作次数II.java
 * <p>
 * 思路
 * 1. 模拟 O(n^2) TLE
 * 2. 模拟 O(n)
 * 每次和上一个相邻元素比较，仅两者不同时累计ans
 */
public class M3192_使二进制数组全部等于1的最少操作次数II {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                for (int j = i; j < n; j++) {
                    nums[j] ^= 1;
                }
                ans++;
            }
        }

        return nums[0] == 0 ? ans + 1 : ans;
    }

    public int minOperations2(int[] nums) {
        int n = nums.length;
        int ans = nums[0] ^ 1;
        for (int i = 1; i < n; i++) {
            ans += nums[i - 1] ^ nums[i];
        }

        return ans;
    }
}
