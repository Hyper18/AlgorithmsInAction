package Math;

/**
 * @author Hyperspace
 * @date 2023/07/12
 * @file M2544_交替数字和.java
 */
public class M2544_交替数字和 {
    public static int alternateDigitSum(int n) {
        int ans = 0, cnt = 0;
        while (n > 0) {
            ans += (cnt + 2) % 2 == 0 ? n % 10 : -n % 10;
            n /= 10;
            cnt++;
        }

        return cnt % 2 == 0 ? -ans : ans;
    }
}
