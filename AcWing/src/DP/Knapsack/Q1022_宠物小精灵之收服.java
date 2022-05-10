package DP.Knapsack;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/05/10
 * <p>
 * 思路 二维的01背包问题 -- O(n^2)
 * 1. 状态表示
 * 表示: f[j][k]表示当精灵球数目为j且皮卡丘有k的体力时，能够收服的野生小精灵最大数目
 * 属性：收服的野生小精灵最大值Max 当前状态下皮卡丘的剩余血量
 * 2. 状态计算
 * 1）若当前可以收服
 * f[j][k] = f[j - w][k - v] + 1 （更新上一层数值 +1）
 * 2）若当前不可以收服
 * f[j][k] = f[j][k] （沿用上一层状态，数值相同）
 * <p>
 * 注意：
 * 1. 皮卡丘的剩余血量必须大于0，否则一律按情况2处理
 * -- 则k取不到m2
 * 2. 计算当前状态下皮卡丘的剩余血量时，
 * 在当前第n层且精灵球数目为m1的状态中
 * 找寻恰好使得收服的野生小精灵最大值达到Max的最小消耗血量
 * -- 具体实现为，从m2-1开始向前寻找临界下标
 */
public class Q1022_宠物小精灵之收服 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final int N = 1000 + 10, M = 500 + 10;
    private static int[][] f = new int[N][M];

    public static void main(String[] args) throws IOException {
        int m1 = nextInt(), m2 = nextInt(), n = nextInt();

        for (int i = 1; i <= n; i++) {
            int v1 = nextInt(), v2 = nextInt();
            for (int j = m1; j >= v1; j--) {
                for (int k = m2 - 1; k >= v2; k--) {
                    f[j][k] = Math.max(f[j][k], f[j - v1][k - v2] + 1);
                }
            }
        }

        int r = m2 - 1;
        while (r > 0 && f[m1][m2 - 1] == f[m1][r - 1]) {
            r--;
        }
        out.println(f[m1][m2 - 1] + " " + (m2 - r));

        close();
    }

    public static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(tk.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
