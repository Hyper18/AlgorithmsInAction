package Y2017B;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/04/02
 * <p>
 * 思路：
 * 前缀和优化
 * 将j每次的存储空间减1
 */
public class PREV_201k倍区间_2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static long ans;

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int k = nextInt();

        int[] pre = new int[n + 1];
        int[] cnt = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = (pre[i - 1] + nextInt()) % k;
            ans += cnt[pre[i]]++;
        }

        out.println(ans + cnt[0]);

        close();
    }

    private static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    private static void close() throws IOException {
        in.close();
        out.close();
    }
}
