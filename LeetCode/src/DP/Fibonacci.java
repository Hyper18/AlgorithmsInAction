package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Hyper
 * @date 2022/02/17
 */
public class Fibonacci {
    public static void main(String[] args) throws Exception {
        System.out.println(fibonacci(5));

        for (int i = 0; i < 50; i++) {
            dp[i] = -1;
        }

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        System.out.println(fib(n));
        bf.close();
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    private static int[] dp = new int[50];

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return dp[0] = 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = fib(n - 2) + fib(n - 1);
    }
}
