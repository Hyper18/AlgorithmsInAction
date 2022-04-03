package Y2017C;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/04/03
 * 先简化考虑：
 * 简单情况
 * 不考虑颜色时，比较*的位置取最小次数
 */
public class PREV_206青蛙跳杯子 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        String start = next();
        int startIdx = 0;
        int pos = 0;
        for (char c : start.toCharArray()) {
            if (c == '*') {
                startIdx = pos;
            }
            pos++;
        }
        int endIdx = 0;
        pos = 0;
        String end = next();
        for (char c : end.toCharArray()) {
            if (c == '*') {
                endIdx = pos;
            }
            pos++;
        }

        int diff = endIdx - startIdx;
        int mod = diff % 3;

        int ans = mod != 0 ? diff / 3 + 1 : diff / 3;
        out.println(ans);

        close();
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
