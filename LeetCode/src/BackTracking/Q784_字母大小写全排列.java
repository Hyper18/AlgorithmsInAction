package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2025/05/04
 * @file Q784_字母大小写全排列.java
 * <p>
 * 思路
 * 回溯
 * <p>
 * trick: ^ 32可用于字母的大小写转换
 */
public class Q784_字母大小写全排列 {
    public class Solution1_0 {
        private List<String> res = new ArrayList<>();
        private StringBuilder sb = new StringBuilder();
        private char[] s;

        public List<String> letterCasePermutation(String s) {
            this.s = s.toCharArray();
            backtrack(0);

            return res;
        }

        private void backtrack(int i) {
            if (i == s.length) {
                res.add(sb.toString());
                return;
            }
            char c = s[i];
            sb.append(c);
            backtrack(i + 1);
            sb.deleteCharAt(sb.length() - 1);
            if (Character.isLetter(c)) {
                sb.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
                backtrack(i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public class Solution1_1 {
        private List<String> res = new ArrayList<>();
        private StringBuilder sb = new StringBuilder();
        private char[] s;

        public List<String> letterCasePermutation(String s) {
            this.s = s.toCharArray();
            backtrack(0);

            return res;
        }

        private void backtrack(int i) {
            if (i == s.length) {
                res.add(sb.toString());
                return;
            }
            char c = s[i];
            sb.append(c);
            backtrack(i + 1);
            sb.deleteCharAt(sb.length() - 1);
            if (Character.isLetter(c)) {
                sb.append((char) (c ^ 32));
                backtrack(i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
