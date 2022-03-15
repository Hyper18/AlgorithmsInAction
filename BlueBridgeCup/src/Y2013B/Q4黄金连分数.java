package Y2013B;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Hyperspace
 * @date 2022/03/15
 */
public class Q4黄金连分数 {
    public static void main(String[] args) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        int i = 300;
        while (i-- > 0) {
            BigInteger tmp = b;
            b = b.add(a);
            a = tmp;
        }
        BigDecimal ans = new BigDecimal(a, 110).divide(new BigDecimal(b, 110), BigDecimal.ROUND_HALF_DOWN);
        System.out.println(ans);
    }
}
