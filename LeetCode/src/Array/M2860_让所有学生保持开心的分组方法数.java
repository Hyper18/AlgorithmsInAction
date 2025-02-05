package Array;

import java.util.Comparator;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/09/04
 * @file M2860_让所有学生保持开心的分组方法数.java
 * <p>
 * 思路
 * 排序
 * 对每个选中的数，被选中的数目之和总是大于它的值
 * 对未选中的数，被选中的数目之和也总是小于它的值
 * 由于此时nums具有单调性，因此
 * 只要最小的已选中数i的值比cnt大，且最大的未选中数i-1的值比cnt小
 * <p>
 * 特判：
 * 都选 一定可行
 * 都不选 可行需最小数大于0
 */
public class M2860_让所有学生保持开心的分组方法数 {
    public int countWays(List<Integer> nums) {
        int n = nums.size();
        nums.sort(Comparator.comparingInt(a -> a));
        int ans = 1;
        for (int i = n - 1; i > 0; i--) {
            if (nums.get(i) > i && nums.get(i - 1) < i) {
                ans++;
            }
        }

        return nums.get(0) > 0 ? ans + 1 : ans;
    }
}
