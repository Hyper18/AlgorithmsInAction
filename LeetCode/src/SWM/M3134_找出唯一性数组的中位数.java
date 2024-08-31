package SWM;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2024/08/27
 * @file M3134_找出唯一性数组的中位数.java
 * <p>
 * 思路
 * 二分+SWM
 */
public class M3134_找出唯一性数组的中位数 {
    int[] nums;
    long tot;

    public int medianOfUniquenessArray(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        tot = ((long) n * (n + 1) / 2 + 1) / 2;

        return binarySearch(0, n);
    }

    private int binarySearch(int low, int high) {
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (check(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }

    private boolean check(int len) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        long cnt = 0;
        for (int l = 0, r = 0; r < n; r++) {
            mp.put(nums[r], mp.getOrDefault(nums[r], 0) + 1);
            while (mp.size() > len) {
                int p = nums[l++];
                mp.put(p, mp.get(p) - 1);
                if (mp.get(p) == 0) {
                    mp.remove(p);
                }
            }
            cnt += r - l + 1;
            if (cnt >= tot) {
                return true;
            }
        }

        return false;
    }
}
