package Week19;

import java.util.Scanner;

/**
 * @author Hyper
 * @date 2024/11/11
 * @file Q124_小红的数组构造.java
 * <p>
 * 题目描述
 * 小红的数组构造小红希望你构造一个数组满足以下条件：
 * 1. 数组共有 n 个元素，且所有元素两两不相等。
 * 2. 所有元素的最大公约数等于 k。
 * 3. 所有元素之和尽可能小。请你输出数组元素之和的最小值。
 * <p>
 * 输入描述
 * 两个正整数 n 和 k。
 * <p>
 * 输出描述
 * 一个正整数，代表数组元素之和的最小值。
 * <p>
 * 思路
 * 等差数列求和，不需要用gcd
 * 注意爆int
 */
public class Q124_小红的数组构造 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(), k = sc.nextLong();
        System.out.println((k + n * k) * n / 2);
    }
}
