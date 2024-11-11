package Week17;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2024/11/06
 * @file Q115_组装手机.java
 * <p>
 * 题目描述
 * 小欧是手机外壳供应商，小蕊是手机零件供应商。小欧已经生产了 n 个手机外壳，第 i 个手机外壳售价 ai 元，小蕊生产了 n 个手机零件，第 i 个手机零件售价 bi 元。
 * 在组装手机中，一个手机外壳与一个手机零件可以组装成一个手机，手机的售价为手机外壳售价与手机零件售价之和。
 * 他们需要选出一些外壳和零件，配对形成若干部手机，要求这些手机的售价全部相同。小欧想知道他们最多可以组装多少部手机?
 * <p>
 * 输入描述
 * 第一行一个整数 n (1 <= n <= 1000)
 * 第二行 n 个整数 ai (1 <= ai <= 1000)
 * 第三行 n 个整数 bi (1 <= bi <= 1000)
 * <p>
 * 输出描述
 * 一行一个整数，表示最大数量。
 * <p>
 * 思路
 * 模拟
 * Case9 TLE
 */
public class Q115_组装手机 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> a = new HashMap<>(), b = new HashMap<>(), sums = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a.merge(sc.nextInt(), 1, Integer::sum);
        }
        for (int i = 0; i < n; i++) {
            b.merge(sc.nextInt(), 1, Integer::sum);
        }
        int ans = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> ea : a.entrySet()) {
            for (Map.Entry<Integer, Integer> eb : b.entrySet()) {
                int i = ea.getKey(), vi = ea.getValue(), j = eb.getKey(), vj = eb.getValue();
                sums.merge(i + j, Math.min(vi, vj), Integer::sum);
                ans = Math.max(ans, sums.get(i + j));
            }
        }
        System.out.println(ans);
    }
}
