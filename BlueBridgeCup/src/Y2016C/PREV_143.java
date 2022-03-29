package Y2016C;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/29
 * @time 359ms
 * <p>
 * 由于本题的测试数据范围给的比较小，
 * 因此可以直接使用long类型完成而不会溢出
 * 而当数据量更大时，可考虑使用BigInteger类处理
 */
public class PREV_143 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer(" ");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        long n = nextLong();
        long ans = Long.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            long num = i;
            long max = num;
            while (num != 1) {
                if (num % 2 == 0) {
                    num /= 2;
                } else {
                    num = num * 3 + 1;
                }
                max = Math.max(max, num);
            }
            ans = Math.max(ans, max);
        }

        out.println(ans);

        close();
    }

    private static long nextLong() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Long.parseLong(tk.nextToken());
    }

    private static void close() throws IOException {
        in.close();
        out.close();
    }
}
