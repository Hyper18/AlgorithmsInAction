package Y2016C;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/29
 * <p>
 * 使用BigInteger的做法
 * 87/100
 */
public class PREV_143_2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer(" ");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger THREE = BigInteger.valueOf(3);

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        BigInteger[] buf = new BigInteger[n + 1];
        buf[0] = ZERO;
        buf[1] = buf[2] = BigInteger.valueOf(4);
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                buf[i] = buf[i - 1];
                continue;
            }

            BigInteger max = buf[i - 1];
            BigInteger big = BigInteger.valueOf(i);
            while (big.compareTo(ONE) != 0) {
                if (big.compareTo(max) == 1) {
                    max = big;
                }
                if (big.compareTo(BigInteger.valueOf(i)) == -1) {
                    break;
                }
                big = big.mod(TWO).equals(ZERO) ? big.divide(TWO) : big.multiply(THREE).add(ONE);
            }
            buf[i] = max;
        }

        out.println(buf[n]);

        close();
    }

    private static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    private static void close() throws IOException {
        in.close();
        out.close();
    }
}
