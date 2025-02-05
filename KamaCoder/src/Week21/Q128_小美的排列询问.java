package Week21;

import java.util.Scanner;

/**
 * @author Hyper
 * @date 2024/12/02
 * @file Q128_小美的排列询问.java
 * <p>
 * 题目描述
 * 小美拿到了一个排列。
 * 她想知道在这个排列中，x 和 y 是否是相邻的。你能帮帮她吗？
 * 排列是指一个长度为 n 的数组，其中 1 到 n 每个元素恰好出现一次。
 * <p>
 * 输入描述
 * 第一行输入一个正整数 n（1 <= n <= 200000），代表排列的长度。
 * 第二行输入 n 个正整数 ai，代表排列的元素。
 * 第三行输入两个正整数 x 和 y（1 <= ai, x, y <= n），用空格隔开。
 * 保证 x != y
 * <p>
 * 输出描述
 * 如果 x 和 y 是相邻的，输出 Yes；否则输出 No。
 */
public class Q128_小美的排列询问 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int x = sc.nextInt(), y = sc.nextInt();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                if ((i > 0 && a[i - 1] == y) || (i < n - 1 && a[i + 1] == y)) {
                    flag = true;
                }
                break;
            }
        }
        System.out.println(flag ? "Yes" : "No");
    }
}
