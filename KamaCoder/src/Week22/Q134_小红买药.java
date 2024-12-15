package Week22;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2024/12/11
 * @file Q134_小红买药.java
 * <p>
 * 题目描述
 * 小红准备买药治病。
 * 已知共有 n 种症状和 m 种药，第 i 种药可以治疗一些症状，但可能会导致一些副作用，添加一些新的症状。
 * 小红依次服用了一些药，请你告诉小红，当她每次服用一副药时，当前还有多少症状？
 * <p>
 * 输入描述
 * 第一行输入一个正整数 n（1 <= n <= 20），代表症状的数量
 * 第二行输入一个长应为 n 的 01 串，第 i 位是 "1" 代表小红目前有第 i 个症状，第i位是 "0" 代表没有该症状。
 * 第三行输入一个正整数 m（ 1<= m <= 10^4），代表药的数量。
 * 接下来的 2 * m 行，每 2 行描述一副药：
 * 第一行输入一个长度为 n 的 01 串，代表该药能治疗的症状。’1‘代表可以治疗，‘0’代表不能治疗。
 * 第二行输入一个长度为 n 的 01 串，代表该药会产生的副作用。’1‘代表会产生该症状，’0‘代表不会产生。
 * 接下来的一行，输入一个正整数 q（ 1<= q <= 10^4），代表小红服用的药数量。
 * 接下来的 q 行，每行输入一个正整数 u（1 <= ai, u <= m），代表小红服用了第 u 副药。
 * 保证每副药的副作用产生的症状和该药治疗的症状是不会重复的，即不会存在同一个位置的两个 01 串都是‘1’。
 * <p>
 * 输出描述
 * 输出 q 行，每行输入一个正整数，代表当前小红服用药后，身体有多少症状。
 * <p>
 * 思路
 * 模拟
 * TC9会TLE
 * 由于st实际上是以十进制存，每次更新的时间都要多乘上O(n)
 * 考虑能不能把这一部分优化掉呢？每次对st操作而非st[i]
 */
public class Q134_小红买药 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String status = sc.next();
        int[] st = new int[n];
        for (int i = 0; i < n; i++) {
            st[i] = status.charAt(i) - '0';
        }
        int m = sc.nextInt();
        int[][] goodEffects = new int[m][n], sideEffects = new int[m][n];
        for (int i = 0; i < m; i++) {
            char[] s1 = sc.next().toCharArray(), s2 = sc.next().toCharArray();
            for (int j = 0; j < n; j++) {
                goodEffects[i][j] = s1[j] - '0';
                sideEffects[i][j] = s2[j] - '0';
            }
        }
        int q = sc.nextInt();
        while (q-- > 0) {
            int u = sc.nextInt();
            for (int i = 0; i < n; i++) {
                st[i] = st[i] & ~goodEffects[u - 1][i] | sideEffects[u - 1][i];
            }
            System.out.println(Arrays.stream(st).sum());
        }
    }
}
