package train;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hyperspace
 * @date 2022/03/02
 * <p>
 * 思路
 * 使用一个主函数内的内部类表示prut结构体
 */
public class ALGO_140 {

    public static void main(String[] args) {
        class prut {
            String mc;
            double dj;
            int sl;

            public prut(String mc, double dj, int sl) {
                super();
                this.mc = mc;
                this.dj = dj;
                this.sl = sl;
            }

            public double getDj() {
                return dj;
            }

            public int getSl() {
                return sl;
            }
        }
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = in.nextInt();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            prut p = new prut(in.next(), in.nextDouble(), in.nextInt());
            sum += p.getDj() * p.getSl();
        }

        out.printf("%.6f", sum);

        in.close();
        out.close();
    }
}
