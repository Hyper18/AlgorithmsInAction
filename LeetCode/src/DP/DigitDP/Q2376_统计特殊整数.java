package DP.DigitDP;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/08/21，2024/09/20
 * @file Q2376_统计特殊整数.java
 * <p>
 * 思路@灵茶山艾府
 * 记忆化搜索+数位DP
 * 模板题
 * <p>
 * 用二进制表示集合
 * 以{0, 2, 3}为例，表示为1101
 * 对于当前集合对应的二进制数x，常用两个位运算操作：
 * 1) 判断集合是否存在元素d
 * (x >> d) & 1 = x >> d & 1
 * 2) 新增元素d到集合中
 * x | (1 << d)
 * <p>
 * f(i, mask, isLimit, isNum)
 * mask：集合
 * isLimit：是否受到n的约束
 * 如n=123，当前两位已为12时，则第三位只能为3，范围的上界为s[i]
 * isNum：递归时前一位是否已填数字
 * 1) 否，可以跳过不填数字，或填入1~9（还需考虑前导零的情况）
 * 2) 是，则可填入的范围仍为0~9（前面已有数字）
 * <p>
 * 递归入口：f(0, 0, true, false)
 * i：从第一个元素开始枚举
 * mask：初始置为空
 * isLimit：一开始需要受到n的约束
 * isNum：递归开始时未填数字
 * <p>
 * 复杂度分析
 * 时间复杂度 = 状态个数 × 单个状态的计算时间 = O(m*2^D) * O(D) = O(mD*2^D)
 * 空间复杂度 = 状态个数 = O(m*2^D)
 */
public class Q2376_统计特殊整数 {
    char[] s;
    int[][] memo;

    public int countSpecialNumbers(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        memo = new int[m][1 << 10];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return f(0, 0, true, false);
    }

    private int f(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && memo[i][mask] != -1) {
            return memo[i][mask];
        }
        int ans = 0;
        if (!isNum) {
            ans = f(i + 1, mask, false, false);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            if ((mask >> d & 1) == 0) {
                ans += f(i + 1, mask | (1 << d), isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) {
            memo[i][mask] = ans;
        }

        return ans;
    }
}
