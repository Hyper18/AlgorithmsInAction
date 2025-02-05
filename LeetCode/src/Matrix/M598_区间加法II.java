package Matrix;

/**
 * @author Hyper
 * @date 2025/02/02
 * @file M598_区间加法II.java
 */
public class M598_区间加法II {
    public int maxCount(int m, int n, int[][] ops) {
        int x = m, y = n;
        for (int[] op : ops) {
            x = Math.min(x, op[0]);
            y = Math.min(y, op[1]);
        }

        return x * y;
    }
}
