package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2023/10/10
 * @file M2731_移动机器人.java
 * <p>
 * 思路
 * 模拟，前缀和
 * 1. TLE
 * 2. 优化
 */
public class M2731_移动机器人 {
    int MOD = (int) (1e9 + 7);

    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] += s.charAt(i) == 'L' ? -d : d;
        }
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = (ans + (nums[j] - nums[i]) % MOD) % MOD;
            }
        }

        return ans;
    }

    public int sumDistance2(int[] nums, String s, int d) {
        int n = nums.length;
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums[i] + (s.charAt(i) == 'L' ? -d : d);
        }
        Arrays.sort(a);
        long ans = 0, pre = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + i * a[i] - pre) % MOD;
            pre += a[i];
        }

        return (int) ans;
    }
}
