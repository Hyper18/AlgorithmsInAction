package Math;

/**
 * @author Hyperspace
 * @date 2025/04/13
 * @file M1922_统计好数字的数目.java
 * <p>
 * 思路
 * 快速幂
 * 找规律
 * 偶数5种，奇数4种
 */
public class M1922_统计好数字的数目 {
    private final int MOD = (int) 1e9 + 7;

    public int countGoodNumbers(long n) {
        return (int) (qmi(5, (n + 1) / 2) * qmi(4, n / 2) % MOD);
    }

    private long qmi(long a, long k) {
        long ans = 1;
        while (k > 0) {
            if ((k & 1) == 1) {
                ans = ans * a % MOD;
            }
            a = a * a % MOD;
            k >>= 1;
        }

        return ans;
    }
}
