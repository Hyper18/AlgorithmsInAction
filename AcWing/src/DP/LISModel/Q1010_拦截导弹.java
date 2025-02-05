package DP.LISModel;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/05/10
 * <p>
 * 思路 线性dp + 贪心
 * 1. 状态表示
 * 集合：f[i]所有以第i个元素结尾的LIS
 * 属性：
 * 1）单次导弹最多可以拦截的数目Max
 * 2）拦截所有导弹所需的最少系统数目Min
 * 2. 状态计算
 * f[i] = max(f[i], f[j] + 1)
 * 贪心法求最小数目，分类讨论如下：
 * 1）如果本次得到的子序列结尾小于当前数，则创建一个新序列
 * 2）否则，将该数放到结尾大于等于它的最小的子序列的后面
 */
public class Q1010_拦截导弹 {
    public static Scanner in = new Scanner((System.in));
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000 + 10;
    private static int[] h = new int[N];
    private static int[] f = new int[N], q = new int[N];
    static int n;

    public static void main(String[] args) throws IOException {
        while (in.hasNext()) {
            h[++n] = in.nextInt();
        }

        int ans = 0, cnt = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = 1;
            for (int j = 1; j < i; j++) {
                if (h[i] <= h[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);

            int k = 0;
            while (k < cnt && q[k] < h[i]) {
                k++;
            }
            if (k == cnt) {
                q[cnt++] = h[i];
            } else {
                q[k] = h[i];
            }
        }

        out.println(ans);
        out.println(cnt);

        close();
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
