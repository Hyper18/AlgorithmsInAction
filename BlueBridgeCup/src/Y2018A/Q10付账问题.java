package Y2018A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/04/05
 * 贪心
 * 分为两堆，对小于b_avg的顾客，付其所能给出的最大值
 * 对大于，则将前一堆中未付的总和/这一堆的数目
 * 代入公式
 */
public class Q10付账问题 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int MAX = 100000 + 10;
    private static int[] nums = new int[MAX];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int S = nextInt();
        for (int i = 0; i < n; i++) {
            nums[i] = nextInt();
        }
        double b_avg = (double) S / n;
        double sum = 0.0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if ((double) nums[i] < b_avg) {
                sum += b_avg - nums[i];
                cnt++;
            }
        }
        double diff_avg = sum / (n - cnt);
        double ans = 0;
        for (int i = 0; i < n; i++) {
            if ((double) nums[i] < b_avg) {
                ans += getVariance(nums[i], b_avg);
            } else {
                ans += getVariance(b_avg + diff_avg, b_avg);
            }
        }
        ans = Math.sqrt(ans / n);

        out.printf("%.4f", ans);

        close();
    }

    private static double getVariance(double bi, double b_avg) {
        return (bi - b_avg) * (bi - b_avg);
    }

    private static int nextInt() throws IOException {
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
