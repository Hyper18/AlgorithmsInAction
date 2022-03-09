package practice5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/09
 * @time 78ms
 */
public class A_算法训练_无聊的逗 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        long[] nums = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = nextLong();
            sum += nums[i];
        }

        Arrays.sort(nums);
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (ans + nums[i] <= sum / 2) {
                ans += nums[i];
            }
        }

        out.println(ans);

        close();
    }

    public static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(token.nextToken());
    }

    public static long nextLong() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Long.parseLong(token.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}