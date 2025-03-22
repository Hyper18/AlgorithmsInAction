package Greedy;

/**
 * @author Hyperspace
 * @date 2025/03/23
 * @file M2116_判断一个括号字符串是否有效.java
 * <p>
 * 思路
 * 贪心
 */
public class M2116_判断一个括号字符串是否有效 {
    public boolean canBeValid(String s, String locked) {
        char[] cs = s.toCharArray(), ls = locked.toCharArray();
        int n = cs.length;
        if ((n & 1) == 1) {
            return false;
        }
        int mn = 0, mx = 0;
        for (int i = 0; i < n; i++) {
            if (ls[i] == '1') {
                int d = cs[i] == '(' ? 1 : -1;
                mx += d;
                if (mx < 0) {
                    return false;
                }
                mn += d;
            } else {
                mx++;
                mn--;
            }
            if (mn < 0) {
                mn = 1;
            }
        }

        return mn == 0;
    }
}
