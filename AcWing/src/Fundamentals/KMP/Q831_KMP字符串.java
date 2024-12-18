package Fundamentals.KMP;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2024/12/18
 * @file Q831_KMP字符串.java
 */
public class Q831_KMP字符串 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = (int) (1e5 + 10), M = (int) (1e6 + 10);
    private static int[] ne = new int[N];
    private static char[] s = new char[M], p = new char[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        char[] s1 = next().toCharArray();
        System.arraycopy(s1, 0, p, 1, s1.length);
        int m = nextInt();
        char[] s2 = next().toCharArray();
        System.arraycopy(s2, 0, s, 1, s2.length);
        for (int i = 2, j = 0; i <= n; i++) {
            while (j > 0 && p[i] != p[j + 1]) {
                j = ne[j];
            }
            if (p[i] == p[j + 1]) {
                j++;
            }
            ne[i] = j;
        }
        for (int i = 1, j = 0; i <= m; i++) {
            while (j > 0 && s[i] != p[j + 1]) {
                j = ne[j];
            }
            if (s[i] == p[j + 1]) {
                j++;
            }
            if (j == n) {
                out.printf("%d ", i - n);
                j = ne[j];
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

    public static String next() throws IOException {
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
