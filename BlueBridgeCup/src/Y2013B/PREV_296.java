package Y2013B;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/15
 * @time 109ms
 */
public class PREV_296 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = nextInt();
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int max = nums[i];
            int min = nums[i];
            for (int j = i; j <= n; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
                if (nums[j] < min) {
                    min = nums[j];
                }
                if (i == j) {
                    ans++;
                } else {
                    if (j - i == max - min) {
                        ans++;
                    }
                }
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

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
