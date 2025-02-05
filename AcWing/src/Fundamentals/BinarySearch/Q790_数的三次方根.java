package Fundamentals.BinarySearch;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/03
 */
public class Q790_数的三次方根 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final double EPS = 1 / 10000000F;

    public static void main(String[] args) throws IOException {
        double n = nextDouble();
        double l = -100F, r = 100F;
        while (r - l > EPS) {
            double mid = (l + r) / 2;
            if (mid * mid * mid >= n) {
                r = mid;
            } else {
                l = mid;
            }
        }

        out.printf("%.6f\n", l);

        close();
    }

    public static double nextDouble() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Double.parseDouble(tk.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
