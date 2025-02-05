package Y2020B1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/04/07
 * 01背包
 */
public class D分配口罩 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int[] masks = new int[15];
        for (int i = 0; i < masks.length; i++) {
            masks[i] = nextInt();
        }

        int sum = Arrays.stream(masks).sum();
        int half = sum / 2;
        int[] dp = new int[sum + 10];

        for (int i = 0; i < masks.length; i++) {
            for (int j = half; j >= masks[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - masks[i]] + masks[i]);
            }
        }

        out.println(sum - 2 * dp[half]);

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
