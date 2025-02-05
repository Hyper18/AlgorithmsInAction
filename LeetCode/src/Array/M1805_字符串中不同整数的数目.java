package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyper
 * @date 2022/12/06
 * @file M1805_字符串中不同整数的数目.java
 * <p>
 * 思路
 * Set去重，模拟
 */
public class M1805_字符串中不同整数的数目 {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) <= '9') {
                int j = i;
                while (j < word.length() && word.charAt(j) <= '9') {
                    j++;
                }
                while (i < j && word.charAt(i) == '0') {
                    i++;
                }
                set.add(word.substring(i, j));
                i = j;
            }
        }

        return set.size();
    }
}
