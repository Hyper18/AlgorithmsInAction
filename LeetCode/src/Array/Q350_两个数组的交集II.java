package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2022/02/13
 * <p>
 * 思路
 * 1. 哈希表 -- O(m+n)
 * 记录数组1次数，顺次输出数组2中也出现的元素
 * 2. 双指针 -- O(mlogm+nlogn)
 */
public class Q350_两个数组的交集II {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[nums1.length];
        int idx = 0;
        for (int num : nums2) {
            int cnt = map.getOrDefault(num, 0);
            if (cnt > 0) {
                res[idx++] = num;
                cnt--;
                if (cnt == 0) {
                    map.remove(num);
                } else {
                    map.put(num, cnt);
                }
            }
        }

        return Arrays.copyOf(res, idx);
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[Math.min(len1, len2)];
        int p1 = 0;
        int p2 = 0;
        int idx = 0;
        while (p1 < len1 && p2 < len2) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                res[idx++] = nums1[p1++];
                p2++;
            }
        }

        return Arrays.copyOfRange(res, 0, idx);
    }
}
