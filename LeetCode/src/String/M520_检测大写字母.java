package String;

/**
 * @author Hyperspace
 * @date 2024/06/23
 * @file M520_检测大写字母.java
 * <p>
 * 思路
 * 模拟
 */
public class M520_检测大写字母 {
    public boolean detectCapitalUse(String word) {
        int cnt1 = 0, cnt2 = 0;
        for (char c : word.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                cnt1++;
            } else if (c >= 'a' && c <= 'z') {
                cnt2++;
            }
        }

        return cnt1 == 0 || cnt2 == 0 || (word.length() > 1 && cnt1 == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z');
    }
}
