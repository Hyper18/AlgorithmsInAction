package DP.DigitDP;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/09/01
 * @file M面试题_17_06_2出现的次数.java
 * <p>
 * 思路
 * 数位DP
 * <p>
 * 递归入口：f(0, 0, true)
 * i：从首个元素开始枚举
 * cnt：2的个数，初始置0
 * isLimit：一开始需要受到n的约束
 * isNum：可省，递归开始时前一位是否已填数字对当前的状态无影响
 */
public class M面试题_17_06_2出现的次数 {
    int[][] memo;
    char[] s;

    public int numberOf2sInRange(int n) {
        s = String.valueOf(n).toCharArray();
        int m = s.length;
        memo = new int[m][m];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return f(0, 0, true);
    }

    private int f(int i, int cnt, boolean isLimit) {
        if (i == s.length) {
            return cnt;
        }
        if (!isLimit && memo[i][cnt] != -1) {
            return memo[i][cnt];
        }
        int ans = 0;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = 0; d <= up; d++) {
            ans += f(i + 1, cnt + (d == 2 ? 1 : 0), isLimit && d == up);
        }
        if (!isLimit) {
            memo[i][cnt] = ans;
        }

        return ans;
    }
}
