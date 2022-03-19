package practice.practice3;

import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/07
 * @time 125ms
 * <p>
 * 这题用java完全送分。。
 */
public class E_算法提高_实数相加 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        String s1 = nextString();
        String s2 = nextString();
        BigDecimal a = new BigDecimal(s1);
        BigDecimal b = new BigDecimal(s2);

        out.println(a.add(b));

        close();
    }

    public static String nextString() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return token.nextToken();
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}