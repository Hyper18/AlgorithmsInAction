package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2023/08/01
 * @file M2681_英雄的力量.java
 */
public class M2681_英雄的力量 {
    public int sumOfPower(int[] nums) {
        long MOD = (long) 1e9 + 7;
        Arrays.sort(nums);
        long ans = 0, s = 0;
        for (long x : nums) {
            ans = (ans + x * x % MOD * (x + s)) % MOD;
            s = (s * 2 + x) % MOD;
        }

        return (int) ans;
    }
}
