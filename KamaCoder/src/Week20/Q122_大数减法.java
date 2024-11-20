package Week20;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2024/11/19
 * @file Q122_大数减法.java
 * <p>
 * 题目描述
 * 以字符串的形式读入两个数字，编写一个函数计算它们的差，以字符串形式返回。
 * <p>
 * 输入描述
 * 输入两个数字（都为正数）
 * <p>
 * 输出描述
 * 两个输入数字的差
 */
public class Q122_大数减法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new BigInteger(sc.next()).subtract(new BigInteger(sc.next())));
    }
}
