package Array;

/**
 * @author Hyperspace
 * @date 2025/01/14
 * @file M3065_超过阈值的最少操作数I.java
 */
public class M3065_超过阈值的最少操作数I {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        for (int num : nums) {
            if (num < k) {
                ans++;
            }
        }

        return ans;
    }
}
