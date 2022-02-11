package BinarySearch;

/**
 * @author Hyperspace
 * @date 2022/02/11
 * 思路
 * 题目已指定算法的时间复杂度为 O(log n),，数组无重复元素、升序 -> BinarySearch
 * 重点：未找到，返回按序插入位置
 */
public class Q35_搜索插入位置 {
    public static void main(String[] args) {
        searchInsert(new int[]{1, 3, 5, 6}, 7);
    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];

            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return low;
    }
}
