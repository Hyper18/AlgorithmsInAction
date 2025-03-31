package String;

/**
 * @author Hyperspace
 * @date 2025/03/31
 * @file M2278_字母在字符串中的百分比.java
 * <p>
 * 思路
 * 模拟
 */
public class M2278_字母在字符串中的百分比 {
    public int percentageLetter(String s, char letter) {
        int n = s.length();
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == letter) {
                cnt++;
            }
        }

        return (int) Math.floor(cnt * 100D / n);
    }

    public int percentageLetter2(String s, char letter) {
        int n = s.length();
        return (int) s.chars().filter(c -> c == letter).count() * 100 / n;
    }
}
