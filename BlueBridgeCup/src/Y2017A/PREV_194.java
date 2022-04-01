package Y2017A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/31
 * @time 78ms
 * 多路径问题（少见考点）
 * 后面多看一下递归的不同题型
 */
public class PREV_194 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static String s;
    static int pos;

    public static void main(String[] args) throws IOException {
        s = nextString();
        int ans = f();
        out.println(ans);
        close();
    }

    private static int f() {
        int tmp = 0;
        int max = Integer.MIN_VALUE;
        while (pos < s.length()) {
            switch (s.charAt(pos)) {
                case '(':
                    pos++;
                    tmp += f();
                    break;
                case 'x':
                    pos++;
                    tmp++;
                    break;
                case '|':
                    pos++;
                    max = Math.max(max, tmp);
                    tmp = 0;
                    break;
                case ')':
                    pos++;
                    max = Math.max(max, tmp);
                    return max;
            }
        }

        return Math.max(max, tmp);
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
