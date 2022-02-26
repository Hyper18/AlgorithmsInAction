package Array;

/**
 * @author Hyperspace
 * @date 2022/02/26
 * <p>
 * 思路
 * 1. 暴力 -- O(n^3)
 * 2. 前缀和 -- O(n^2)
 */
public class Q1588_所有奇数长度子数组的和 {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int start = 0; start < n; start++) {
            for (int length = 1; start + length <= n; length += 2) {
                for (int i = start; i < start + length; i++) {
                    sum += arr[i];
                }
            }
        }

        return sum;
    }

    public int sumOddLengthSubarrays2(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        int sum = 0;
        for (int start = 0; start < n; start++) {
            for (int len = 1; start + len <= n; len += 2) {
                sum += prefixSum[start + len] - prefixSum[start];
            }
        }

        return sum;
    }
}
