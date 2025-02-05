package BinarySearch;

/**
 * @author Hyper
 * @date 2022/10/26
 * <p>
 * 思路
 * 找到重复数（出现两次或多次）且不能修改数组
 * 由于除了重复数外
 * 任何其他数均出现一次
 * <p>
 * 看似不能排序数组，无法使用二分
 * 实际上巧妙地转化为cnt的单调性
 * 因此对[1, n]，假设重复数为target
 * target左侧有：cnt[i] <= i
 * target右侧有：cnt[i] > i
 * <p>
 * 又由于要求空间复杂度为O(1)，因此只可使用常数级空间
 * 不如就维护一个cnt变量，在每次二分时遍历数组
 * 用于获取当前数组中不大于mid数的数目
 */
public class Q287_寻找重复数 {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int low = 1, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }

            if (cnt <= mid) {
                low = mid + 1;
                // ans = mid;
            } else {
                high = mid - 1;
                // 关于ans为什么放在此处：若在左边界处，则ans取到的是其左侧的值，为nums[target-1]
                ans = mid;
            }
        }

        return ans;
    }
}
