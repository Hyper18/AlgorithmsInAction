package DP.DigitDP;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/11/23
 * @file Q1081_度的数量.java
 * <p>
 * 果然数位dp很难想。。
 * 令每位的值为x，分类讨论：
 * 1）x == 0 无法做左右分支，不考虑
 * 2）x == 1 第i位选0
 * 3）x > 1  第i位选0或1
 */
public class Q1081_度的数量 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 35;
    static int[][] c = new int[N][N];
    static int K, B;

    private static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    c[i][j] = 1;
                } else {
                    c[i][j] = c[i - 1][j] + c[i - 1][j - 1];
                }
            }
        }
    }

    private static int f(int n) {
        // 1. 判断边界条件
        if (n == 0) {
            return 0;
        }

        // 2. 对B进制截取各位
        List<Integer> nums = new ArrayList<>();
        while (n != 0) {
            nums.add(n % B);
            n /= B;
        }

        // 3. 从最高位开始遍历每位
        int ans = 0, last = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            int x = nums.get(i);
            if (x > 0) {
                ans += c[i][K - last];
                if (x == 1) {
                    last++;
                    if (last > K) {
                        break;
                    }
                } else {
                    if (K - last - 1 >= 0) {
                        ans += c[i][K - last - 1];
                    }
                    break;
                }
            }

            if (i == 0 && K == last) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        init();
        int l = nextInt(), r = nextInt();
        K = nextInt();
        B = nextInt();
        out.println(f(r) - f(l - 1));
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
