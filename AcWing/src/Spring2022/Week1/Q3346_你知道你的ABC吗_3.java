package Spring2022.Week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/04/30
 */
public class Q3346_你知道你的ABC吗_3 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int[] nums = new int[7];
        for (int i = 0; i < 7; i++) {
            nums[i] = nextInt();
        }

        Arrays.sort(nums);
        out.printf("%d %d %d", nums[0], nums[1], nums[6] - nums[0] - nums[1]);

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
