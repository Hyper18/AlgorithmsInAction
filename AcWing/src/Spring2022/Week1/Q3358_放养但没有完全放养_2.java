package Spring2022.Week1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/04/30
 * 使用int数组替换hash，提高查找速度
 */
public class Q3358_放养但没有完全放养_2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        String order = next();
        int[] indexs = new int[26];
        for (int i = 0; i < 26; i++) {
            indexs[order.charAt(i) - 'a'] = i;
        }

        char[] input = next().toCharArray();
        int ans = 1;
        if (input.length == 1) {
            out.println(ans);
            System.exit(0);
        }
        for (int i = 1; i < input.length; i++) {
            if (indexs[input[i] - 'a'] - indexs[input[i - 1] - 'a'] <= 0) {
                ans++;
            }
        }

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
