package Greedy;

/**
 * @author Hyperspace
 * @date 2022/03/28
 * 1. dp
 * 2. 状压dp
 * 3. 贪心 -- O(n)
 */
public class Q376_摆动序列 {

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] peeks = new int[n];
        int[] bottoms = new int[n];
        peeks[0] = bottoms[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                peeks[i] = Math.max(peeks[i - 1], bottoms[i - 1] + 1);
                bottoms[i] = bottoms[i - 1];
            } else if (nums[i - 1] < nums[i]) {
                peeks[i] = peeks[i - 1];
                bottoms[i] = Math.max(bottoms[i - 1], peeks[i - 1] + 1);
            } else {
                peeks[i] = peeks[i - 1];
                bottoms[i] = bottoms[i - 1];
            }
        }

        return Math.max(peeks[n - 1], bottoms[n - 1]);
    }

    public int wiggleMaxLength2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int peek = 1;
        int bottom = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                peek = Math.max(peek, bottom + 1);
            } else if (nums[i - 1] < nums[i]) {
                bottom = Math.max(bottom, peek + 1);
            }
        }

        return Math.max(peek, bottom);
    }

    public int wiggleMaxLength3(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int pre = nums[1] - nums[0];
        int ans = pre == 0 ? 1 : 2;
        for (int i = 2; i < n; i++) {
            int cur = nums[i] - nums[i - 1];
            // pre取等处理边界情况
            if ((cur > 0 && pre <= 0) || (cur < 0 && pre >= 0)) {
                ans++;
                pre = cur;
            }
        }

        return ans;
    }
}
