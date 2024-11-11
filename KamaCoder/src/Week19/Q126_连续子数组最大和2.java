package Week19;

import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2024/11/11
 * @file Q126_连续子数组最大和.java
 * <p>
 * 题目描述
 * 小红拿到了一个数组，她希望进行最多一次操作：将一个元素修改为x。
 * 小红想知道，最终的连续子数组最大和最大是多少？
 * <p>
 * 输入描述
 * 第一行输入一个正整数t，代表询问次数。
 * 对于每次询问，输入两行：
 * 第一行输入两个正整数n和x。代表数组的大小，以及小红可以修改成的元素。
 * 第二行输入n个正整数a_i，代表小红拿到的数组
 * <p>
 * 输出描述
 * 输出 t 行，每行输出一个整数，代表连续子数组的最大和。
 * <p>
 * 思路
 * DP状态机优化
 */
public class Q126_连续子数组最大和2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), x = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int[] f = new int[2];
            f[0] = nums[0];
            f[1] = x;
            int ans = Math.max(f[0], f[1]);
            for (int i = 1; i < n; i++) {
                f[1] = Math.max(f[0] + x, Math.max(f[1] + nums[i], x));
                f[0] = Math.max(f[0] + nums[i], nums[i]);
                ans = Math.max(ans, Math.max(f[0], f[1]));
            }
            System.out.println(ans);
        }
    }
}
