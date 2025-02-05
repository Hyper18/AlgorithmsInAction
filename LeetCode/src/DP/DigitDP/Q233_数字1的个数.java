package DP.DigitDP;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/08/23
 * @file Q233_数字1的个数.java
 * <p>
 * 思路
 * 数位DP
 * <p>
 * 递归入口：f(0, 0, true)
 * i：从第一个元素开始枚举
 * cnt：初始置为空
 * isLimit：一开始需要受到n的约束（题干小于等于n）
 * isNum：可省，前一位是否已填数字对当前的状态无影响
 * m：记忆化空间最大为n的长度，即最多为所有十进制位上均为1
 * up：0~9
 */
public class Q233_数字1的个数 {
    char[] s;
    int[][] memo;

    public int countDigitOne(int n) {
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
            ans += f(i + 1, cnt + (d == 1 ? 1 : 0), isLimit && d == up);
        }
        if (!isLimit) {
            memo[i][cnt] = ans;
        }

        return ans;
    }
}
