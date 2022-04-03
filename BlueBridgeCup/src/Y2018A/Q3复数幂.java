package Y2018A;

import java.math.BigInteger;

/**
 * @author Hyperspace
 * @date 2022/04/03
 */
public class Q3复数幂 {
    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger THREE = BigInteger.valueOf(3);

    public static void main(String[] args) {
        int target = 123456;
        BigInteger a = TWO;
        BigInteger b = THREE;
        BigInteger tmp;
        while (target-- > 1) {
            tmp = a.multiply(TWO).subtract(b.multiply(THREE));
            b = a.multiply(THREE).add(b.multiply(TWO));
            a = tmp;
        }
        if (b.compareTo(ZERO) > 0) {
            System.out.printf("%d+%di", a, b);
        } else {
            System.out.printf("%d%di", a, b);
        }
    }
}
