package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/07
 * <p>
 * 思路
 * 全排列
 * 首先根据n的值给定数组的大小
 * 对于每个可能的方案，每次回溯交换相邻的数字
 * 并顺次加入List中
 * 最后应用sort对输出的结果进行字典序排序
 */
public class Q842_排列数字 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(System.out);
    private static int[] nums;
    private static List<String> res = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        backtrack(0);

        Collections.sort(res);
        for (String s : res) {
            out.println(s);
        }

        close();
    }

    private static void backtrack(int k) {
        if (n == k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    sb.append(nums[i]);
                    break;
                }
                sb.append(nums[i] + " ");
            }
            res.add(sb.toString());
            return;
        }
        for (int i = k; i < n; i++) {
            swap(i, k);
            backtrack(k + 1);
            swap(i, k);
        }
    }

    private static void swap(int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
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
