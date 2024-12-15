package Matrix;

/**
 * @author Hyperspace
 * @date 2024/12/05
 * @file M3001_捕获黑皇后需要的最少移动次数.java
 * <p>
 * 思路
 * 模拟
 */
public class M3001_捕获黑皇后需要的最少移动次数 {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        return a == e && (c != e || !block(b, d, f)) || b == f && (d != f || !block(a, c, e)) || c + d == e + f && (a + b != e + f || !block(c, a, e)) || c - d == e - f && (a - b != e - f || !block(c, a, e)) ? 1 : 2;
    }

    private boolean block(int l, int m, int r) {
        return Math.min(l, r) < m && m < Math.max(l, r);
    }
}
