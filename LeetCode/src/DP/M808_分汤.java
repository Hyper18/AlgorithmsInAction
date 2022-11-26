package DP;

/**
 * @author Hyperspace
 * @date 2022/11/21
 * @file M808_分汤.java
 * <p>
 * 思路
 * 10^9过大，先缩放/25
 * 则四种操作转化为：
 * 1）4, 0
 * 2）3, 1
 * 3）2, 2
 * 4）1, 3
 * E(A) = 2.5, E(B) = 1.5
 * 1. 状态表示
 * 集合：f[i][j]表示剩余i份的a汤和j份的b汤的最终概率
 * 集合划分得到四种状态：
 * 1）i, j = 0 a、b汤同时取完
 * 2）i = 0, j > 0 a汤取完，而b汤尚未取完
 * 3）i > 0, j = 0 b汤取完，而a汤尚未取完
 * 4）i, j > 0 a、b汤都未取完
 * 属性：P(a汤先取完)
 * 2. 状态计算
 * 对应上述划分，分类讨论：
 * 1）f[i][j] = 0.5
 * 2）f[i][j] = 1
 * 3）f[i][j] = 0
 * 4）f[i][j] = 0.25 * (f[i - 4][j] + f[i - 3][j - 1] + f[i - 2][j - 2] + f[i - 1][j - 3])
 */
public class M808_分汤 {
    public double soupServings(int n) {
        n = Math.min(200, (int) Math.ceil(n / 25D));
        double[][] f = new double[n + 5][n + 5];

        f[0][0] = 0.5;
        for (int j = 1; j <= n; j++) {
            f[0][j] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                double a = f[g(i, 4)][j];
                double b = f[g(i, 3)][g(j, 1)];
                double c = f[g(i, 2)][g(j, 2)];
                double d = f[g(i, 1)][g(j, 3)];
                f[i][j] = 0.25 * (a + b + c + d);
            }
        }

        return f[n][n];
    }

    int g(int a, int b) {
        return a < b ? 0 : a - b;
    }

//    /**
//     * 找满足10^-5精确度下近似为1的最小n = 4481， n / 25 = 179.24
//     */
//    public static void main(String[] args) {
//        for (int i = 1000; i < 5000; i++) {
//            if (soupServings(i) > 0.99999) {
//                System.out.printf("%d %f", i, soupServings(i));
//                break;
//            }
//        }
//    }
}
