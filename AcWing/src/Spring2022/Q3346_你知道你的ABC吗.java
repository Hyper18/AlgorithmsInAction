package Spring2022;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/04/30
 */
public class Q3346_你知道你的ABC吗 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int[] nums = new int[7];
        int a = Integer.MAX_VALUE, sum = Integer.MIN_VALUE;
        for (int i = 0; i < 7; i++) {
            nums[i] = nextInt();
            if (nums[i] > sum) {
                sum = nums[i];
            }
            if (nums[i] < a) {
                a = nums[i];
            }
        }

        int bPlusC = sum - a;
        Arrays.sort(nums);
        int b = nums[1];
        int c = bPlusC - b;

        out.printf("%d %d %d", a, b, c);

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
