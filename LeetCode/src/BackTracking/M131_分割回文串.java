package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2025/03/01，2025/05/04
 * @file M131_分割回文串.java
 * <p>
 * 思路
 * 回溯
 */
public class M131_分割回文串 {
    private List<List<String>> res = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    private char[] s;

    public List<List<String>> partition(String s) {
        this.s = s.toCharArray();
        backtrack(0);

        return res;
    }

    private void backtrack(int i) {
        if (i == s.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length; j++) {
            if (!isPalindrome(i, j)) {
                continue;
            }
            path.add(new String(s, i, j + 1 - i));
            backtrack(j + 1);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(int l, int r) {
        while (l < r) {
            if (s[l++] != s[r--]) {
                return false;
            }
        }

        return true;
    }
}
