package Y2018A;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/04/05
 * 枚举
 * 60/100
 * <p>
 * 待优化
 */
public class PREV_98倍数问题 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer(" ");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int K = nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = nextInt();
        }

        int max = 0;
        Arrays.sort(nums);
        for (int i = n - 1; i - 2 >= 0; i--) {
            for (int j = i - 1; j - 1 >= 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum % K == 0) {
                        max = Math.max(max, sum);
                    }
                }
            }
        }

        out.println(max);

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
