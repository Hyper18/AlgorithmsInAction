package Y2021B;

import java.math.BigInteger;

public class D {
    private static final BigInteger N = new BigInteger("2021041820210418");
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger ZERO = BigInteger.valueOf(0);

    public static void main(String[] args) {
        long ans = 0;
        for (BigInteger a = BigInteger.valueOf(1); a.compareTo(N) <= 0; a = a.add(ONE)) {
            for (BigInteger b = BigInteger.valueOf(1); b.compareTo(N) <= 0; b = b.add(ONE)) {
                BigInteger c = N.divide(a).divide(b);
                if (c.compareTo(ZERO) < 0) {
                    continue;
                }
                if (a.multiply(b).multiply(c).compareTo(N) == 0) {
                    ans++;
//					System.out.printf("%d %d %d\n", a, b, c);
                }
            }
        }
        System.out.println(ans);
    }
}
