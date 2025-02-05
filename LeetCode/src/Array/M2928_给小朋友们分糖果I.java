package Array;

/**
 * @author Hyper
 * @date 2024/06/01
 * @file M2928_给小朋友们分糖果I.java
 * <p>
 * 思路
 * 模拟
 */
public class M2928_给小朋友们分糖果I {
    public int distributeCandies(int n, int limit) {
        if (n / 3 > limit) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                if (i + j <= n && n - i - j <= limit) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
