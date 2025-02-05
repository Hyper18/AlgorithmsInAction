package DP.DigitDP;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/08/31
 * @file Q600_不含连续1的非负整数.java
 * <p>
 * 思路
 * 数位DP
 * <p>
 * 由于题干给定的范围为10^9，可在int范围内处理（可通过返回值推断）
 * <p>
 * 递归入口：f(0, 0, true)
 * i：从首个元素开始枚举
 * pre：前一位的值初始为0
 * isLimit：一开始需要受到n的约束
 * isNum：可省，在递归开始前处理前导零，且前一位是否已填数字对当前的状态无影响
 * <p>
 * 递归中，分类讨论：
 * 1) 当前位填入0
 * f(i + 1, 0, isLimit && up == 0)
 * 2) 当前位填入为1
 * f(i + 1, 1, isLimit)
 */
public class Q600_不含连续1的非负整数 {
    int[][] memo;
    int n, m;

    public int findIntegers(int n) {
        this.n = n;
        this.m = Integer.SIZE - Integer.numberOfLeadingZeros(n);
        memo = new int[m][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return f(0, 0, true);
    }

    private int f(int i, int pre, boolean isLimit) {
        if (i == m) {
            return 1;
        }
        if (!isLimit && memo[i][pre] != -1) {
            return memo[i][pre];
        }
        int up = isLimit ? n >> (m - 1 - i) & 1 : 1;
        int ans = f(i + 1, 0, isLimit && up == 0);
        if (up == 1 && up != pre) {
            ans += f(i + 1, 1, isLimit);
        }
        if (!isLimit) {
            memo[i][pre] = ans;
        }

        return ans;
    }
}
