package Array;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Hyperspace
 * @date 2024/10/16
 * @file M3194_最小元素和最大元素的最小平均值.java
 */
public class M3194_最小元素和最大元素的最小平均值 {
    public double minimumAverage(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        TreeSet<Double> st = new TreeSet<>();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            st.add(0.5 * (nums[i] + nums[j]));
        }

        return st.first();
    }

    public double minimumAverage2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        double ans = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, 0.5 * (nums[i] + nums[n - 1 - i]));
        }

        return ans;
    }
}
