package Tree.SegmentTree;

/**
 * @author Hyperspace
 * @date 2023/07/26
 * @file M2569_更新数组后处理求和查询.java
 * <p>
 * 思路
 * 线段树
 * 待回看
 */
public class M2569_更新数组后处理求和查询 {
    static int N = 100010;
    private int[] nums;

    class Node {
        int l, r;
        long sum, add;

        public Node(int l, int r, long sum, long add) {
            this.l = l;
            this.r = r;
            this.sum = sum;
            this.add = add;
        }
    }

    Node[] tr = new Node[N * 4];

    private void pushup(int u) {
        tr[u].sum = tr[u << 1].sum + tr[u << 1 | 1].sum;
    }

    private void pushdown(int u) {
        Node root = tr[u], left = tr[u << 1], right = tr[u << 1 | 1];
        if (root.add > 0) {
            left.add ^= 1;
            left.sum = left.r - left.l + 1 - left.sum;
            right.add ^= 1;
            right.sum = right.r - right.l + 1 - right.sum;
            root.add ^= 1;
        }
    }

    private void build(int u, int l, int r) {
        if (l == r) tr[u] = new Node(l, r, nums[r], 0);
        else {
            tr[u] = new Node(l, r, 0, 0);
            int mid = (l + r) / 2;
            build(u << 1, l, mid);
            build(u << 1 | 1, mid + 1, r);
            pushup(u);
        }
    }

    private void update(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            tr[u].sum = tr[u].r - tr[u].l + 1 - tr[u].sum;
            tr[u].add ^= 1;
        } else {
            pushdown(u);
            int mid = (tr[u].l + tr[u].r) / 2;
            if (l <= mid) update(u << 1, l, r);
            if (r > mid) update(u << 1 | 1, l, r);
            pushup(u);
        }
    }

    long query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) return tr[u].sum;

        pushdown(u);
        int mid = (tr[u].l + tr[u].r) / 2;
        long sum = 0;
        if (l <= mid) sum += query(u << 1, l, r);
        if (r > mid) sum += query(u << 1 | 1, l, r);
        return sum;
    }

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        nums = new int[n + 1];
        for (int i = 0; i < n; i++) nums[i + 1] = nums1[i];
        build(1, 1, n);
        int sz = 0;
        for (int[] x : queries)
            if (x[0] == 3) ++sz;
        long[] res = new long[sz];
        long s = 0;
        for (int i = 0; i < n; i++) s += nums2[i];
        int idx = 0;
        for (int[] t : queries) {
            if (t[0] == 1) update(1, t[1] + 1, t[2] + 1);
            else if (t[0] == 2) s += query(1, 1, n) * t[1];
            else res[idx++] = s;
        }

        return res;
    }
}
