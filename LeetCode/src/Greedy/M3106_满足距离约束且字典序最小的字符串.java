package Greedy;

/**
 * @author Hyperspace
 * @date 2024/07/27
 * @file M3106_满足距离约束且字典序最小的字符串.java
 * <p>
 * 思路
 * 贪心
 */
public class M3106_满足距离约束且字典序最小的字符串 {
    public String getSmallestString(String s, int k) {
        int n = s.length();
        char[] ss = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int c = ss[i];
            int dis = Math.min(c - 'a', 'z' - c + 1);
            if (dis > k) {
                c -= k;
                break;
            }
            c = 'a';
            k -= dis;
        }

        return new String(ss);
    }
}
