package Y2019B;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/04/07
 * @time 765ms
 * <p>
 * 初看没思路，考试就g了
 * 参考@Isgoose，前缀和+取数
 * 因为最后一位换不了，补一位s0前缀用于交换头尾
 */
public class J灵能传输 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static long[] a, pre;
    private static boolean[] vis;
    static int p0, pn;

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        while (t-- > 0) {
            int n = nextInt();
            init(n);

            long s0 = pre[0], sn = pre[n];
            Arrays.sort(pre);
            for (int i = 0; i <= n; i++) {
                if (s0 == pre[i]) {
                    p0 = i;
                    break;
                }
            }
            for (int i = n; i >= 0; i--) {
                if (sn == pre[i]) {
                    pn = i;
                    break;
                }
            }
            int l = 0, r = n;
            for (int i = p0; i >= 0; i -= 2) {
                a[l++] = pre[i];
                vis[i] = true;
            }
            for (int i = pn; i <= n; i += 2) {
                a[r--] = pre[i];
                vis[i] = true;
            }
            for (int i = 0; i <= n; i++) {
                if (!vis[i]) {
                    a[l++] = pre[i];
                }
            }

            long ans = 0;
            for (int i = 1; i <= n; i++) {
                ans = Math.max(ans, Math.abs(a[i] - a[i - 1]));
            }
            out.println(ans);
        }

        close();
    }

    private static void init(int n) throws IOException {
        pre = new long[n + 1];
        a = new long[n + 1];
        vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] += pre[i - 1] + nextInt();
        }
        if (pre[0] > pre[n]) {
            long tmp = pre[0];
            pre[0] = pre[n];
            pre[n] = tmp;
        }
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
