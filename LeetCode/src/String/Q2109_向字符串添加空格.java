package String;

/**
 * @author Hyperspace
 * @date 2025/03/30
 * @file Q2109_向字符串添加空格.java
 * <p>
 * 思路
 * 模拟，双指针
 */
public class Q2109_向字符串添加空格 {
    public String addSpaces(String s, int[] spaces) {
        int n = spaces.length;
        StringBuilder sb = new StringBuilder();
        for (int l = 0, r = 0; r < n; r++) {
            sb.append(s, l, spaces[r]).append(" ");
            if (r == n - 1) {
                sb.append(s, spaces[r], s.length());
                break;
            }
            l = spaces[r];
        }

        return sb.toString();
    }
}
