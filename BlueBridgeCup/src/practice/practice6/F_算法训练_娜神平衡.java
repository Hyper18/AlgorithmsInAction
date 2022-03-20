package practice.practice6;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/20
 * 80/100
 * 最后一个测试用例有点问题。。
 * <p>
 * 思路： dfs深搜
 */
public class F_算法训练_娜神平衡 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static boolean[] vis;
    private static int[] nums, a, b;
    static int n, r, l1 = 0, l2 = 0;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        init();
        dfs(0);
        close();
    }

    private static void dfs(int step) {
        if (Math.abs(sum(a) - sum(b)) > r) {
            return;
        }
        if (step == n) {
            Arrays.sort(a, 0, l1 - 1);
            Arrays.sort(b, 0, l2 - 1);
            for (int i = 0; i < l1; i++) {
                if (i == l1 - 1) {
                    out.println(a[i]);
                    break;
                }
                out.print(a[i] + " ");
            }
            for (int i = 0; i < l2; i++) {
                if (i == l2 - 1) {
                    out.println(b[i]);
                    break;
                }
                out.print(b[i] + " ");
            }
            flag = true;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (flag) {
                return;
            }
            if (!vis[i]) {
                a[l1++] = nums[i];
                vis[i] = true;
                dfs(step + 1);
                vis[i] = false;
                a[--l1] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            if (flag) {
                return;
            }
            if (l1 == 0) {
                return;
            }
            if (!vis[i]) {
                b[l2++] = nums[i];
                vis[i] = true;
                dfs(step + 1);
                vis[i] = false;
                b[--l2] = 0;
            }
        }
    }

    private static int sum(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    private static void init() throws IOException {
        n = nextInt();
        r = nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = nextInt();
        }
        a = new int[n];
        b = new int[n];
        vis = new boolean[n];
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
