package Y2015A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/22
 * @time 93ms
 * 矩阵 + 快速幂
 */
public class PREV_172_2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MOD = 1000000000 + 7;
    private static final int SIZE = 6;
    private static int[] op = new int[SIZE + 1];
    private static long[][] conflict = new long[SIZE][SIZE];
    static int n, m;

    private static void init() {
        op[1] = 4;
        op[2] = 5;
        op[3] = 6;
        op[4] = 1;
        op[5] = 2;
        op[6] = 3;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                conflict[i][j] = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        init();
        for (int i = 0; i < m; i++) {
            int a = nextInt();
            int b = nextInt();
            // 转换对应下标
            conflict[op[a] - 1][b - 1] = 0;
            conflict[op[b] - 1][a - 1] = 0;
        }

        long[][] myPow = pow(conflict, n - 1);

        // 累加矩阵的每个元素
        long ans = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                ans = (ans + myPow[i][j]) % MOD;
            }
        }

        // 计算总数
        out.println(ans * power(4L, n) % MOD);

        close();
    }

    /**
     * 实现一个矩阵的快速幂
     *
     * @param conflict 冲突数组
     * @param n        指数
     * @return 结果矩阵
     */
    private static long[][] pow(long[][] conflict, int n) {
        long[][] ans = new long[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == j) {
                    ans[i][j] = 1;
                }
            }
        }
        while (n != 0) {
            if ((n & 1) == 1) {
                ans = mul(ans, conflict);
            }
            conflict = mul(conflict, conflict);
            n >>= 1;
        }

        return ans;
    }

    /**
     * 实现一个长整型数的快速幂
     *
     * @param i 长整型数
     * @param n 指数
     * @return 结果
     */
    private static long power(long i, int n) {
        long ans = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans = (ans * i) % MOD;
            }
            i = (i * i) % MOD;
            n >>= 1;
        }

        return ans;
    }

    /**
     * 实现两矩阵做点乘
     *
     * @param a 矩阵A
     * @param b 矩阵B
     * @return 矩阵积得的结果
     */
    private static long[][] mul(long[][] a, long[][] b) {
        long[][] ans = new long[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < SIZE; k++) {
                    ans[i][j] = (ans[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }

        return ans;
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
