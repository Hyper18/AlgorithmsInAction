package Algorithm_BasicLevel;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/06
 */
public class Q800_数组元素的目标和 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100000 + 10;
    private static int[] a = new int[N], b = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt(), x = nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = nextInt();
        }

        for (int i = 0, j = m - 1; i < n; i++) {
            while (j >= 0 && a[i] + b[j] >= x) {
                if (a[i] + b[j] == x) {
                    out.printf("%d %d", i, j);
                    close();
                    System.exit(0);
                }
                j--;
            }
        }
    }

    public static int nextInt() throws IOException {
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
