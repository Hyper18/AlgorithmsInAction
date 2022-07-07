package T202206;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/07/07
 */
public class Q2 {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tk = new StringTokenizer("");
    private static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static boolean[][] a, b;
    private static int n, l, s;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        l = nextInt();
        s = nextInt();
        a = new boolean[l + 1][l + 1];
        b = new boolean[s + 1][s + 1];
        for (int i = 0; i < n; i++) {
            a[nextInt()][nextInt()] = true;
        }
        for (int i = s; i >= 0; i--) {
            for (int j = 0; j <= s; j++) {
                if (nextInt() == 1) {
                    b[i][j] = true;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= l - s; i++) {
            for (int j = 0; j <= l - s; j++) {
                if (!a[i][j]) {
                    continue;
                }
                ans += check(i, j);
            }
        }
        out.println(ans);

        close();
    }

    private static int check(int x, int y) {
        for (int i = 0; i <= s; i++) {
            for (int j = 0; j <= s; j++) {
                if (a[x + i][y + j] != b[i][j]) {
                    return 0;
                }
            }
        }

        return 1;
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
