package Math;

/**
 * @author Hyper
 * @date 2022/11/22
 * @file M878_第N个神奇数字.java
 * <p>
 * 思路
 * 1. 模拟 -- 1e9 O(n) TLE
 * 2. 数学，二分 O(log_n)
 * 被a整除 + 被b整除 - 同时被a、b整除
 */
public class M878_第N个神奇数字 {
    final int MOD = (int) 1e9 + 7;

    public int nthMagicalNumber(int n, int a, int b) {
        long cur = Math.min(a, b);
        while (n > 0) {
            if (cur % a == 0 || cur % b == 0) {
                n--;
            }
            cur++;
        }

        return (int) ((cur - 1) % MOD);
    }

    public int nthMagicalNumber2(int n, int a, int b) {
        int c = lcm(a, b);
        long low = 0, high = (long) MOD * MOD;
        while (low < high) {
            long mid = low + ((high - low) >> 1);
            if (mid / a + mid / b - mid / c >= n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return (int) (high % MOD);
    }

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
