package Math;

/**
 * @author Hyperspace
 * @date 2024/08/23
 * @file M3145_大数组元素的乘积.java
 * <p>
 * 思路@灵茶山艾府 https://www.bilibili.com/video/BV1cz421m786
 * 试填法+前缀和+位运算+快速幂
 * <p>
 * 1. 计算强数组的幂次之和
 * 基于前缀和，从from到to这一段的幂次之和为 pre[to + 1] - pre[from]
 * 2. 找前k个幂次是由多少个强数组组成
 * 定义ones(n)为[0,n−1]中数字的二进制中的1的个数之和
 * ones(2i)=i⋅2^(i−1)
 * 基于试填法，找一个最大的n，满足 ones(n) ≤ k
 * 3. 计算幂次之和
 * 如果 n=2^i，sumE(2^i)=i(i−1)/2 * 2^(i−1)
 * 其中，使用快速幂计算2的幂模mod
 * <p>
 * trick:
 * i << i >> 1相比于i << (i - 1)无需特判0的情况
 */
public class M3145_大数组元素的乘积 {
    public int[] findProductsOfElements(long[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        int i = 0;
        for (long[] q : queries) {
            long from = q[0], to = q[1], mod = q[2];
            long er = sumE(to + 1), el = sumE(from);
            res[i++] = pow(2, er - el, mod);
        }

        return res;
    }

    private long sumE(long k) {
        long ans = 0, n = 0, cnt = 0, sum = 0;
        for (long i = 63 - Long.numberOfLeadingZeros(k + 1); i >= 0; i--) {
            long c = (cnt << i) + (i << i >> 1);
            if (c <= k) {
                k -= c;
                ans += (sum << i) + ((i * (i - 1) / 2) << i >> 1);
                sum += i;
                cnt++;
                n |= 1L << i;
            }
        }
        while (k-- > 0) {
            ans += Long.numberOfTrailingZeros(n);
            n &= n - 1;
        }

        return ans;
    }

    private int pow(long x, long n, long mod) {
        long ans = 1 % mod;
        for (; n > 0; n >>= 1) {
            if (n % 2 == 1) {
                ans = ans * x % mod;
            }
            x = x * x % mod;
        }

        return (int) ans;
    }
}
