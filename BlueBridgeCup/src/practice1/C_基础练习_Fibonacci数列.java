package practice1;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/02/17
 */
public class C_基础练习_Fibonacci数列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        long n = in.nextLong();
        out.println(fib(n));

        in.close();
        out.close();
    }

    private static long fib(long n) {
        int pre = 1;
        int curr = 1;
        int tmp;
        for (int i = 3; i <= n; i++) {
            tmp = (pre + curr) % 10007;
            pre = curr;
            curr = tmp;
        }
        return curr;
    }
}
