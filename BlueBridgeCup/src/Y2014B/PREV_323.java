package Y2014B;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/21
 * @time 156ms
 * 模拟
 * 注意首元和末元处理
 */
public class PREV_323 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = nextInt();
        }

        while (getMax(nums) != getMin(nums)) {
            int last = nums[n - 1];
            nums[n - 1] += nums[0] / 2;
            nums[0] /= 2;

            for (int i = 1; i < n - 1; i++) {
                nums[i - 1] += nums[i] / 2;
                nums[i] /= 2;
            }

            nums[n - 2] += last / 2;
            nums[n - 1] -= last / 2;

            for (int i = 0; i < n; i++) {
                if (nums[i] % 2 != 0) {
                    nums[i]++;
                    ans++;
                }
            }
        }

        out.println(ans);

        close();
    }

    private static int getMax(int[] nums) {
        return Arrays.stream(nums).max().getAsInt();
    }

    private static int getMin(int[] nums) {
        return Arrays.stream(nums).min().getAsInt();
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
