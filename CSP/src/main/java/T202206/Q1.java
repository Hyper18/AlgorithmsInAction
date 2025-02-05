package T202206;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/07/07
 */
public class Q1 {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tk = new StringTokenizer("");
    private static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1010;
    private static int[] f = new int[N];
    private static double[] t = new double[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            f[i] = nextInt();
            sum += f[i];
        }
        double avg = (double) sum / n;
        double d = 0;
        for (int i = 0; i < n; i++) {
            t[i] = f[i] - avg;
            d += t[i] * t[i];
        }
        d = Math.sqrt(d / n);
        for (int i = 0; i < n; i++) {
            out.println(t[i] / d);
        }

        close();
    }

    private static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
