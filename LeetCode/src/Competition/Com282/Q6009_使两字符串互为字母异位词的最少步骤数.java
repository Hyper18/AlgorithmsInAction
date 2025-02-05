package Competition.Com282;

/**
 * @author Hyper
 * @date 2022/02/27
 */
public class Q6009_使两字符串互为字母异位词的最少步骤数 {
    public int minSteps(String s, String t) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (int i = 0; i < s.length(); i++) {
            cnt1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            cnt2[t.charAt(i) - 'a']++;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.abs(cnt1[i] - cnt2[i]);
        }

        return ans;
    }
}
