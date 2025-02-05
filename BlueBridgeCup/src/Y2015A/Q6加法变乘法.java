package Y2015A;

/**
 * @author Hyper
 * @date 2022/03/21
 */
public class Q6加法变乘法 {
    public static void main(String[] args) {
        int ans = 0;
        for (int i = 1; i <= 49; i++) {
            ans += i;
        }
        for (int i = 1; i <= 46; i++) {
            for (int j = i + 2; j <= 48; j++) {
                if (i * (i + 1) - (i + (i + 1)) + j * (j + 1) - (j + (j + 1)) == 2015 - ans) {
                    System.out.printf("%d %d\n", i, j);
                }
            }
        }
    }
}
