package SWM;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyper
 * @date 2025/03/12
 * @file M3305_元音辅音字符串计数I.java
 * <p>
 * 思路
 * 模拟
 */
public class M3305_元音辅音字符串计数I {
    private Set<Character> ch = new HashSet<Character>() {{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
    }};

    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        int ans = 0;
        for (int i = 0; i < n - k; i++) {
            for (int j = i + k + 4; j < n; j++) {
                if (check(word.substring(i, j + 1), k)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private boolean check(String s, int k) {
        Set<Character> st = new HashSet<>();
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (ch.contains(c)) {
                st.add(c);
            } else {
                cnt++;
            }
        }

        return cnt == k && st.size() == 5;
    }
}
