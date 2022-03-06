package Competition.Com283;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2022/03/06
 */
public class Q6017_向数组中追加K个整数 {
    public long minimalKSum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int i = 1;
        long ans = 0;
        while (k > 0) {
            if (map.get(i) == null) {
                ans += i;
                k--;
            }
            i++;
        }

        return ans;
    }
}
