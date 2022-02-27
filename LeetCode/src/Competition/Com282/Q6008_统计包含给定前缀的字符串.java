package Competition.Com282;

/**
 * @author Hyperspace
 * @date 2022/02/27
 */
public class Q6008_统计包含给定前缀的字符串 {
    public int prefixCount(String[] words, String pref) {
        int cnt = 0;

        for (String word : words) {
            if (word.startsWith(pref)) {
                cnt++;
            }
        }

        return cnt;
    }
}
