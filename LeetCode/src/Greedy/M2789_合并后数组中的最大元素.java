package Greedy;

/**
 * @author Hyperspace
 * @date 2024/03/14
 * @file M2789_合并后数组中的最大元素.java
 * <p>
 * 思路
 * 一开始想到前缀和
 * 由于题干的限制，一旦确定了选定哪个元素，就只能从当前元素向前累加
 * 以贪心的形式，应从最后一个元素开始以期达到最大值
 * 每次与当前元素对比，如果现在已有的右侧元素的和更大，则继续往左吃
 * 如果左侧已经很大了吃不动，则这个值一定比右边所有的都大，就直接从这个元素重新开始往左吃
 */
public class M2789_合并后数组中的最大元素 {
    public long maxArrayValue(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        long ans = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ans = ans >= nums[i] ? ans + nums[i] : nums[i];
        }

        return ans;
    }

    public long maxArrayValue2(int[] nums) {
        int n = nums.length;
        long ans = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ans = ans >= nums[i] ? ans + nums[i] : nums[i];
        }

        return ans;
    }
}
