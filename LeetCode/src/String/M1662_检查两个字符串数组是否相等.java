package String;

/**
 * @author Hyperspace
 * @date 2022/11/01
 * <p>
 * 思路
 * 1. 模拟
 * 2. 双指针
 */
public class M1662_检查两个字符串数组是否相等 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
        for (String s : word1) {
            s1.append(s);
        }
        for (String s : word2) {
            s2.append(s);
        }

        return s1.toString().equals(s2.toString());
    }

    public boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        int n1 = word1.length, n2 = word2.length;
        int p1 = 0, p2 = 0, i = 0, j = 0;
        while (p1 < n1 && p2 < n2) {
            if (word1[p1].charAt(i) != word2[p2].charAt(j)) {
                return false;
            }
            i++;
            j++;
            if (i == word1[p1].length()) {
                p1++;
                i = 0;
            }
            if (j == word2[p2].length()) {
                p2++;
                j = 0;
            }
        }

        return p1 == n1 && p2 == n2;
    }
}
