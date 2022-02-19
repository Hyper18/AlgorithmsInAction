package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2022/02/19
 * <p>
 * 思路
 * 1. hash
 * 2. array
 */
public class Q383_赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char s : ransomNote.toCharArray()) {
            if (map.get(s) == null) {
                return false;
            }
            map.put(s, map.get(s) - 1);
            if (map.get(s) < 0) {
                return false;
            }
        }
        return true;
    }

    private static char base = 'a';

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - base]++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - base]--;
            if (cnt[c - base] < 0) {
                return false;
            }
        }
        return true;
    }
}
