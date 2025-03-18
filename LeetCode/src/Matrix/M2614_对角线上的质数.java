package Matrix;

/**
 * @author Hyper
 * @date 2025/03/18
 * @file M2614_对角线上的质数.java
 * <p>
 * 思路
 * 模拟
 */
public class M2614_对角线上的质数 {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i][i] > ans && isPrime(nums[i][i])) {
                ans = nums[i][i];
            }
            if (nums[i][n - 1 - i] > ans && isPrime(nums[i][n - 1 - i])) {
                ans = nums[i][n - 1 - i];
            }
        }

        return ans;
    }

    private boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return x > 1;
    }
}
