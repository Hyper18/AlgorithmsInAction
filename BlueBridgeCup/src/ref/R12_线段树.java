package ref;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/03/03
 */
public class R12_线段树 {
    private static int MAXD = 100007;
    private static int[] a = new int[MAXD];
    private static int[] tree = new int[MAXD * 4];

    private static void build(int p, int l, int r) {
        if (l == r) {
            tree[p] = a[l];
            return;
        }
        int mid = (l + r) / 2;
        build(p * 2, l, mid);
        build(p * 2 + 1, mid + 1, r);
        tree[p] = tree[p * 2] + tree[p * 2 + 1];
    }

    public static void update(int p, int l, int r, int x, int num) {
        if (x > r || x < l) {
            return;
        }
        if (l == r && l == x) {
            tree[p] += num;
            return;
        }
        int mid = (l + r) / 2;
        update(p * 2, l, mid, x, num);
        update(p * 2 + 1, mid + 1, r, x, num);
        tree[p] = tree[p * 2] + tree[p * 2 + 1];
    }

    private static int query(int p, int l, int r, int x, int y) {
        if (x <= l && r <= y) {
            return tree[p];
        }
        if (x > r || y < l) {
            return 0;
        }
        int mid = (l + r) / 2;
        int sum = 0;

        sum += query(p * 2, l, mid, x, y);
        sum += query(p * 2 + 1, mid + 1, r, x, y);

        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = in.nextInt();
        int m = in.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }

        build(1, 1, n);
        for (int i = 1; i <= m; i++) {
            int a1 = in.nextInt();
            int a2 = in.nextInt();
            int a3 = in.nextInt();

            if (a1 == 1) {
                update(1, 1, n, a2, a3);
            } else {
                System.out.println(query(1, 1, n, a2, a3));
            }
        }

        in.close();
        out.close();
    }
}
