package DP;

/**
 * @author Hyperspace
 * @date 2022/10/09
 * <p>
 * 思路
 * 回顾一下LIS问题的经典做法
 * 1. 状态表示
 * 集合：f[i]表示的是所有以第i个元素结尾的LIS
 * 属性：Max
 * 2. 状态计算
 * 状态转移方程 f[i] = max(f[i], f[j] + 1)
 * <p>
 * 上述做法的复杂度为O(n^2)
 * 应用贪心法，降至O(n*log_n)中指数级复杂度则需要二分处理
 * 具体而言，每次要不断更新长度为 [1,k] 的子序列尾部元素值
 * 并始终保持每个尾部元素值最小
 * 在每轮实际计算时，采用二分法在列表f搜索nums[i]的位置
 * <p>
 * 注：因为列表f是严格递增的，故才可以采用二分进行优化
 * 代表较短子序列的尾部元素的值 < 较长子序列的尾部元素的值
 */
public class Q300_最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] f = new int[len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }

        return ans;
    }

    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        int[] f = new int[len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            // 指定二分的遍历区间为[0， ans)
            int low = 0, high = ans;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (f[mid] < nums[i]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            f[low] = nums[i];
            // 判断是否是接到序列最后
            if (ans == high) {
                ans++;
            }
        }

        return ans;
    }
}
