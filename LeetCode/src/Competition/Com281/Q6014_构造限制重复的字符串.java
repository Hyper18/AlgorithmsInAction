package Competition.Com281;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyper
 * @date 2022/02/20
 * <p>
 * 没pass
 * 双指针，一个外层按照字典序从大到小遍历
 * 一个内层找到第一个小于指针r对应的字符c字典序的剩余数量大于0的字符
 */
public class Q6014_构造限制重复的字符串 {
    public static void main(String[] args) {
        repeatLimitedString2("aababab", 2);
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

    public static String repeatLimitedString2(String s, int repeatLimit) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 25; r >= 0; r--) {
            if (cnt[r] == 0) {
                continue;
            }
            char c = (char) (r + 'a');
            while (cnt[r] > 0) {
                if (sb.length() > 0) {
                    if (sb.charAt(sb.length() - 1) == c) {
                        for (int l = r - 1; l >= 0; l--) {
                            if (cnt[l] > 0) {
                                cnt[l]--;
                                sb.append((char) (l + 'a'));
                                break;
                            }
                        }
                        if (sb.charAt(sb.length() - 1) == c) {
                            break;
                        }
                    }
                }
                for (int i = 0; i < Math.min(cnt[r], repeatLimit); i++) {
                    sb.append(c);
                }
                cnt[r] -= Math.min(cnt[r], repeatLimit);
            }
        }

        return sb.toString();
    }
}
