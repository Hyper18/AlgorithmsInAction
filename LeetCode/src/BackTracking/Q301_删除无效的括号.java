package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2025/06/16
 * @file Q301_删除无效的括号.java
 * <p>
 * 思路
 * 组合型回溯+剪枝
 */
public class Q301_删除无效的括号 {
    private Set<String> st = new HashSet<>();
    private char[] cs;

    public List<String> removeInvalidParentheses(String s) {
        cs = s.toCharArray();
        int lSum = 0, rSum = 0;
        for (char c : cs) {
            if (c == '(') {
                lSum++;
            } else if (c == ')') {
                if (lSum > 0) {
                    lSum--;
                } else {
                    rSum++;
                }
            }
        }
        backtrack(0, lSum, rSum, 0, new StringBuilder());

        return new ArrayList<>(st);
    }

    private void backtrack(int i, int lSum, int rSum, int open, StringBuilder sb) {
        if (i == cs.length) {
            if (lSum == 0 && rSum == 0) {
                st.add(sb.toString());
            }
            return;
        }
        char c = cs[i];
        int n = sb.length();
        if (c == '(' && lSum > 0) {
            backtrack(i + 1, lSum - 1, rSum, open, sb);
        }
        if (c == ')' && rSum > 0) {
            backtrack(i + 1, lSum, rSum - 1, open, sb);
        }
        sb.append(c);
        if (c == '(') {
            backtrack(i + 1, lSum, rSum, open + 1, sb);
        } else if (c == ')') {
            if (open > 0) {
                backtrack(i + 1, lSum, rSum, open - 1, sb);
            }
        } else {
            backtrack(i + 1, lSum, rSum, open, sb);
        }
        sb.setLength(n);
    }
}
