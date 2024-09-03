package Fundamentals.BinarySearch;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/03
 */
public class Q789_数的范围 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100000 + 10;
    private static int[] q = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int Q = nextInt();
        for (int i = 0; i < n; i++) {
            q[i] = nextInt();
        }
        while (Q-- > 0) {
            int k = nextInt();
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + ((r - l) >> 1);
                if (q[mid] >= k) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            if (q[l] != k) {
                out.println("-1 -1");
            } else {
                out.print(l + " ");

                l = 0;
                r = n - 1;
                while (l < r) {
                    int mid = l + ((r - l + 1) >> 1);
                    if (q[mid] <= k) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }

                out.println(l + " ");
            }
        }

        close();
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
