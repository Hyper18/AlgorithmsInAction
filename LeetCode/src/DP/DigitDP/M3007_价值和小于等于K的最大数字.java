package DP.DigitDP;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/08/21
 * @file M3007_价值和小于等于K的最大数字.java
 * <p>
 * 思路
 * （开区间）二分+数位DP
 * 最大可能位数64 - 前导零，这里判断的是当前数的二进制位数
 * <p>
 * 由于题干中k给定的范围为2^15，需要注意爆int
 */
public class M3007_价值和小于等于K的最大数字 {
    long k, num;
    int x;
    long[][] memo;

    public long findMaximumNumber(long k, int x) {
        this.k = k;
        this.x = x;
        return binarySearch(0, (k + 1) << x);
    }

    private long binarySearch(long low, long high) {
        while (low + 1 < high) {
            long mid = low + ((high - low) >> 1);
            if (check(mid) <= k) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private long check(long num) {
        this.num = num;
        int m = Long.SIZE - Long.numberOfLeadingZeros(num);
        memo = new long[m][m];
        for (long[] row : memo) {
            Arrays.fill(row, -1);
        }

        return f(m - 1, 0, true);
    }

    private long f(int i, int cnt, boolean isLimit) {
        if (i < 0) {
            return cnt;
        }
        if (!isLimit && memo[i][cnt] != -1) {
            return memo[i][cnt];
        }
        int up = isLimit ? (int) (num >> i & 1) : 1;
        long ans = 0;
        for (int d = 0; d <= up; d++) {
            ans += f(i - 1, cnt + (d == 1 && (i + 1) % x == 0 ? 1 : 0), isLimit && d == up);
        }
        if (!isLimit) {
            memo[i][cnt] = ans;
        }

        return ans;
    }
}
