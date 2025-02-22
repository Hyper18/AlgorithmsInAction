package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2025/02/22
 * @file M2506_统计相似字符串对的数目.java
 */
public class M2506_统计相似字符串对的数目 {
    public int similarPairs(String[] words) {
        int n = words.length;
        List<Set<Character>> sets = new ArrayList<>();
        for (String word : words) {
            Set<Character> st = new HashSet<>();
            for (char c : word.toCharArray()) {
                st.add(c);
            }
            sets.add(st);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (sets.get(i).equals(sets.get(j))) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
