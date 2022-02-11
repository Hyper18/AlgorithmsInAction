package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyperspace
 * @date 2022/02/11
 * 思路
 * Set去重
 * 通过插入返回值判断，false就直接返回了
 */
public class Q217_存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        Set res = new HashSet<Integer>();
        for (int i : nums) {
            boolean flag = res.add(i);
            if (!flag) {
                return true;
            }
        }
        return false;
    }
}
