package Array;

/**
 * @author Hyperspace
 * @date 2022/10/24
 * <p>
 * 思路1
 * 找左侧数组的最大值和右侧数组的最小值的分界点位置
 * 逆序，用数组f存放从第i位往后的所有数字的最小值
 * 在从头开始，依次比较此时第i位左侧的最大值是否小于从第i+1位开始所有右侧的值
 * <p>
 * 思路2，来自官解
 * 有没有途径优化遍历的思路，使得只需一次遍历
 * 可同时得到左侧数组的最小值和右侧数组的最大值？
 * 同时记录当前和左侧的最大值及分界点位置
 * 顺序遍历，左侧最大值大于当前值时
 * 将当前值划入左侧，更新分界点
 * 往复直到分界点右侧任意值均大于左侧
 */
public class M915_分割数组 {
    final int N = 100010;
    int[] f = new int[N];

    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        f[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            f[i] = Math.min(f[i + 1], nums[i]);
        }

        int m = 0;
        for (int i = 0; i < n; i++) {
            m = Math.max(m, nums[i]);
            if (m <= f[i + 1]) {
                return i + 1;
            }
        }

        return n;
    }

    public int partitionDisjoint2(int[] nums) {
        int n = nums.length;
        int m = 0, left = nums[0], idx = 0;
        for (int i = 0; i < n; i++) {
            m = Math.max(m, nums[i]);
            if (left > nums[i]) {
                left = m;
                idx = i;
            }
        }

        return idx + 1;
    }
}
