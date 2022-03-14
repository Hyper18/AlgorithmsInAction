package Y2013A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/14
 * @time 203ms
 */
public class PREV_293带分数 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static int n, ans = 0;

    public static void main(String[] args) throws IOException {
        n = nextInt();

        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        f(nums, 0);

        out.println(ans);

        close();
    }

    private static void f(int[] nums, int k) {
        if (k == 9) {
            check(nums);
            return;
        }
        for (int i = k; i < nums.length; i++) {
            swap(nums, i, k);
            f(nums, k + 1);
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

    private static void check(int[] nums) {
        // 根据题目给出的n的范围，其整数部分的最大长度为7
        for (int i = 0; i <= 7; i++) {
            int num1 = toInt(nums, 0, i);
            if (num1 >= n) {
                continue;
            }
            for (int j = 1; j <= 8 - i; j++) {
                int numerator = toInt(nums, i, j);
                int denominator = toInt(nums, i + j, 9 - (i + j));
                if (numerator % denominator == 0 && num1 + numerator / denominator == n) {
                    ans++;
                }
            }
        }
    }

    private static int toInt(int[] nums, int pos, int len) {
        int helper = 1;
        int num = 0;
        for (int i = pos + len - 1; i >= pos; i--) {
            num += nums[i] * helper;
            helper *= 10;
        }

        return num;
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