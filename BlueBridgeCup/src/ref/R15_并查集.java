package ref;

/**
 * @author Hyperspace
 * @date 2022/03/05
 * 压缩路径写法
 */
public class R15_并查集 {
    private final static int MAXN = 10007;
    static int[] pre = new int[MAXN];

    public static void init(int n) {
        for (int i = 1; i <= n; i++) {
            pre[i] = i;
        }
    }

    public static int find(int x) {
        if (pre[x] != x) {
            pre[x] = find(pre[x]);
        }

        return pre[x];
    }

    public static void join(int x, int y) {
        int tx = find(x);
        int ty = find(y);

        if (tx != ty) {
            pre[tx] = ty;
        }
    }
}
