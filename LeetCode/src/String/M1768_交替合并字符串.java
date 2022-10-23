package String;

/**
 * @author Hyperspace
 * @date 2022/10/23
 * <p>
 * 思路
 * 1. 模拟
 * 2. 双指针
 */
public class M1768_交替合并字符串 {
    class Solution {
        public String mergeAlternately(String word1, String word2) {
            StringBuilder res = new StringBuilder();
            int n1 = word1.length(), n2 = word2.length();
            int i;
            for (i = 0; i < n1 && i < n2; i++) {
                res.append(word1.charAt(i)).append(word2.charAt(i));
            }
            if (n1 > n2) {
                res.append(word1.substring(i));
            } else if (n2 > n1) {
                res.append(word2.substring(i));
            }

            return res.toString();
        }

        public String mergeAlternately2(String word1, String word2) {
            StringBuilder res = new StringBuilder();
            int n1 = word1.length(), n2 = word2.length();
            int i = 0;
            while (i < n1 || i < n2) {
                if (i < n1) {
                    res.append(word1.charAt(i));
                }
                if (i < n2) {
                    res.append(word2.charAt(i));
                }
                i++;
            }

            return res.toString();
        }
    }
}
