package Y2016A;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/26
 * @time 78ms
 * 首先很容易想到用冒泡
 * 但由于题目已经给定了是至少需要交换的次数
 * 而冒泡或逆序的方式均不能得到交换的最小值
 * <p>
 * 因此采用朴素做法，
 * 先统一下标，在当前下标与值不相等的情况下
 * 找到值现在所在的下标，并将两数交换
 */
public class PREV_148 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer(" ");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static int[] nums;
    private static int n, ans;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = nextInt();
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] != i) {
                swap(find(i), i);
                ans++;
            }
        }

        out.println(ans);
        for (int i = 1; i <= n; i++) {
            out.print(nums[i] + " ");
        }

        close();
    }

    private static int find(int i) {
        for (int pos = 1; pos <= n; pos++) {
            if (nums[pos] == i) {
                return pos;
            }
        }
        return -1;
    }

    private static void swap(int i, int j) {
        if (i == -1) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    private static void close() throws IOException {
        in.close();
        out.close();
    }
}
