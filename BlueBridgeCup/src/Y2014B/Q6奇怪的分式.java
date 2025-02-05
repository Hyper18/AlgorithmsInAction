package Y2014B;

/**
 * @author Hyper
 * @date 2022/03/20
 * 注意：这里必须强转类型！！
 * 原因：整数除法的精度不足
 */
public class Q6奇怪的分式 {
    static int ans = 0;

    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        if (l == k) {
                            continue;
                        }
                        double res1 = (double) (i * k) / (j * l);
                        double res2 = (double) (i * 10 + k) / (j * 10 + l);
                        if (res1 == res2) {
                            ans++;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
