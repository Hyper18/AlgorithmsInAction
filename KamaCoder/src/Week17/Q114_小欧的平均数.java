package Week17;

import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2024/11/06
 * @file Q114_小欧的平均数.java
 * <p>
 * 题目描述
 * 小欧有三个数x,y,z,小欧想要令三个数平衡，那么小欧需要先选定其中任意两个数，并获得他们的平均数K，若这两个数的平均数不是整数，则K不是整数，即小欧必须更换他的选择，否则三数无法平衡。当选定了两个数后，接下来小欧可以进行若干次如下操作之一：
 * 1.令剩余的那个数+1.
 * 2.令剩余的那个数-1
 * 小欧想知道令三数平衡的最小操作数是多少?
 * <p>
 * 输入描述
 * 一行三个正整数 x, y, z
 * <p>
 * 输出描述
 * 一行一个整数，表示最小操作数。
 * <p>
 * 思路
 * 题干不严谨，没有给出平衡的条件
 * 本质为求令三个数均为奇数或均为偶数所需的操作数
 */
public class Q114_小欧的平均数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
        int cnt = (x + y) % 2 + (x + z) % 2 + (y + z) % 2;
        System.out.println(cnt == 3 || cnt == 0 ? "0" : "1");
    }
}
