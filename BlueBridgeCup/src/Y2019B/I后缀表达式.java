package Y2019B;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Hyper
 * @date 2022/04/06
 * @time 359ms
 * 一开始想直接排序相减，发现一直不太对，思路有问题
 * <p>
 * 这题主要要注意，
 * 可以通过括号的方式将减去一个数负负为正
 * 例如：3 -（1 - 2） = 4
 * <p>
 * 根据符号数目进行分类讨论：
 * 1. 若全为+号，则直接累加和
 * 2. 若全为-号，根据数据值细分：
 * （1）数值全为正数：max - (min-a1-a2-...-an-2) = 所有数之和 - 2 * min
 * 最小的数 * 2是因为原来的和中加上的，现在减去了，相当于两个结果之间相差两个min，下同
 * （2）数值全为负数：max - min - a1 - a2 - ... - an-2 = 所有数之和的相反数 - 2 * |max|
 * （3）都有（一般情况）：正数 - (负数 - x个正数) - y个负数，即所有数绝对值之和
 * 3. +号-号都有：
 * （1）数值全为正数：max - (min-a1-a2-...-an-2) = 所有数之和 - 2 * min
 * 最小的数 * 2是因为原来的和中加上的，现在减去了，相当于两个结果之间相差两个min，下同
 * （2）数值全为负数：max - min - a1 - a2 - ... - an-2 = 所有数之和的相反数 - 2 * |max|
 * （3）最一般情况：合并，则为所有数绝对值之和 - 2 * min|x|
 * 综上，可合并2、3两种情况，分两类讨论
 * <p>
 * 小结：一道思维过程 >> 实现的题目，最好动手先写一写几种情况，再实现
 */
public class I后缀表达式 {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer tk = new StringTokenizer("");
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        int len = n + m + 1;
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = nextInt();
        }

        long min = Arrays.stream(a).min().getAsInt();
        long max = Arrays.stream(a).max().getAsInt();
        boolean haveNeg = min < 0;
        boolean havePos = max > 0;
        long ans = 0;
        long sum = 0;
        for (int num : a) {
            sum += num;
        }
        if (m == 0) {
            ans = sum;
        } else {
            if (!haveNeg && havePos) {
                ans = sum - 2 * min;
            } else if (haveNeg && !havePos) {
                ans = -sum - 2 * Math.abs(max);
            } else {
                for (int num : a) {
                    ans += Math.abs(num);
                }
            }
        }

        out.println(ans);

        close();
    }

    public static int nextInt() throws IOException {
        while (!tk.hasMoreTokens()) {
            tk = new StringTokenizer(in.readLine());
        }

        return Integer.parseInt(tk.nextToken());
    }

    public static void close() throws IOException {
        in.close();
        out.close();
    }
}
