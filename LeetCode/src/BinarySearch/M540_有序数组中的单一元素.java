package BinarySearch;

/**
 * @author Hyperspace
 * @date 2022/02/14
 * <p>
 * 思路
 * 二分法，情人节打卡
 * mid为偶数，则前为偶数个元素，则必无单独元素，向后找
 * 后一个元素比较后若相同，可直接跳过
 * 反之若mid为奇数，后也为偶数个元素，向前找
 * 2. 使用异或确保mid为整数
 * 3. 直接使用异或筛选
 */
public class M540_有序数组中的单一元素 {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            int midVal = nums[mid];
            if (mid % 2 == 1) {
                if (nums[mid - 1] != midVal) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid + 1] != midVal) {
                    high = mid;
                } else {
                    low = mid + 2;
                }
            }
        }
        return nums[low];
    }

    public int singleNonDuplicate2(int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            int midVal = nums[mid];
            mid -= mid & 1;
            if (nums[mid + 1] != midVal) {
                high = mid;
            } else {
                low = mid + 2;
            }
        }
        return nums[low];
    }

    public int singleNonDuplicate3(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
