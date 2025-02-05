package Greedy;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/03/27
 * 双指针 + 贪心
 */
public class Q455_分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0, p1 = 0, p2 = 0;
        while (p1 < g.length && p2 < s.length) {
            if (g[p1] <= s[p2]) {
                p1++;
                ans++;
            }
            p2++;
        }
        return ans;
    }
}
