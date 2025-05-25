package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2025/05/24
 * @file M2942_查找包含给定字符的单词.java
 */
public class M2942_查找包含给定字符的单词 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        int n = words.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (words[i].indexOf(x) >= 0) {
                res.add(i);
            }
        }

        return res;
    }
}
