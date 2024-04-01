package DP;

/**
 * @author Hyperspace
 * @date 2024/03/01
 * @file M2369_检查数组是否存在有效划分.java
 * <p>
 * 思路
 * 状态机
 * 1. 状态表示
 * 集合：f[i]表示能有效划分[0, i - 1]
 * 属性：cnt
 * 2. 状态计算
 * 分类讨论，有：
 * 1) nums[i] = nums[i - 1]
 * f[i + 1] = f[i - 1] && nums[i] == nums[i - 1]
 * 2) nums[i] = nums[i - 1] = nums[i - 2]
 * f[i + 1] = i > 1 && f[i - 2] && (nums[i] == nums[i - 1]) && (nums[i] == nums[i - 2])
 * 3) nums[i] = nums[i - 1] + 1 = nums[i - 2] + 2
 * f[i + 1] = i > 1 && f[i - 2] && nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2
 */
public class M2369_检查数组是否存在有效划分 {
    int[] nums;
    boolean[] f;
    int n;

    private void init(int[] nums) {
        this.nums = nums;
        n = nums.length;
        f = new boolean[n + 1];
        f[0] = true;
    }

    public boolean validPartition(int[] nums) {
        init(nums);
        for (int i = 1; i < n; i++) {
            if (f[i - 1] && con1(i) || i > 1 && f[i - 2] && (con2(i) || con3(i))) {
                f[i + 1] = true;
            }
        }

        return f[n];
    }

    private boolean con1(int i) {
        return nums[i] == nums[i - 1];
    }

    private boolean con2(int i) {
        return nums[i] == nums[i - 1] && nums[i] == nums[i - 2];
    }

    private boolean con3(int i) {
        return nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2;
    }
}
