package practice.practice3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/07
 * @time 109ms
 */
public class F_算法提高_项链 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static StringBuilder sb;
    private static int len;

    public static void main(String[] args) throws IOException {
        String s = nextString();
        int max = 0;
        len = s.length();
        for (int i = 0; i < len; i++) {
            sb = new StringBuilder();
            sb.append(s.substring(len - 1 - i)).append(s, 0, len - i);
            int curMax = breakNecklace(sb.toString().toCharArray());
            max = Math.max(max, curMax);
        }

        out.println(max);

        close();
    }

    private static int breakNecklace(char[] s) {
        int cnt = 0;
        char color = ' ';
        for (int i = 0; i < len; i++) {
            if (s[i] == 'w') {
                cnt++;
            } else {
                if (color == ' ') {
                    color = s[i];
                    cnt++;
                } else if (s[i] == color) {
                    cnt++;
                } else {
                    break;
                }
            }
        }

        color = ' ';
        // 注：循环条件令i>=cnt，避免重复计数
        for (int i = len - 1; i >= cnt; i--) {
            if (s[i] == 'w') {
                cnt++;
            } else {
                if (color == ' ') {
                    color = s[i];
                    cnt++;
                } else if (s[i] == color) {
                    cnt++;
                } else {
                    break;
                }
            }
        }

        return cnt;
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