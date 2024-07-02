package String;

/**
 * @author Hyperspace
 * @date 2024/06/27
 * @file M2734_执行子串操作后的字典序最小字符串.java
 * <p>
 * 思路
 * 贪心
 * 1. 究极丑陋的模拟
 * 2. 改进的模拟
 * <p>
 * 重点在于题干的 恰好一次，因此需要记录是否修改
 * 若未修改，则仍需要进行一次操作（且最后一位也为 a）
 * 为了使影响最小，将末尾的字母直接替换为 z 即可
 */
public class M2734_执行子串操作后的字典序最小字符串 {
    public String smallestString(String s) {
        int n = s.length();
        int mn = 'z';
        for (char c : s.toCharArray()) {
            if (c < mn) {
                mn = c;
            }
        }
        int l = 0, cnt = 0;
        StringBuilder sb = new StringBuilder();
        if (mn == 'a') {
            while (l < n && s.charAt(l) == mn) {
                sb.append(s.charAt(l));
                l++;
            }
            while (l < n && s.charAt(l) != mn) {
                sb.append((char) (s.charAt(l) - 1));
                cnt++;
                l++;
            }
            sb.append(s.substring(l));
        } else {
            while (l < n) {
                sb.append((char) (s.charAt(l) - 1));
                cnt++;
                l++;
            }
        }

        if (cnt == 0) {
            return s.substring(0, n - 1) + (s.charAt(n - 1) == 'a' ? 'z' : (char) (s.charAt(n - 1) - 1));
        }
        return sb.toString();
    }

    public String smallestString2(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (c[i] != 'a') {
                c[i] = (char) (c[i] - 1);
                if (!flag) {
                    flag = true;
                }
            } else if (flag) {
                break;
            }
        }
        if (!flag) {
            c[n - 1] = 'z';
        }

        return new String(c);
    }
}