package String;

/**
 * @author Hyper
 * @date 2022/11/08
 * <p>
 * 思路
 * 暴力
 */
public class M1684_统计一致字符串的数目 {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = words.length;
        for (String w : words) {
            for (char c : w.toCharArray()) {
                if (allowed.indexOf(c) < 0) {
                    ans--;
                    break;
                }
            }
        }

        return ans;
    }
}
