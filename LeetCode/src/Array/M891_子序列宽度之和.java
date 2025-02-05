package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/11/18
 * @file M891_子序列宽度之和.java
 * <p>
 * 思路
 * 纯数学
 * 排序，计算每个元素对答案的贡献
 * 通过预先排序nums，此后找到子序列的最大值和最小值的时间复杂度均为O(1)
 * 每个元素nums[i]作为最值时，其共有多少个子序列？
 * 不考虑重复情况，则：
 * 若nums[i]是子序列的最小值，可选取所有大于nums[i]的数，组合有2^k * (-nums[i])，其中k = n - 1 - i
 * 若nums[i]是子序列的最大值，可选取所有小于nums[i]的数，组合有2^k * nums[i]。其中k = i
 * 若考虑重复的nums[i]，由于其值均相等，对结果的贡献没有影响
 */
public class M891_子序列宽度之和 {
    final int MOD = (int) 1e9 + 7;

    public int sumSubseqWidths(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] f = new long[n];
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = (f[i - 1] << 1) % MOD;
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + f[i] * nums[i] % MOD) % MOD;
            ans = (ans - f[n - i - 1] * nums[i] % MOD) % MOD;
        }

        return (int) ans;
    }
}
