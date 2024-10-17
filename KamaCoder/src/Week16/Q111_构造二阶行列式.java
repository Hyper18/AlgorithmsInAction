package Week16;

import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2024/10/16
 * @file Week16.Q111_构造二阶行列式.java
 * <p>
 * 题目描述
 * 小欧希望你构造一个二阶行列式，满足行列式中每个数均为不超过 20 的正整数，且行列式的值恰好等于x。你能帮帮她吗?
 * <p>
 * 输入描述
 * 一个正整数x。-1000 <= x <= 1000
 * <p>
 * 输出描述
 * 如果无解，请输出-1。否则输出任意合法行列式即可(输出两行,每行输出两个不超过20的正整数)。
 * <p>
 * 思路
 * 朴素 模拟
 */
public class Q111_构造二阶行列式 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (!check(x)) {
            System.out.println("-1");
        }
    }

    private static boolean check(int x) {
        for (int a = 0; a <= 20; a++) {
            for (int b = 0; b <= 20; b++) {
                for (int c = 0; c <= 20; c++) {
                    for (int d = 0; d <= 20; d++) {
                        if (a * d - b * c == x) {
                            System.out.println(a + " " + b + "\n" + c + " " + d);
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
