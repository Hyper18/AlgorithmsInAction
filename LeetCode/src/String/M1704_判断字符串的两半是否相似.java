package String;

/**
 * @author Hyperspace
 * @date 2022/11/11
 * @file M1704_判断字符串的两半是否相似.java
 * <p>
 * 思路
 * 模拟
 */
public class M1704_判断字符串的两半是否相似 {
    String words = "aeiouAEIOU";

    public boolean halvesAreAlike(String s) {
        int n = s.length();
        String a = s.substring(0, n / 2), b = s.substring(n / 2);
        int cnt1 = 0, cnt2 = 0;
        for (char c : a.toCharArray()) {
            if (words.indexOf(c) >= 0) {
                cnt1++;
            }
        }
        for (char c : b.toCharArray()) {
            if (words.indexOf(c) >= 0) {
                cnt2++;
            }
        }

        return cnt1 == cnt2;
    }
}
