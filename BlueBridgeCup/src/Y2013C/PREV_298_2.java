package Y2013C;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Hyperspace
 * @date 2022/03/16
 * @time 109ms
 * 使用朴素做法
 * 即首先将三数相乘
 * 再通过迭代遍历的方式
 * 寻找能够同时将三数同时整除的最小整数
 * 是为其最小公倍数
 * <p>
 * 由于没有递归，数值较小时速度还是快于前一种的
 */
public class PREV_298_2 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer token = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();

        int max = a * b * c;
        for (int i = 1; i <= max; i++) {
            if (i % a == 0 && i % b == 0 && i % c == 0) {
                out.println(i);
                break;
            }
        }

        close();
    }

    public static int nextInt() throws IOException {
        while (!token.hasMoreTokens()) {
            token = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(token.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
