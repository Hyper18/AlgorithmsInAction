package String;

import java.util.List;

/**
 * @author Hyper
 * @date 2023/12/20
 * @file M2828_判别首字母缩略词.java
 * <p>
 * 思路
 * 模拟
 */
public class M2828_判别首字母缩略词 {
    public boolean isAcronym(List<String> words, String s) {
        String w = "";
        for (String word : words) {
            w += word.charAt(0);
        }

        return s.equals(w);
    }

    public boolean isAcronym2(List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }
        int n = words.size();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != words.get(i).charAt(0)) {
                return false;
            }
        }

        return true;
    }
}
