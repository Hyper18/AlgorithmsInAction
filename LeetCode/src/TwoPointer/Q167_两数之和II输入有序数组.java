package TwoPointer;

/**
 * @author Hyper
 * @date 2022/02/13，2022/10/29，2023/07/08，2025/03/21
 * <p>
 * 思路
 * 1. 相向双指针 -- O(n)
 * 利用数组按序条件，从两侧开始查找
 * 2. 二分 -- O(nlog_n)
 * 先固定一端，再从右侧首个数开始找第二个数
 */
public class Q167_两数之和II输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }

        return new int[]{};
    }

    public int[] twoSum2(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n - 1, t = target - numbers[i];
            while (low <= high) {
                int mid = low + ((high - low) >> 1), midVal = numbers[mid];
                if (midVal == t) {
                    return new int[]{i + 1, mid + 1};
                } else if (midVal > t) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return new int[]{};
    }
}
