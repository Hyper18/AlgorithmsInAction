package BackTracking;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2025/05/04
 * @file Q1239_串联字符串的最大长度.java
 * <p>
 * 思路
 * 回溯
 */
public class Q1239_串联字符串的最大长度 {
    private Map<Integer, Integer> mp = new HashMap<>();
    private List<String> arr = new ArrayList<>();
    private int ans;

    public int maxLength(List<String> arr) {
        this.arr = arr;
        backtrack(0, 0);

        return ans;
    }

    private void backtrack(int i, int len) {
        if (i == arr.size()) {
            ans = Math.max(ans, len);
            return;
        }
        backtrack(i + 1, len);
        char[] cs = arr.get(i).toCharArray();
        if (check(cs)) {
            for (char c : cs) {
                mp.merge(c - 'a', 1, Integer::sum);
            }
            backtrack(i + 1, len + cs.length);
            for (char c : cs) {
                mp.merge(c - 'a', -1, Integer::sum);
            }
        }
    }

    private boolean check(char[] cs) {
        Set<Integer> st = new HashSet<>();
        for (char c : cs) {
            if (!st.add(c - 'a')) {
                return false;
            }
        }
        for (char c : cs) {
            if (mp.getOrDefault(c - 'a', 0) > 0) {
                return false;
            }
        }

        return true;
    }
}
