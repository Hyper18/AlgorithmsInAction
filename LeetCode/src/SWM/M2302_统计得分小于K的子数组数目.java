package SWM;

/**
 * @author Hyperspace
 * @date 2025/04/28
 * @file M2302_统计得分小于K的子数组数目.java
 * <p>
 * 思路
 * SWM
 */
public class M2302_统计得分小于K的子数组数目 {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long ans = 0, sum = 0, cnt = 0;
        for (int l = 0, r = 0; r < n; r++) {
            sum += nums[r];
            cnt++;
            while (sum * cnt >= k) {
                sum -= nums[l++];
                cnt--;
            }
            ans += r - l + 1;
        }

        return ans;
    }
}
