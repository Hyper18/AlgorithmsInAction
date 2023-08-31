package Array;

/**
 * @author Hyperspace
 * @date 2022/02/13，2022/10/29，2023/07/08
 * <p>
 * 思路
 * 1. 双指针，利用数组按序条件，从两侧开始查找
 * 2. 二分，先固定一端，再从右侧首个数开始找第二个数
 */
public class Q167_两数之和II输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum > target) {
                high--;
            } else {
                low++;
            }
        }

        return new int[]{-1, -1};
    }

    public int[] twoSum2(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int curTarget = target - numbers[i];
                if (numbers[mid] == curTarget) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > curTarget) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return new int[]{-1, -1};
    }

    public int[] twoSum3(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n - 1;
            while (low <= high) {
                int mid = low + ((high - low) >> 1), tmp = target - numbers[i];
                if (numbers[mid] == tmp) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > tmp) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return new int[]{-1, -1};
    }
}
