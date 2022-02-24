package SWM;

import java.util.TreeSet;

/**
 * @author Hyperspace
 * @date 2022/02/24
 * <p>
 * 来自官方题解
 * 有序集合，支持添加和删除指定元素的操作，否则无法维护滑动窗口；
 * 内部元素有序，支持二分查找的操作，这样我们可以快速判断滑动窗口中是否存在元素满足条件
 * 具体而言，对于元素 xx，当我们希望判断滑动窗口中是否存在某个数 yy 落在区间 [x - t, x + t]中
 * 判断滑动窗口中所有大于等于 x - t 的元素中的最小元素是否小于等于 x + t
 * <p>
 * 使用长整型 long 防止爆int
 */
public class Q220_存在重复元素III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            Long j = set.ceiling((long) nums[i] - (long) t);
            if (j != null && Math.abs((long) nums[i] - j) <= (long) t) {
                return true;
            }
            set.add((long) nums[i]);

            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }

        return false;
    }
}
