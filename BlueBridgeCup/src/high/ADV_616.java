package high;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/14
 */
public class ADV_616 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static int[] nums;
    private static List<String> res = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        backtrack(0);

        Collections.sort(res);
        for (String str : res) {
            out.println(str);
        }

        close();
    }

    private static void backtrack(int idx) {
        if (idx == n) {
            StringBuilder sb = new StringBuilder();
            for (int num : nums) {
                sb.append("    " + num);
            }
            res.add(sb.toString());
            return;
        }
        for (int i = idx; i < n; i++) {
            swap(i, idx);
            backtrack(idx + 1);
            swap(i, idx);
        }
    }

    private static void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
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
