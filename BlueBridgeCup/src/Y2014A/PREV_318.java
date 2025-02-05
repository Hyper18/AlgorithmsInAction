package Y2014A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/17
 * @time 312ms
 * 转化为01背包问题
 * s：背包最大容量
 */
public class PREV_318 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MOD = 100000000 + 7;
    private static final int MAXN = 1000000 + 10;
    private static int[] dp = new int[MAXN];
    static int n;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        int s = nextInt();
        int a = nextInt();
        int b = nextInt();

        int num = (n - 1) * n / 2;
        s += num * b;
        // key step：后续如果直接强转会出现截断
        long optNum = a + b;
        init();
        int ans = 0;
        for (int i = 0; i <= num; i++) {
            long tmp = s - i * optNum;
            if (tmp % n == 0) {
                ans = (ans + dp[i]) % MOD;
            }
        }

        out.println(ans);

        close();
    }

    private static void init() {
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = (i + 1) * i / 2; j >= i; j--) {
                dp[j] = (dp[j] + dp[j - i]) % MOD;
            }
        }
    }

    public static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(token.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
