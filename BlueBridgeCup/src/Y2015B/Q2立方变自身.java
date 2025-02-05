package Y2015B;

/**
 * @author Hyper
 * @date 2022/03/23
 */
public class Q2立方变自身 {
    private static int ans = 0;

    public static void main(String[] args) {
        for (int i = 1; i < 10000; i++) {
            int tmp = (int) Math.pow(i, 3);
            if (i == sum(tmp)) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    private static int sum(int n) {
        int ans = 0;
        while (n > 0) {
            ans += (n % 10);
            n /= 10;
        }
        return ans;
    }
}
