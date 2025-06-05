package String;

/**
 * @author Hyperspace
 * @date 2025/06/04
 * @file M3403_从盒子中找出字典序最大的字符串I.java
 * <p>
 * 思路
 * 模拟
 */
public class M3403_从盒子中找出字典序最大的字符串I {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            String ss = word.substring(i, Math.min(i + n - numFriends + 1, n));
            if (ss.compareTo(ans) > 0) {
                ans = ss;
            }
        }

        return ans;
    }
}
