package ref;

/**
 * @author Hyperspace
 * @date 2022/03/16
 */
public class R21_数论_最大公约数和最小公倍数 {
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
