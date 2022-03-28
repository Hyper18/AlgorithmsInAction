package Math;

/**
 * @author Hyperspace
 * @date 2022/03/28
 */
public class Q343_整数拆分 {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int q = n / 3;
        int re = n % 3;
        if (re == 0) {
            return (int) Math.pow(3, q);
        } else if (re == 1) {
            return (int) Math.pow(3, q - 1) * 4;
        } else {
            return (int) Math.pow(3, q) * 2;
        }
    }
}
