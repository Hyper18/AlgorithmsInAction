package String;

/**
 * @author Hyper
 * @date 2022/12/03
 * @file M1796_字符串中第二大的数字.java
 * <p>
 * 思路
 * 模拟
 */
public class M1796_字符串中第二大的数字 {
    public int secondHighest(String s) {
        int max = -1, ans = -1;
        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9') {
                continue;
            }
            int cur = c - '0';
            if (cur > max) {
                ans = max;
                max = cur;
            }
            if (cur > ans && cur < max) {
                ans = cur;
            }
        }

        return ans;
    }
}
