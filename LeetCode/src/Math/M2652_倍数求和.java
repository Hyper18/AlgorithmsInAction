package Math;

/**
 * @author Hyperspace
 * @date 2023/10/17
 * @file M2652_倍数求和.java
 * <p>
 * 思路
 * 1. 模拟
 * 2. 容斥原理
 */
public class M2652_倍数求和 {
    public int sumOfMultiples(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                ans += i;
            }
        }

        return ans;
    }

    public int sumOfMultiples2(int n) {
        return f(n, 3) + f(n, 5) + f(n, 7) - f(n, 3 * 5) - f(n, 3 * 7) - f(n, 5 * 7) + f(n, 3 * 5 * 7);
    }

    public int f(int a, int b) {
        return (b + a / b * b) * (a / b) / 2;
    }
}
