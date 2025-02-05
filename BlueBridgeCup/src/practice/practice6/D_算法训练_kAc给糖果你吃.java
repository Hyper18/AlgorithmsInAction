package practice.practice6;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/03/20
 * @time 78ms
 * 与其说是贪心还是比较暴力的做法。。
 * <p>
 * 注意糖果总数的数据范围上限是爆int的
 */
public class D_算法训练_kAc给糖果你吃 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static long ans = 0;

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        Arrays.sort(a);
        int idx = n - 1;
        int cnt = 0;
        while (cnt < m) {
            ans += a[idx--];
            cnt++;
        }

        out.println(ans);

        close();
    }

    private static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(token.nextToken());
    }

    private static void close() throws IOException {
        in.close();
        out.close();
    }
}
