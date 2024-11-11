package Week17;

import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2024/11/06
 * @file Q116_小欧的卡牌.java
 * <p>
 * 题目描述
 * 小欧有 n 张卡牌，第 i 张卡牌的正面写了个数字 ai，背面写了个数字 bi。
 * 小欧对于每张卡牌可以选择一面向上，她希望最终向上的数字之和为 3 的倍数。
 * 你能告诉小欧有多少方案吗？由于答案过大，请对 10 ^ 9 + 7 取模.
 * <p>
 * 输入描述
 * 第一行输入一个正整数 n，代表卡牌数量。
 * 接下来的 n 行，每行输入两个正整数 ai 和 bi，代表第 i 张卡牌的正面和背面的数字.
 * 1 <= n <= 10^5 1 <= ai,bi <= 10^9
 * <p>
 * 输出描述
 * 一个整数，代表方案数对 10^9 + 7 取模的值
 * <p>
 * 思路
 * DP
 */
public class Q116_小欧的卡牌 {
    private static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n], b = new int[n];
        int i = 0;
        while (i < n) {
            a[i] = sc.nextInt();
            b[i++] = sc.nextInt();
        }
        int[][] f = new int[n + 1][3];
        f[0][0] = 1;
        for (i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                int sum = (j + a[i - 1]) % 3;
                f[i][sum] = (f[i][sum] + f[i - 1][j]) % MOD;
                sum = (j + b[i - 1]) % 3;
                f[i][sum] = (f[i][sum] + f[i - 1][j]) % MOD;
            }
        }
        System.out.println(f[n][0]);
    }
}
