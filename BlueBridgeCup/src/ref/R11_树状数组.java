package ref;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/03/03
 * 单点修改，区间查询
 */
public class R11_树状数组 {
    private static int MAXD = 100007;
    private static int[] a = new int[MAXD];
    private static int[] tree = new int[MAXD];

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        in.close();
        out.close();
    }

    /**
     * 在x位置上累加k
     * 单点修改
     *
     * @param x
     * @param k
     * @param n 数组最大值
     */
    private static void update(int x, int k, int n) {
        while (x <= n) {
            tree[x] += k;
            x += lowbit(x);
        }
    }

    /**
     * 区间查询：1-x的前缀和
     *
     * @param x
     * @return
     */
    private static int query(int x) {
        int ans = 0;
        while (x > 0) {
            ans += tree[x];
            x -= lowbit(x);
        }

        return ans;
    }

    private static int lowbit(int x) {
        return x & (-x);
    }
}
