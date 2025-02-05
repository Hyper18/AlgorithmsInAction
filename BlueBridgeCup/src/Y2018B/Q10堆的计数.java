package Y2018B;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/04/06
 * 全排列
 * 小数据量（20以内）可行
 */
public class Q10堆的计数 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static int[] nums;
    static int n, ans = 0;

    public static void main(String[] args) throws IOException {
        int N = nextInt();

        nums = new int[N];
        n = nums.length - 1;
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }
        fullSort(0);

        out.println(ans);

        close();
    }

    private static void fullSort(int k) {
        if (k == n) {
            if (check()) {
                ans++;
            }
            return;
        }
        for (int i = k; i <= n; i++) {
            {
                int t = nums[i];
                nums[i] = nums[k];
                nums[k] = t;
            }
            fullSort(k + 1);
            {
                int t = nums[i];
                nums[i] = nums[k];
                nums[k] = t;
            }
        }
    }

    private static boolean check() {
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if ((i * 2 + 1) < nums.length && (i * 2 + 2) < nums.length && nums[i] < nums[i * 2 + 1]
                    && nums[i] < nums[i * 2 + 2]) {
                flag = true;
            } else if ((i * 2 + 1) < nums.length && (i * 2 + 2) >= nums.length && nums[i] < nums[i * 2 + 1]) {
                flag = true;
            } else if ((i * 2 + 1) >= nums.length) {
                flag = true;
            } else {
                return false;
            }
        }
        return flag;
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
