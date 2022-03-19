package practice.practice3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/07
 * @time 78ms
 */
public class D_算法提高_递归倒置字符数组 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static int n;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        String s = nextString();

        char[] res = reverse(s.toCharArray(), 0, n - 1);

        out.println();
        print(res);

        close();
    }

    private static void print(char[] s) {
        sb = new StringBuilder();
        for (char c : s) {
            sb.append(c);
        }
        out.println(sb.toString());
    }

    private static char[] reverse(char[] s, int start, int end) {
        if (start >= end) {
            return s;
        }

        char tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;

        print(s);

        return reverse(s, start + 1, end - 1);
    }

    public static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(token.nextToken());
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
