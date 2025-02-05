package BitOp;

/**
 * @author Hyper
 * @date 2024/10/18
 * @file M3191_使二进制数组全部等于1的最少操作次数I.java
 * <p>
 * 思路
 * 模拟
 */
public class M3191_使二进制数组全部等于1的最少操作次数I {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) {
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                ans++;
            }
        }

        return nums[n - 2] == 1 && nums[n - 1] == 1 ? ans : -1;
    }
}
