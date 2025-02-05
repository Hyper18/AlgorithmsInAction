package DP.LinearDP;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/04
 */
public class Q896_最长上升子序列II {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100000 + 10;
    private static int[] a = new int[N], q = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        int len = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = len;
            while (l < r) {
                int mid = l + ((r - l + 1) >> 1);
                if (q[mid] < a[i]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            len = Math.max(len, r + 1);
            q[r + 1] = a[i];
        }

        out.println(len);

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
