package ref;

/**
 * @author Hyper
 * @date 2022/03/07
 */
public class R19_欧拉筛 {
    private static final int MAXN = 100000;
    private static boolean[] isPrime = new boolean[MAXN];
    private static int[] prime = new int[MAXN];
    static int cnt = 0;

    private void getPrime(int n) {
        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) {
                prime[cnt++] = i;
            }
            for (int j = 0; j < cnt && i * prime[j] <= n; j++) {
                isPrime[i * prime[j]] = true;
                if (i % prime[j] == 0) {
                    break;
                }
            }
        }
    }
}
