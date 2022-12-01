package String;

/**
 * @author Hyperspace
 * @date 2022/11/25
 * @file M809_情感丰富的文字.java
 * <p>
 * 思路
 * 双指针，模拟
 * <p>
 * 注：需要做几次特判
 * 题意实际上 ll 可以伸长为 lll，两个l任补一个即可。。
 */
public class M809_情感丰富的文字 {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (check(s, word)) {
                ans++;
            }
        }

        return ans;
    }

    boolean check(String str, String word) {
        char[] s = str.toCharArray(), w = word.toCharArray();
        int m = s.length, n = w.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            char c = s[i];
            if (c != w[j]) {
                return false;
            }
            int cnt1 = 0;
            while (i < m && s[i] == c) {
                i++;
                cnt1++;
            }
            int cnt2 = 0;
            while (j < n && w[j] == c) {
                j++;
                cnt2++;
            }
            if (cnt1 < cnt2 || (cnt1 != cnt2 && cnt1 < 3)) {
                return false;
            }
        }

        return i == m && j == n;
    }
}
