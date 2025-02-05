package Math;

/**
 * @author Hyper
 * @date 2024/07/03
 * @file M3099_哈沙德数.java
 * <p>
 * 思路
 * 模拟
 */
public class M3099_哈沙德数 {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int ans = 0, t = x;
        while (t / 10 > 0) {
            ans += t % 10;
            t /= 10;
        }
        ans += t;

        return x % ans == 0 ? ans : -1;
    }
}
