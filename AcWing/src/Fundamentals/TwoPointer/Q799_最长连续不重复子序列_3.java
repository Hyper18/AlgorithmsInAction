package Fundamentals.TwoPointer;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/05
 * <p>
 * 思路 @yxc
 * 双指针，O(n)且无需重复清空或新开辟空间，很优秀的写法
 * (一开始写完朴素TLE看题解完全看不懂，后来写了个O(n)的AC了再看，悟了)
 */
public class Q799_最长连续不重复子序列_3 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100000 + 10;
    private static int[] a = new int[N], s = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        int ans = 0;
        for (int i = 0, j = 0; i < n; i++) {
            s[a[i]]++;
            while (j < i && s[a[j]] > 1) {
                s[a[j++]]--;
            }
            ans = Math.max(ans, i - j + 1);
        }

        out.println(ans);

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
