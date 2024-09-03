package Fundamentals.TwoPointer;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/05
 * <p>
 * 思路
 * 朴素做法，set去重加模拟
 * O(n^2) TLE预定
 */
public class Q799_最长连续不重复子序列 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 100000 + 10;
    private static int[] a = new int[N];

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        Set<Integer> set;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            set = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (!set.add(a[j])) {
                    ans = Math.max(ans, set.size());
                    if (set.size() > a.length - 1 - j) {
                        break;
                    }
                    set = new HashSet<>();
                }
            }
            ans = Math.max(ans, set.size());
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
