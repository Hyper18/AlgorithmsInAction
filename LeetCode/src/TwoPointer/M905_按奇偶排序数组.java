package TwoPointer;

/**
 * @author Hyper
 * @date 2022/04/28
 * <p>
 * 思路
 * 1. 双指针，模拟
 * 分别用两个指针指向数组的头尾，
 * 对于前面的元素，不为偶数，则与后面的元素作一次交换，移动尾指针
 * 对于后面的元素，不为奇数，则与前面的元素作一次交换，移动头指针
 * 符合，则同时向中央遍历
 * 2. 位运算优化
 */
public class M905_按奇偶排序数组 {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low < high) {
            if (nums[low] % 2 != 0) {
                int tmp = nums[low];
                nums[low] = nums[high];
                nums[high] = tmp;
                high--;
            } else if (nums[high] % 2 == 0) {
                int tmp = nums[low];
                nums[low] = nums[high];
                nums[high] = tmp;
                low++;
            } else {
                low++;
                high--;
            }
        }

        return nums;
    }

    public int[] sortArrayByParity2(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low < high) {
            if ((nums[low] & 1) != 0) {
                int tmp = nums[low];
                nums[low] = nums[high];
                nums[high] = tmp;
                high--;
            } else if ((nums[high] & 1) == 0) {
                int tmp = nums[low];
                nums[low] = nums[high];
                nums[high] = tmp;
                low++;
            } else {
                low++;
                high--;
            }
        }

        return nums;
    }
}
