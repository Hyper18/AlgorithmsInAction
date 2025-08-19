package Math;

/**
 * @author Hyper
 * @date 2025/08/19
 * @file M2348_全0子数组的数目.java
 * <p>
 * 思路
 * 数学
 * 等差数列求和
 */
public class M2348_全0子数组的数目 {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            while (i < n && nums[i] != 0) {
                i++;
            }
            int cnt = 0;
            while (i < n && nums[i] == 0) {
                cnt++;
                i++;
            }
            ans += (long) cnt * (cnt + 1) / 2;

        }

        return ans;
    }
}
