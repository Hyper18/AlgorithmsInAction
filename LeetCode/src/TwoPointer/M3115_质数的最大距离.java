package TwoPointer;

/**
 * @author Hyper
 * @date 2024/07/02
 * @file M3115_质数的最大距离.java
 * <p>
 * 思路
 * 双指针，模拟
 * 注意1既不是素数也不是合数
 */
public class M3115_质数的最大距离 {
    public int maximumPrimeDifference(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (!isPrime(nums[l])) {
            l++;
        }
        while (!isPrime(nums[r])) {
            r--;
        }

        return r - l;
    }

    private boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
