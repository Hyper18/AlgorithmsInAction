package ref;

/**
 * @author Hyperspace
 * @date 2022/03/20
 */
public class R22_数论_求某数的最大质因子 {
    public int maxPrimeFactor(int n) {
        int i, ans = 0;
        for (i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                ans = i;
                n /= i;
            }
        }
        if (n > 1) {
            ans = n;
        }
        return ans;
    }
}
