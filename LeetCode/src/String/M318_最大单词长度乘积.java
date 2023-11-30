package String;

/**
 * @author Hyperspace
 * @date 2023/11/06
 * @file M318_最大单词长度乘积.java
 * <p>
 * 思路
 * 本题的难点在于如何确定两个单词中是否含有公共字母
 * 将字母的比较转换为位运算
 */
public class M318_最大单词长度乘积 {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bits = new int[n];
        for (int i = 0; i < n; i++) {
            int len = words[i].length();
            for (int j = 0; j < len; ++j) {
                bits[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }

        return ans;
    }
}
