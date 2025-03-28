package String;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2025/03/28
 * @file M2716_最小化字符串长度.java
 */
public class M2716_最小化字符串长度 {
    public int minimizedStringLength(String s) {
        Set<Character> st = new HashSet<>();
        for (char c : s.toCharArray()) {
            st.add(c);
        }

        return st.size();
    }

    public int minimizedStringLength2(String s) {
        return (int) s.chars().distinct().count();
    }

    public int minimizedStringLength3(String s) {
        int mask = 0;
        for (char c : s.toCharArray()) {
            mask |= (1 << (c - 'a'));
        }

        return Integer.bitCount(mask);
    }
}
