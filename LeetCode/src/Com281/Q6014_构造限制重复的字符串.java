package Com281;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2022/02/20
 */
public class Q6014_构造限制重复的字符串 {
    public static void main(String[] args) {
        repeatLimitedString("aababab", 2);
    }

    public static String repeatLimitedString(String s, int repeatLimit) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }

        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 3; j > 0; j--) {
                if (map.get(chars[i]) > 0) {
                    sb.append(chars[i]);
                    map.put(chars[i], map.get(chars[i]) - 1);
                } else {
                    break;
                }
            }
        }
        String ans = sb.toString();
        char[] res = ans.toCharArray();
        for (int i = repeatLimit - 1; i < res.length; i++) {
            int pre = i - repeatLimit + 1;
            if (pre >= 0 && res[pre] != res[i]) {
                continue;
            } else if (pre >= 0) {
                if (i + 1 < res.length) {
                    char tmp = res[i];
                    res[i] = res[i + 1];
                    res[i + 1] = tmp;
                } else if (i + 1 == res.length && res[i - 1] == res[i]) {
                    res[i] = ' ';
                }
            }
        }
        
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (res[i] != ' ') {
                sb2.append(res[i]);
            }
        }

        return sb2.toString();
    }
}
