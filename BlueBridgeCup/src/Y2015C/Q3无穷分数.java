package Y2015C;

/**
 * @author Hyperspace
 * @date 2022/03/24
 * 注意最后一位需要四舍五入
 */
public class Q3无穷分数 {
    private static double ans;

    public static void main(String[] args) {
        f(0);
        System.out.printf("%.6f\n", ans);
    }

    private static double f(int step) {
        if (step >= 100) {
            return ans;
        }
        return ans = step + ((1 + step) / f(step + 1));
    }
}
