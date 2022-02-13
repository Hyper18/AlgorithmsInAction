package TwoPointer;

/**
 * @author Hyperspace
 * @date 2022/02/13
 * <p>
 * 思路
 * 双指针，利用数组按序条件，从两侧开始查找
 */
public class Q167_两数之和II输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
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
}
