package Y2015A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/22
 * 除了不能相对的面，骰子剩下的四个面
 * 作为分类问题的四种可能性
 */
public class PREV_172 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MOD = 1000000000 + 7;
    private static final int SIZE = 6 + 1;
    private static int[] op = new int[SIZE];
    private static boolean[][] conflict = new boolean[SIZE][SIZE];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        for (int i = 0; i < m; i++) {
            int a = nextInt();
            int b = nextInt();
            conflict[a][b] = true;
            conflict[b][a] = true;
        }
        init();
        long ans = 0;
        for (int up = 1; up <= 6; up++) {
            ans = (ans + 4 * f(up, n - 1)) % MOD;
        }

        out.println(ans);

        close();
    }

    private static long f(int up, int cnt) {
        if (cnt == 0) {
            return 4;
        }
        long ans = 0;
        for (int upp = 1; upp <= 6; upp++) {
            if (conflict[op[up]][upp]) {
                continue;
            }
            ans = (ans + f(upp, cnt - 1)) % MOD;
        }
        return ans;
    }

    private static void init() {
        op[1] = 4;
        op[2] = 5;
        op[3] = 6;
        op[4] = 1;
        op[5] = 2;
        op[6] = 3;
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
