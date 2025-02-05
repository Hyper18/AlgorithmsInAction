package ref;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/03/03
 * 区间修改，区间查询
 */
public class R11_树状数组2 {
    private static int MAXD = 100007;
    private static int[] a = new int[MAXD];
    private static int[] sum1 = new int[MAXD];
    private static int[] sum2 = new int[MAXD];

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            // 输入初值并更新值（思想：查分）
            update(i, a[i] - a[i - 1], n);
        }

        // [x, y]区间累加k
        int x = in.nextInt();
        int y = in.nextInt();
        int k = in.nextInt();
        update(x, y, k);
        update(y + 1, -k, n);

        // 求区间和
        int sum = query(y) - query(x - 1);

        out.println(sum);

        in.close();
        out.close();
    }

    /**
     * 在i位置加上k
     *
     * @param i
     * @param k
     * @param n
     */
    private static void update(int i, int k, int n) {
        int x = i;
        while (x <= n) {
            sum1[x] += k;
            sum2[x] += k;
            x += lowbit(x);
        }
    }

    /**
     * 求前缀和
     *
     * @param i
     * @return
     */
    private static int query(int i) {
        int ans = 0;
        int x = i;

        while (x > 0) {
            ans += i * sum1[x] - sum2[x];
            x -= lowbit(x);
        }

        return ans;
    }

    private static int lowbit(int x) {
        return x & (-x);
    }
}
