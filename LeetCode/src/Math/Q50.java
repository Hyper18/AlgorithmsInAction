package Math;

/**
 * @author Hyper
 * @date 2024/03/25
 * @file Q50.java
 * <p>
 * 思路
 * 快速幂
 */
public class Q50 {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? qmi(x, N) : 1D / qmi(x, -N);
    }

    private double qmi(double x, long n) {
        double ans = 1D, t = x;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= t;
            }
            t *= t;
            n >>= 1;
        }

        return ans;
    }
}
