package TwoPointer;

/**
 * @author Hyperspace
 * @date 2023/10/12
 * @file M2562_找出数组的串联值.java
 * <p>
 * 思路
 * 双指针模拟
 */
public class M2562_找出数组的串联值 {
    public long findTheArrayConcVal(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            ans += Long.parseLong(String.valueOf(nums[i]) + nums[j]);
        }

        return n % 2 == 0 ? ans : ans + nums[n / 2];
    }
}
