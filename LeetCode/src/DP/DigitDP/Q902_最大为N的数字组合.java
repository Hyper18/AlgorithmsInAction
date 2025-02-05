package DP.DigitDP;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/08/24
 * @file Q902_最大为N的数字组合.java
 * <p>
 * 思路
 * 数位DP
 * <p>
 * 递归入口：f(0, true, false)
 * i：从第一个元素开始枚举
 * mask：不需要记忆化
 * isLimit：一开始需要受到n的约束（题干小于等于n）
 * isNum：需要考虑前导零的情况
 * m：记忆化空间最大为n的长度
 * up：
 * 1) 有限制：最大等于当前的s[i]
 * 2) 无限制：最大取9
 */
public class Q902_最大为N的数字组合 {
    char[] s;
    int[] memo;
    String[] digits;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        this.digits = digits;
        s = String.valueOf(n).toCharArray();
        int m = s.length;
        memo = new int[m];
        Arrays.fill(memo, -1);
        return f(0, true, false);
    }

    private int f(int i, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && memo[i] != -1) {
            return memo[i];
        }
        int ans = 0;
        if (!isNum) {
            ans = f(i + 1, false, false);
        }
        char up = isLimit ? s[i] : '9';
        for (String digit : digits) {
            int d = digit.charAt(0);
            if (d <= up) {
                ans += f(i + 1, isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) {
            memo[i] = ans;
        }

        return ans;
    }
}
