package Y2014B;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/21
 * @time 125ms
 * 想了巨久的题。。。
 * 主要在于原问题的转化
 * 难题，回看
 */
public class PREV_325 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        String str1 = nextString();
        String str2 = nextString();
        out.println(sqrt(str1).multiply(sqrt(str2)));
        close();
    }

    private static BigInteger sqrt(String s) {
        int len = s.length();
        if (len % 2 == 0) {
            len /= 2;
        } else {
            len = len / 2 + 1;
        }
        char[] chars = new char[len];
        Arrays.fill(chars, '0');

        BigInteger target = new BigInteger(s);
        for (int pos = 0; pos < len; pos++) {
            for (char c = '1'; c <= '9'; c++) {
                chars[pos] = c;
                BigInteger pow = new BigInteger(String.valueOf(chars)).pow(2);
                if (pow.compareTo(target) == 1) {
                    chars[pos] -= 1;
                    break;
                }
            }
        }

        return new BigInteger(String.valueOf(chars));
    }

    public static String nextString() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }

        return tk.nextToken();
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
