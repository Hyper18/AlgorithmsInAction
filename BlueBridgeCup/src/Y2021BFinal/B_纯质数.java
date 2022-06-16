package Y2021BFinal;

/**
 * @author Hyperspace
 * @date 2022/06/16
 */
public class B_纯质数 {
    static final int N = (int) 3e7;
    static boolean[] isPrime = new boolean[N];
    static int cnt;

    public static void main(String[] args) {
        for (int i = 2; i <= 20210605; i++) {
            if (isPrime[i]) {
                continue;
            }
            for (int j = i + i; j <= 20210605; j += i) {
                isPrime[j] = true;
            }
            // 比素数筛多了一步，判断是否为题目规定的纯素数
            if (check(i)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean check(int n) {
        while (n > 0) {
            int r = n % 10;
            if (r == 0 || r == 1 || r == 4 || r == 6 || r == 8 || r == 9) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
