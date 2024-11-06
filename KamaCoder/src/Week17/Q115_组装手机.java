package Week17;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2024/11/06
 * @file Q115_组装手机.java
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
