package Y2014B;

/**
 * @author Hyperspace
 * @date 2022/03/20
 * 可以通过结果反推
 * 正向考虑的话就是原式中最开始为+1， 相当于x多减去了1
 */
public class Q5圆周率 {
    public static void main(String[] args) {
        double x = 111;
        for (int n = 10000; n >= 0; n--) {
            int i = 2 * n + 1;
            x = 2 + (i * i / x);
        }

        System.out.println(String.format("%.4f", 4 / (x - 1))); // 填空
    }
}
