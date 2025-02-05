package Y2015B;

/**
 * @author Hyper
 * @date 2022/03/23
 * 暴力模拟即可，很多时候不需要想太多
 * 直接嵌套for循环即可
 */
public class Q3三羊献瑞 {
    public static void main(String[] args) {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k <= 9; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    for (int l = 0; l <= 9; l++) {
                        if (l == i || l == j || l == k) {
                            continue;
                        }
                        for (int m = 1; m <= 9; m++) {
                            if (m == i || m == j || m == k || m == l) {
                                continue;
                            }
                            for (int n = 0; n <= 9; n++) {
                                if (n == i || n == j || n == k || n == l || n == m) {
                                    continue;
                                }
                                for (int o = 0; o <= 9; o++) {
                                    if (o == i || o == j || o == k || o == l || o == m || o == n) {
                                        continue;
                                    }
                                    int left = i * 1000 + j * 100 + k * 10 + l;
                                    int right = m * 1000 + n * 100 + o * 10 + j;
                                    int res = m * 10000 + n * 1000 + k * 100 + j * 10;
                                    for (int idx = 0; idx <= 9; idx++) {
                                        if (idx == i || idx == j || idx == k || idx == l || idx == m || idx == n || idx == o) {
                                            continue;
                                        }
                                        if (res + idx == left + right) {
                                            System.out.println(right);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}