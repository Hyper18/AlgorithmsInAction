import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent
 * 解题思路
 * 1.嵌套循环暴力求解，算法复杂度为O(n^2)
 * 2.使用Hashmap，算法复杂度为O(n)
 */
public class Q1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        int num1, num2;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            num1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                num2 = nums[j];
                if (num1 + num2 == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[0] = map.get(temp);
                res[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}