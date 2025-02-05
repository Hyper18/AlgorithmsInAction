package Spring2022.Week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/05/02
 */
public class Q3745_牛的学术圈I {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100000 + 10;
    private static Integer[] c = new Integer[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int L = nextInt();
        for (int i = 1; i <= n; i++) {
            c[i] = nextInt();
        }

        Arrays.sort(c, 1, n + 1, (a, b) -> b - a);

        int ans = 0;
        for (int i = 1, j = n; i <= n; i++) {
            while (j > 0 && c[j] < i) {
                j--;
            }
            if (c[i] >= i - 1 && i - j <= L) {
                ans = i;
            }
        }

        out.println(ans);

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
