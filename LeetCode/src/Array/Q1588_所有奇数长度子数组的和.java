package Array;

/**
 * @author Hyper
 * @date 2022/02/26
 * <p>
 * 思路
 * 1. 暴力 -- O(n^3)
 * 2. 前缀和 -- O(n^2)
 * 以空间换时间，先通过相同长度的数组依次存储前缀和
 * 将计算每个子数组的和的时间复杂度从 O(n) 降低到 O(1)
 * 再遍历获取每个奇数长子数组的和的值
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
