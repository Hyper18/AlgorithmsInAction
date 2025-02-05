package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hyper
 * @date 2022/11/17
 * @file M792_匹配子序列的单词数.java
 * <p>
 * 思路
 * 1. 双指针，模拟
 * 2. hash计数，二分
 */
public class M792_匹配子序列的单词数 {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Boolean> isSubSeq = new HashMap<>();
        int ans = 0;
        for (String word : words) {
            if (isSubSeq.getOrDefault(word, false)) {
                ans++;
                continue;
            }
            int n = s.length(), m = word.length();
            int i = 0, j = 0;
            while (i < n && j < m) {
                if (s.charAt(i) == word.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j == m) {
                ans++;
                isSubSeq.put(word, true);
            }
        }

        return ans;
    }

    public int numMatchingSubseq2(String s, String[] words) {
        int n = s.length();
        Map<Character, List<Integer>> map = new HashMap<>();
        // 统计s中字符出现的下标
        for (int i = 0; i < n; i++) {
            List<Integer> li = map.getOrDefault(s.charAt(i), new ArrayList<>());
            li.add(i);
            map.put(s.charAt(i), li);
        }
        int ans = 0;
        for (String word : words) {
            int m = word.length();
            int idx = -1;
            boolean isSubSeq = true;
            for (int i = 0; i < m && isSubSeq; i++) {
                List<Integer> li = map.getOrDefault(word.charAt(i), new ArrayList<>());
                int low = 0, high = li.size() - 1;
                // 因为list中存放的下标是顺次（升序）排列的，可以使用二分优化一次遍历
                while (low < high) {
                    // 注意+/-优先级比位运算高，这里必须加括号，否则等同于(low + high - low) >> 1
                    int mid = low + (high - low >> 1);
                    // 找到恰好大于当前idx的最小值
                    if (li.get(mid) > idx) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
                // 非法情况：未找到或找到的位置在idx之前
                if (high < 0 || li.get(high) <= idx) {
                    isSubSeq = false;
                } else {
                    // 移动当前idx
                    idx = li.get(high);
                }
            }
            // 符合子序列条件
            if (isSubSeq) {
                ans++;
            }
        }

        return ans;
    }
}
