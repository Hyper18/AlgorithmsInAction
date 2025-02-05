package Y2017A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/31
 * @time 78ms
 * 容易想到求最小公倍数+完全背包
 * 这里的问题在于：
 * 1. 需要找到有无穷多种解的条件
 * 2. 开dp的大小（即上界）-- a * b - a - b
 * 从数学角度，最多需要的空间为100 * 100 -200 = 9800
 */
public class PREV_195 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer(" ");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAX = 100 + 10;
    private static boolean[] dp = new boolean[MAX * MAX];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        dp[0] = true;
        int num = 0;
        for (int i = 1; i <= n; i++) {
            int ai = nextInt();
            if (i == 1) {
                num = ai;
            }
            num = gcd(num, ai);

            for (int j = 0; j < MAX * MAX; j++) {
                if (dp[j] && j + ai < MAX * MAX) {
                    dp[j + ai] = true;
                }
            }
        }

        if (num != 1) {
            out.println("INF");
        } else {
            int ans = 0;
            for (int i = 0; i < MAX * MAX; i++) {
                if (!dp[i]) {
                    ans++;
                }
            }
            out.println(ans);
        }

        close();
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
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
