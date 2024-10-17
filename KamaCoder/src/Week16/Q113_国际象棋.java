package Week16;

import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2024/10/17
 * @file Q113_国际象棋.java
 * <p>
 * 题目描述
 * 小欧获得了国际象棋中“象"和”马”的能力，她在一个无穷大的平面直角坐标系中，每一步可以效仿国际象棋中 的”象"和"马"跳一步。
 * 如下图，小红初始坐标为(x，y)时，只跳一步时可以跳到以下
 * 1.(x+k，y+k)，k是任意整数。
 * 2.(x+k,y-k)，k是任意整数。
 * 3.(x+a,y+b).其中|a|+|b|=3且1<=a,b<=2. 小欧想知道，自己初始坐标为x1，y1，他跳到x2,y2最少需要跳多少步？共有t次询问
 * <p>
 * 输入描述
 * 第一行输入一个整数t(1 <= t <= 100)表示询问组数 接下来t行，
 * 每行四个整数x1,y1,x2,y2
 * -10^9 <= x1,y1,x2,y2 <= 10^9
 * <p>
 * 输出描述
 * 一个整数，代表最小的步数。
 * <p>
 * 思路
 * 矩阵 dfs
 * 题干的无穷大边界有迷惑性
 * 本质在于最多只需3步移动即可到达所有的位置
 * 马起到黑色<-->白色之间的切换作用
 * 象的移动则能在两步内到达所有同色位置
 */
public class Q113_国际象棋 {
    private static final int[][] dirs = new int[][]{{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt();
            System.out.println(dfs(x1, y1, x2, y2));
        }
    }

    private static int dfs(int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x1 - x2), dy = Math.abs(y1 - y2);
        // 1. 特判起点和终点相同的情况
        if (dx == 0 && dy == 0) {
            return 0;
        }
        // 2. 只考虑一次象的移动的情况
        if (dx - dy == 0) {
            return 1;
        }
        // 3. 只考虑一次马的移动的情况
        for (int i = 0; i < 8; i++) {
            int nx = x1 + dirs[i][0], ny = y1 + dirs[i][1];
            if (nx == x2 && ny == y2) {
                return 1;
            }
        }
        // 4. 只考虑两次象的移动的情况
        if ((dx - dy) % 2 == 0) {
            return 2;
        }
        // 5. 考虑马和象的移动各一次的情况
        for (int i = 0; i < 8; i++) {
            int nx = x1 + dirs[i][0], ny = y1 + dirs[i][1];
            if (Math.abs(nx - x2) - Math.abs(ny - y2) == 0) {
                return 2;
            }
        }

        // 6. 马移动一步、象移动两步的情况
        return 3;
    }
}
