package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2024/03/13
 * @file Q17_电话号码的字母组合.java
 * <p>
 * 思路
 * dfs回溯
 * 1. map
 * 2. array
 */
public class Q17_电话号码的字母组合 {
    List<String> res = new ArrayList<>();
    final Map<Character, String> mp = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return res;
        }
        backtrack(digits, 0, "");
        return res;
    }

    private void backtrack(String digits, int i, String s) {
        if (i == digits.length()) {
            res.add(s);
            return;
        }
        String alphas = mp.get(digits.charAt(i));
        int len = alphas.length();
        for (int j = 0; j < len; j++) {
            backtrack(digits, i + 1, s + alphas.charAt(j));
        }
    }

    String[] mp2 = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations2(String digits) {
        if ("".equals(digits)) {
            return res;
        }
        backtrack2(digits, 0, "");
        return res;
    }

    private void backtrack2(String digits, int i, String s) {
        if (i == digits.length()) {
            res.add(s);
            return;
        }
        String alphas = mp2[digits.charAt(i) - '0'];
        int len = alphas.length();
        for (int j = 0; j < len; j++) {
            backtrack2(digits, i + 1, s + alphas.charAt(j));
        }
    }
}
