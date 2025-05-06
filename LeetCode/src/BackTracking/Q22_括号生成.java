package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyper
 * @date 2025/05/06
 * @file Q22_括号生成.java
 * <p>
 * 思路
 * 组合型回溯
 * 1. 选左括号或选右括号
 * 数组直接覆盖，无需恢复现场
 * 2. 枚举下一个左括号的位置
 */
public class Q22_括号生成 {
    class Solution {
        private List<String> res = new ArrayList<>();
        private char[] path;
        private int n;

        public List<String> generateParenthesis(int n) {
            this.n = n;
            path = new char[n << 1];
            backtrack(0, 0);

            return res;
        }

        private void backtrack(int i, int left) {
            if (i == n << 1) {
                res.add(new String(path));
                return;
            }
            if (left < n) {
                path[i] = '(';
                backtrack(i + 1, left + 1);
            }
            if (left > i - left) {
                path[i] = ')';
                backtrack(i + 1, left);
            }
        }
    }

    class Solution2 {
        private List<String> res = new ArrayList<>();
        private List<Integer> left = new ArrayList<>();
        private int n;

        public List<String> generateParenthesis(int n) {
            this.n = n;
            backtrack(0, 0);

            return res;
        }

        private void backtrack(int i, int diff) {
            if (left.size() == n) {
                char[] s = new char[n << 1];
                Arrays.fill(s, ')');
                for (int j : left) {
                    s[j] = '(';
                }
                res.add(new String(s));
                return;
            }
            for (int right = 0; right <= diff; right++) {
                left.add(i + right);
                backtrack(i + right + 1, diff - right + 1);
                left.remove(left.size() - 1);
            }
        }
    }
}
