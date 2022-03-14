package ref;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/14
 * 回溯算法的运用：用于求取全排列
 * 如：输入3，得到1—3的全排列
 * 共有6种可能的情况，分别是：
 * 123
 * 132
 * 213
 * 231
 * 321
 * 312
 */
public class R20_回溯算法 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static int n, ans = 0;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        f(nums, 0);

        close();
    }

    private static void f(int[] nums, int k) {
        if (k == n) {
            if (check(nums)) {
                ans++;
                print(nums);
            }
        }
        for (int i = k; i < nums.length; i++) {
            // 交换第i位和第k位
            swap(nums, i, k);
            // 移交给下一层确认k+1位
            f(nums, k + 1);
            // 操作结束后，交换回原位置
            swap(nums, i, k);
        }
    }

    private static void print(int[] nums) {
        for (int num : nums) {
            out.print(num);
        }
        out.println();
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private static boolean check(int[] nums) {
        // 实际题目中需要检查的条件
        return true;
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
