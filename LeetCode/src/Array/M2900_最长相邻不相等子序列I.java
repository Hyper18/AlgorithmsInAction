package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2025/05/15
 * @file M2900_最长相邻不相等子序列I.java
 * <p>
 * 思路
 * 模拟
 */
public class M2900_最长相邻不相等子序列I {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        for (int i = 1; i < n; i++) {
            if (groups[i] != groups[i - 1]) {
                res.add(words[i]);
            }
        }

        return res;
    }
}
