package Y2017A;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/03/31
 * 思路来自@wow_awsl_qwq
 * 线段树+扫描线，供学习
 * 待回看
 */
public class PREV_197_2 {
    private static final int N = 10000 + 10;
    static int n, x1, x2, y1, y2, m, res;

    static class segment {
        int x, y1, y2, k;

        public segment(int x, int y1, int y2, int k) {
            this.x = x;
            this.y1 = y1;
            this.y2 = y2;
            this.k = k;
        }
    }

    static segment seg[] = new segment[N * 2];

    static class node {
        int l, r, cnt, len;
    }

    static class mcomp implements Comparator<segment> {
        @Override
        public int compare(segment o1, segment o2) {
            return o1.x - o2.x;
        }
    }

    static node tr[] = new node[4 * N];

    static void pushup(int u) {
        if (tr[u].cnt > 0) tr[u].len = tr[u].r - tr[u].l + 1;
        else if (tr[u].l == tr[u].r) {
            tr[u].len = 0;
        } else {
            tr[u].len = tr[u << 1].len + tr[u << 1 | 1].len;
        }
    }

    static void build(int u, int l, int r) {
        tr[u] = new node();
        //类成员对象默认值为0，所以不用特地给cnt和len赋值
        tr[u].l = l;
        tr[u].r = r;
        if (l == r) return;
        int mid = l + r >> 1;
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
    }

    static void modify(int u, int l, int r, int k) {
        if (tr[u].l >= l && tr[u].r <= r) {
            tr[u].cnt += k;
            pushup(u);
        } else {
            int mid = tr[u].l + tr[u].r >> 1;
            if (l <= mid) modify(u << 1, l, r, k);
            if (r > mid) modify(u << 1 | 1, l, r, k);
            pushup(u);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        build(1, 0, 10000);
        for (int i = 0; i < n; ++i) {
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();

            seg[m++] = new segment(x1, y1, y2, 1);
            seg[m++] = new segment(x2, y1, y2, -1);
        }
        Arrays.sort(seg, 0, m, new mcomp());
        for (int i = 0; i < m; ++i) {
            if (i > 0) res += (seg[i].x - seg[i - 1].x) * tr[1].len;
            modify(1, seg[i].y1, seg[i].y2 - 1, seg[i].k);
        }
        System.out.println(res);
    }
}

