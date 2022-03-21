package Y2014B;

/**
 * @author Hyperspace
 * @date 2022/03/20
 * 更保险的方式：
 * 分别比较分子、分组与两个结果的最大公约数的商是否一致
 */
public class Q6奇怪的分式2 {
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
                        int d1 = gcd(i * k, i * 10 + k);
                        int d2 = gcd(j * l, j * 10 + l);
                        if ((i * k) / d1 == (i * 10 + k) / d1 && (j * l) / d2 == (j * 10 + l) / d2) {
                            ans++;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
