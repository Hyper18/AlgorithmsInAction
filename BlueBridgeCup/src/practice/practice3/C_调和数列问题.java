package practice.practice3;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyper
 * @date 2022/02/28
 */
public class C_调和数列问题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        double x;
        while ((x = in.nextDouble()) != 0) {
            out.println(cal(x));
        }

        in.close();
        out.close();
    }

    private static String cal(double x) {
        double sum = 0;
        int n = 1;
        sum += 1.0 / (n + 1);
        while (sum < x) {
            n++;
            sum += 1.0 / (n + 1);
        }

        return n + " card(s)";
    }
}
