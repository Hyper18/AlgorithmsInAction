package Matrix;

/**
 * @author Hyper
 * @date 2024/11/18
 * @file M661_图片平滑器.java
 * <p>
 * 思路
 * 1. 暴力
 * 2. 模拟
 * 3. 二维前缀和
 */
public class M661_图片平滑器 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] res = new int[m][n];
        if (m == 1 && n == 1) {
            return img;
        } else if (m == 1) {
            res[0][0] = (img[0][0] + img[0][1]) / 2;
            for (int j = 1; j < n - 1; j++) {
                res[0][j] = (img[0][j - 1] + img[0][j] + img[0][j + 1]) / 3;
            }
            res[0][n - 1] = (img[0][n - 2] + img[0][n - 1]) / 2;
            return res;
        } else if (n == 1) {
            res[0][0] = (img[0][0] + img[1][0]) / 2;
            for (int i = 1; i < m - 1; i++) {
                res[i][0] = (img[i][0] + img[i - 1][0] + img[i + 1][0]) / 3;
            }
            res[m - 1][0] = (img[m - 1][0] + img[m - 2][0]) / 2;
            return res;
        }
        res[0][0] = (img[0][0] + img[1][0] + img[0][1] + img[1][1]) / 4;
        res[0][n - 1] = (img[0][n - 1] + img[0][n - 2] + img[1][n - 1] + img[1][n - 2]) / 4;
        res[m - 1][0] = (img[m - 1][0] + img[m - 1][1] + img[m - 2][0] + img[m - 2][1]) / 4;
        res[m - 1][n - 1] = (img[m - 1][n - 1] + img[m - 2][n - 1] + img[m - 1][n - 2] + img[m - 2][n - 2]) / 4;
        for (int i = 1; i < m - 1; i++) {
            res[i][0] = (img[i][0] + img[i - 1][0] + img[i + 1][0] + img[i - 1][1] + img[i][1] + img[i + 1][1]) / 6;
            res[i][n - 1] = (img[i][n - 1] + img[i - 1][n - 1] + img[i + 1][n - 1] + img[i - 1][n - 2] + img[i][n - 2] + img[i + 1][n - 2]) / 6;
        }
        for (int j = 1; j < n - 1; j++) {
            res[0][j] = (img[0][j] + img[0][j - 1] + img[0][j + 1] + img[1][j - 1] + img[1][j] + img[1][j + 1]) / 6;
            res[m - 1][j] = (img[m - 1][j] + img[m - 1][j - 1] + img[m - 1][j + 1] + img[m - 2][j - 1] + img[m - 2][j] + img[m - 2][j + 1]) / 6;
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                res[i][j] = (img[i - 1][j - 1] + img[i][j - 1] + img[i + 1][j - 1] + img[i - 1][j] + img[i][j] + img[i + 1][j] + img[i - 1][j + 1] + img[i][j + 1] + img[i + 1][j + 1]) / 9;
            }
        }

        return res;
    }

    private final int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int[][] imageSmoother2(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int t = 0, cnt = 0;
                for (int[] dir : dirs) {
                    int nx = i + dir[0], ny = j + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    cnt++;
                    t += img[nx][ny];
                }
                res[i][j] = t / cnt;
            }
        }

        return res;
    }

    public int[][] imageSmoother3(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] pre = new int[m + 2][n + 2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pre[i + 1][j + 1] = pre[i][j + 1] + pre[i + 1][j] - pre[i][j] + img[i][j];
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int u = Math.max(0, i - 1), l = Math.max(0, j - 1), b = Math.min(m - 1, i + 1), r = Math.min(n - 1, j + 1);
                int t = pre[b + 1][r + 1] - pre[u][r + 1] - pre[b + 1][l] + pre[u][l], cnt = (b - u + 1) * (r - l + 1);
                res[i][j] = t / cnt;
            }
        }

        return res;
    }
}
