package Week19;

import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2024/11/11
 * @file Q125_精华帖子.java
 * <p>
 * 题目描述
 * 小红书的推荐帖子列表为 [0 ,n)，其中所有的帖子初始状态为 “普通”，
 * 现在运营同学把其中的一些帖子区间标记为了 “精华”。
 * 运营同学选择了固定长度 k，对整个帖子列表截取，
 * 要求计算在固定的截取长度 k 下，能够截取获得的最多精华帖子数量。
 * <p>
 * 输入描述
 * 第一行输入三个正整数 n，m，k，分别代表初始帖子列表长度，精华区间的数量，以及运营同学准备截取的长度。
 * 接下来的 m 行，每行输入两个正整数，li 和 ri ，代表第 i 个左闭右开区间。
 * 1 <= k <= n <= 20000000.
 * 1 <= m <= 100000.
 * 0 <= li < ri <= n，保证任意两个区间是不重复的。
 * <p>
 * 输出描述
 * 一个正整数，代表截取获得的最多的精华帖子数量。
 * <p>
 * 思路
 * 模拟，SWM
 */
public class Q125_精华帖子 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        boolean[] f = new boolean[n];
        while (m-- > 0) {
            int l = sc.nextInt(), r = sc.nextInt();
            while (l < r) {
                f[l++] = true;
            }
        }
        int ans = 0, cnt = 0;
        for (int l = 0, r = 0; r < n; r++) {
            if (r - l == k) {
                cnt -= f[l++] ? 1 : 0;
            }
            if (f[r]) {
                cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
}
