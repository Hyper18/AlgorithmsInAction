package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyper
 * @date 2025/03/01
 * @file M131_分割回文串.java
 * <p>
 * 思路
 * 回溯
 */
public class M131_分割回文串 {
    private List<List<String>> res = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    private String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        backtrack(0);
        return res;
    }

    private void backtrack(int i) {
        if (i == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(i, j)) {
                path.add(s.substring(i, j + 1));
                backtrack(j + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}
