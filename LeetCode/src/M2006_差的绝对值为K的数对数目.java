import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent
 * 小结
 * 1. 暴力解法,two sum思路 -- 小数据量
 * 2. HashMap做法 --  大数据量
 */
public class M2006_差的绝对值为K的数对数目 {
    public int countKDifference(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int res = Math.abs(nums[i] - nums[j]);
                if (res == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int countKDifference2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;

        for (int num : nums) {
            // getOrDefault解决第一下没有值
            cnt += map.getOrDefault(num + k, 0);
            cnt += map.getOrDefault(num - k, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return cnt;
    }
}
