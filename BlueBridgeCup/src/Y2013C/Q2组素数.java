package Y2013C;

/**
 * @author Hyperspace
 * @date 2022/03/16
 */
public class Q2组素数 {
    public static void main(String[] args) {
        int[] nums = new int[]{1499, 1949, 4199, 4919, 9149, 9194, 9419, 9491, 9914, 9941};
        int ans = 0;
        for (int num : nums) {
            if (isPrime(num)) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
