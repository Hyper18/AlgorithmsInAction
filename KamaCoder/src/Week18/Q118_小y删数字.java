package Week18;

import java.util.Scanner;

/**
 * @author Hyper
 * @date 2024/11/07
 * @file Q118_小y删数字.java
 * <p>
 * 题目描述
 * 给定一个长度为 n 的数组，数组元素为 a1, a2, . . , an，
 * 每次能删除任意 a 的任意一位，求将所有数字变成 0 最少需要几步。
 * 例如 103 若删除第 1 位则变成 3; 若删除第 2 位则变成13; 若删除第 3 位则变成 10。
 * <p>
 * 输入描述
 * 输入描述第一行一个正整数 n 代表数组长度。接下来一行 n 个数第 j 个数代表 a。
 * <p>
 * 输出描述
 * 输出一行一个数代表答案。
 */
public class Q118_小y删数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int i = 0;
        while (i < n) {
            a[i++] = sc.nextInt();
        }
        int cnt = 0, zeros = 0;
        for (i = 0; i < n; i++) {
            while (a[i] > 0) {
                int t = a[i] % 10;
                if (t == 0) {
                    zeros++;
                }
                cnt++;
                a[i] /= 10;
            }
        }
        System.out.println(cnt - zeros);
    }
}
