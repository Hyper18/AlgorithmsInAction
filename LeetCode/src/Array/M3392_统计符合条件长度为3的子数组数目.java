package Array;

/**
 * @author Hyperspace
 * @date 2025/04/27
 * @file M3392_统计符合条件长度为3的子数组数目.java
 */
public class M3392_统计符合条件长度为3的子数组数目 {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            if ((nums[i] + nums[i + 2]) * 2 == nums[i + 1]) {
                ans++;
            }
        }

        return ans;
    }
}
