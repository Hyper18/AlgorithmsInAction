package Y2017A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/31
 * @time 187ms
 * 枚举的优化：将O(n^2)优化为O(log2n)
 * 以降低时间复杂度
 */
public class PREV_196_2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAX = 100000;
    private static int[] h = new int[MAX];
    private static int[] w = new int[MAX];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int k = nextInt();
        for (int i = 0; i < n; i++) {
            h[i] = nextInt();
            w[i] = nextInt();
        }
        int low = 0;
        int high = MAX;
        int ans = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += (w[i] / mid) * (h[i] / mid);
            }
            if (cnt >= k) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid;
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
