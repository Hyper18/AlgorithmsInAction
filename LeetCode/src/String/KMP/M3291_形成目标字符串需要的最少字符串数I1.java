package String.KMP;

/**
 * @author Hyper
 * @date 2024/12/17
 * @file M3291_形成目标字符串需要的最少字符串数I1.java
 * <p>
 * 思路
 * 贪心
 * <p>
 * 卡802/929
 * 无法解决下述情况：
 * words=["b","ccacc","a"]
 * target="cccaaaacba"
 * output:9
 * expect:8
 */
public class M3291_形成目标字符串需要的最少字符串数I1 {
    public int minValidStrings(String[] words, String target) {
        int n = target.length();
        int ans = 0, l = 0, r = 0;
        boolean found;
        StringBuilder sb = new StringBuilder();
        while (r < n) {
            found = false;
            while (r < n && check(words, target.substring(l, r + 1))) {
                r++;
                if (!found) {
                    found = true;
                }
            }
            if (found) {
                ans++;
                sb.append(target, l, r);
            } else {
                r++;
            }
            l = r;
        }

        return ans == 0 || !sb.toString().equals(target) ? -1 : ans;
    }

    private boolean check(String[] words, String s) {
        for (String word : words) {
            if (word.indexOf(s) == 0) {
                return true;
            }
        }
        return false;
    }
}
