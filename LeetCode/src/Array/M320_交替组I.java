package Array;

/**
 * @author Hyperspace
 * @date 2024/11/26
 * @file M320_交替组I.java
 * <p>
 * 思路
 * 模拟
 */
public class M320_交替组I {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int ans = 0;
        for (int i = 2; i < n; i++) {
            ans += colors[i] != colors[i - 1] && colors[i - 1] != colors[i - 2] ? 1 : 0;
        }
        ans += colors[n - 1] != colors[n - 2] && colors[0] != colors[n - 1] ? 1 : 0;
        ans += colors[0] != colors[n - 1] && colors[1] != colors[0] ? 1 : 0;

        return ans;
    }

    public int numberOfAlternatingGroups2(int[] colors) {
        int n = colors.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += colors[i] != colors[(i - 1 + n) % n] && colors[(i - 1 + n) % n] != colors[(i - 2 + n) % n] ? 1 : 0;
        }

        return ans;
    }
}
