package Math;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/03/08
 * <p>
 * 思路
 * 1. 朴素做法，暴力模拟
 * 优化1：i <= n / 2
 * 优化2：i * i <= n
 * 注：不调用Math.sqrt()，时间上过于昂贵
 * 2. 埃氏筛
 * 3. 欧拉（线性）筛
 */
public class Q204_计数质数 {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                cnt++;
            }
        }

        return cnt;
    }


    public int countPrimes2(int n) {
        if (n < 2) {
            return 0;
        }
        init(n);
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                prime[cnt++] = i;
            }
            for (int j = 0; j < cnt && i * prime[j] <= n; j++) {
                isPrime[i * prime[j]] = false;
                if (i % prime[j] == 0) {
                    break;
                }
            }
        }

        return cnt;
    }

    private int[] prime;
    private boolean[] isPrime;

    private void init(int n) {
        int size = n + 1;
        prime = new int[size];
        isPrime = new boolean[size];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
    }

    private boolean isPrime1(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    private boolean isPrime2(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    private boolean isPrime3(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
