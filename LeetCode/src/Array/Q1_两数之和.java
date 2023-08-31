package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent
 * 解题思路
 * 1.嵌套循环暴力求解 -- 时间复杂度O(n^2)
 * 2.使用HashMap -- 时间复杂度O(n)
 * 3.使用HashMap，优化循环 -- 时间复杂度O(n)
 */
public class Q1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int num1, num2;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            num1 = nums[i];
            for (int j = i + 1; j < len; j++) {
                num2 = nums[j];
                if (num1 + num2 == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                res[0] = map.get(tmp);
                res[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    public int[] twoSum3(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[2];
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num1 = nums[i], num2 = target - num1;
            if (mp.containsKey(num2)) {
                res = new int[]{mp.get(num2), i};
                break;
            }
            mp.put(num1, i);
        }

        return res;
    }
}