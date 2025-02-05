package Week22;

import java.util.Scanner;

/**
 * @author Hyper
 * @date 2024/12/11
 * @file Q133_夹吃棋.java
 * <p>
 * 题目描述
 * 在一个 3 * 3 的棋盘上，小红和小紫正在玩“夹吃棋”。
 * 所谓“夹吃棋”，即如果存在一个白子，它的两侧 (横向或者纵向)相邻都是黑子，则这个棋子将被“夹吃”，对于黑棋亦然。
 * 如果一个棋盘的局面没有一方被夹吃，或者黑白双方都被对面夹吃，则认为是平局。
 * 如果只有一方夹吃了另一方，则认为夹吃方赢，被夹吃方输。
 * 小红执黑棋，小紫执白棋，现在给定一个局面，请你判断当前棋局是谁获胜。
 * <p>
 * 输入描述
 * 第一行输入一个正整数 t （1 <= t <= 10000），代表询问的次数。
 * 接下来每组询问输入三行，，每行是一个长度为3的字符串，字符串仅由'o','.','*'组成。
 * 其中 o 代表白棋，* 代表黑棋，. 代表未放置棋子。
 * <p>
 * 输出描述
 * 小红获胜输出“kou”，小紫获胜输出“yukan”，平局输出“draw”。
 * <p>
 * 思路
 * 模拟
 */
public class Q133_夹吃棋 {
    private static final int N = 3;
    private static char[][] g;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            g = new char[N][N];
            for (int i = 0; i < N; i++) {
                g[i] = sc.next().toCharArray();
            }
            play();
        }
    }

    private static void play() {
        boolean f1 = false, f2 = false;
        for (int i = 0; i < N && (!f1 || !f2); i++) {
            for (int j = 0; j < N && (!f1 || !f2); j++) {
                if (g[i][j] == '.') {
                    continue;
                }
                if (check(i - 1, j) && check(i + 1, j) && g[i][j] != g[i - 1][j] && g[i][j] != g[i + 1][j]) {
                    if (!f1) {
                        f1 = g[i][j] == 'o';
                    }
                    if (!f2) {
                        f2 = g[i][j] == '*';
                    }
                }
                if (check(i, j - 1) && check(i, j + 1) && g[i][j] != g[i][j - 1] && g[i][j] != g[i][j + 1]) {
                    if (!f1) {
                        f1 = g[i][j] == 'o';
                    }
                    if (!f2) {
                        f2 = g[i][j] == '*';
                    }
                }
            }
        }
        if ((f1 && f2) || (!f1 && !f2)) {
            System.out.println("draw");
        } else if (f1) {
            System.out.println("kou");
        } else {
            System.out.println("yukan");
        }
    }

    private static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && g[x][y] != '.';
    }
}
