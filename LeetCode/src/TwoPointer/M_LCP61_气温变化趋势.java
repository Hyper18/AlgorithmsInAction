package TwoPointer;

/**
 * @author Hyper
 * @date 2024/06/21
 * @file M_LCP61_气温变化趋势.java
 * <p>
 * 思路
 * 双指针
 * 注意结果处理，最后一个已出循环需要再判断一次
 */
public class M_LCP61_气温变化趋势 {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;
        int ans = 0, l = 0, r = 0;
        for (; r < n - 1; r++) {
            if (!check(temperatureA[r] - temperatureA[r + 1], temperatureB[r] - temperatureB[r + 1])) {
                ans = Math.max(ans, r - l);
                l = r + 1;
            }
        }

        return Math.max(ans, r - l);
    }

    private boolean check(int a, int b) {
        boolean c1 = a > 0 && b > 0, c2 = a == 0 && b == 0, c3 = a < 0 && b < 0;
        return c1 || c2 || c3;
    }
}
