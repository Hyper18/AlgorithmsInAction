package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/03/13，2025/05/04
 * @file Q17_电话号码的字母组合.java
 * <p>
 * 思路
 * 回溯
 */
public class Q17_电话号码的字母组合 {
    class Solution1_0 {
        private final String[] mp = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        private List<String> res = new ArrayList<>();
        private char[] s;

        public List<String> letterCombinations2(String digits) {
            if ("".equals(digits)) {
                return res;
            }
            s = digits.toCharArray();
            backtrack(0, "");

            return res;
        }

        private void backtrack(int i, String path) {
            if (i == s.length) {
                res.add(path);
                return;
            }
            char[] ss = mp[s[i] - '0'].toCharArray();
            for (char c : ss) {
                backtrack(i + 1, path + c);
            }
        }
    }

    class Solution1_1 {
        private final String[] mp = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        private List<String> res = new ArrayList<>();
        private StringBuilder sb = new StringBuilder();
        private char[] s;

        public List<String> letterCombinations(String digits) {
            if ("".equals(digits)) {
                return res;
            }
            s = digits.toCharArray();
            backtrack(0);

            return res;
        }

        private void backtrack(int i) {
            if (i == s.length) {
                res.add(sb.toString());
                return;
            }
            char[] ss = mp[s[i] - '0'].toCharArray();
            for (char c : ss) {
                sb.append(c);
                backtrack(i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
