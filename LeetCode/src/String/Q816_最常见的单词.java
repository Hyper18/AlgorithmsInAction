package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2022/04/18
 * hash -- O(n + m)
 */
public class Q816_最常见的单词 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> res = new HashMap<>();
        String[] paragraphs = paragraph.split("[!?',;.]");
        for (String p : paragraphs) {
            String[] words = p.trim().split(" ");
            for (String w : words) {
                w = w.toLowerCase();
                boolean flag = true;
                for (String b : banned) {
                    if (w.equals(b)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res.put(w, res.getOrDefault(w, 0) + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        String ans = null;
        for (Map.Entry<String, Integer> entry : res.entrySet()) {
            if (entry.getValue() > max) {
                ans = entry.getKey();
                max = entry.getValue();
            }
        }

        return ans;
    }
}
