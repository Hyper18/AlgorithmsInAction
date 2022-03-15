package Y2013B;

/**
 * @author Hyperspace
 * @date 2022/03/15
 */
public class Q2马虎的算式 {
    public static void main(String[] args) {
        int ans = 0;
        for (int a = 1; a < 10; a++) {
            for (int b = 1; b < 10; b++) {
                if (b == a) {
                    continue;
                }
                for (int c = 1; c < 10; c++) {
                    if (c == b || c == a) {
                        continue;
                    }
                    for (int d = 1; d < 10; d++) {
                        if (d == c || d == b || d == a) {
                            continue;
                        }
                        for (int e = 1; e < 10; e++) {
                            if (e == d || e == c || e == b || e == a) {
                                continue;
                            }
                            int left = (a * 10 + b) * (c * 100 + d * 10 + e);
                            int right = (a * 100 + d * 10 + b) * (c * 10 + e);
                            if (left == right) {
                                // System.out.printf("%d %d %d %d %d\n", a, b, c, d, e);
                                ans++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
