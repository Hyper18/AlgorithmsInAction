package Week17;

import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2024/11/06
 * @file Q114_小欧的平均数.java
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
