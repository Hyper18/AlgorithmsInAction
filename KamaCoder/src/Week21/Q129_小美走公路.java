package Week21;

import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2024/12/02
 * @file Q129_小美走公路.java
 * <p>
 * 题目描述
 * 有一个环形的公路，上面共有 n 站，
 * 现在给定了顺时针第 i 站到第 i + 1 站之间的距离（特殊的，也给出了第 n 站到第 1 站的距离）。
 * 小美想沿着公路第 x 站走到第 y 站，她想知道最短的距离是多少？
 * <p>
 * 输入描述
 * 第一行输入一个正整数 n（1 <= n <= 10^5），代表站的数量。
 * 第二行输入 n 个正整数 ai（1 <= ai <= 10^9），
 * 前 n - 1 个数代表顺时针沿着公路走，i 站到第 i + 1 站之间的距离；
 * 最后一个正整数代表顺时针沿着公路走，第 n 站到第 1 站的距离。
 * 第三行输入两个正整数 x 和 y（1 <= x, y <= n），代表小美的出发地和目的地。
 * <p>
 * 输出描述
 * 一个正整数，代表小美走的最短距离。
 * <p>
 * 思路
 * 前缀和
 * 处理成环也可以采用取余的方式
 * 由于已经依次读输入，可以直接用所有边的和与ans相减，得到另一条经过下标0的路径长度
 * <p>
 * 这里容易产生一个误区，即认为起点到终点的路径为有指向性的（不包含起点）
 * 但其实权值不是和节点绑定，而是表示两点之间的距离（边）
 */
public class Q129_小美走公路 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] pre = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + sc.nextInt();
        }
        int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
        long ans = Math.abs(pre[y] - pre[x]);
        System.out.println(Math.min(ans, pre[n] - ans));
    }
}
