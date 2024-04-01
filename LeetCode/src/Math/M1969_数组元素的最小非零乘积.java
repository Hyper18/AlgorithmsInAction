package Math;

/**
 * @author Hyperspace
 * @date 2024/03/20
 * @file M1969_数组元素的最小非零乘积.java
 * <p>
 * 思路
 * 快速幂，贪心
 * 较小的数将除最低位交换给大数
 */
public class M1969_数组元素的最小非零乘积 {
    final int MOD = 1_000_000_007;

    public int minNonZeroProduct(int p) {
        if (p == 1) {
            return 1;
        }
        long x = qmi(2, p) - 1, y = (long) 1 << (p - 1);

        return (int) (qmi(x - 1, y - 1) * x % MOD);
    }

    private long qmi(long a, long k) {
        long ans = 1 % MOD, t = a;
        while (k > 0) {
            if ((k & 1) == 1) {
                ans = ans * t % MOD;
            }
            t = t * t % MOD;
            k >>= 1;
        }

        return ans;
    }
}
