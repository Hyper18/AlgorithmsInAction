package Week21;

import java.util.Scanner;

/**
 * @author Hyper
 * @date 2024/12/02
 * @file Q130_小美的蛋糕切割.java
 * <p>
 * 题目描述
 * 小美有一个矩形的蛋糕，共分成了 n 行 m 列，共 n * m 个区域，
 * 每个区域是一个小正方形，已知蛋糕每个区域都有一个美味度。
 * 她想切一刀把蛋糕切成两部分，自己吃一部分，小团吃另一部分。
 * 小美希望两个人吃的部分的美味度之和尽可能接近，请你输出|s1 - s2|的最小值。
 * （其中 s1 代表小美吃的美味度，s2 代表小团吃的美味度）。
 * 请务必保证，切下来的区域都是完整的，即不能把某个小正方形切成两个小区域。
 * <p>
 * 输入描述
 * 第一行输出两个正整数 n 和 m（1 <= n, m <= 10^3），代表蛋糕区域的行数和列数。
 * 接下来的 n 行，每行输入 m 个正整数 aij（1 <= aij <= 10^4），用来表示每个区域的美味度。
 * <p>
 * 输出描述
 * 一个整数，代表|s1-s2|的最小值。
 * <p>
 * 思路
 * 二维前缀和，分类讨论如下：
 * 1) 横切
 * ans = min(ans, abs(pre[i][m] - (sum + pre[i][m]))
 * 2) 纵切
 * ans = min(ans, abs(pre[n][j] - (sum + pre[n][j]))
 */
public class Q130_小美的蛋糕切割 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] g = new int[n][m], pre = new int[n + 1][m + 1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += g[i][j] = sc.nextInt();
                pre[i + 1][j + 1] = pre[i][j + 1] + pre[i + 1][j] - pre[i][j] + g[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, Math.abs(2 * pre[i][m] - sum));
        }
        for (int j = 1; j < m; j++) {
            ans = Math.min(ans, Math.abs(2 * pre[n][j] - sum));
        }

        System.out.println(ans);
    }
}
