package Array;

import java.math.BigInteger;

/**
 * @author Hyperspace
 * @date 2024/03/07
 * @file M2575_找出字符串的可整除数组.java
 * <p>
 * 思路
 * 1. BigInteger模拟 TLE
 * 2. 模拟 取模优化
 */
public class M2575_找出字符串的可整除数组 {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] res = new int[n];
        BigInteger r = new BigInteger(String.valueOf(m));
        for (int i = 1; i <= n; i++) {
            BigInteger num = new BigInteger(word.substring(0, i));
            res[i - 1] = num.mod(r).equals(BigInteger.ZERO) ? 1 : 0;
        }

        return res;
    }

    public int[] divisibilityArray2(String word, int m) {
        int n = word.length();
        int[] res = new int[n];
        long num = 0;
        int i = 0;
        for (char w : word.toCharArray()) {
            num = (num * 10 + w - '0') % m;
            res[i++] = num == 0 ? 1 : 0;
        }

        return res;
    }

    public int[] divisibilityArray3(String word, int m) {
        int n = word.length();
        int[] res = new int[n];
        long num = 0;
        for (int i = 0; i < n; i++) {
            num = (num * 10 + word.charAt(i) - '0') % m;
            res[i] = num == 0 ? 1 : 0;
        }

        return res;
    }
}
