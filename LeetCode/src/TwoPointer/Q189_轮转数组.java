package TwoPointer;

/**
 * @author Hyper
 * @date 2022/02/12
 * 思路
 * 双指针 --  O(n)
 * 使用部分额外数组保留原数组需要更改的数据
 * 注意k可以比数组长度更大，可采用取余处理
 */
public class Q189_轮转数组 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len < k) {
            k = k % len;
        }
        int p1 = 0;
        int p2 = len - k;
        int[] ans = new int[p2];
        for (int i = 0; i < p2; i++) {
            ans[i] = nums[i];
        }
        for (int idx = 0; idx < len; idx++) {
            if (p2 < len) {
                nums[idx] = nums[p2++];
            } else {
                nums[idx] = ans[p1++];
            }
        }
    }

    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        if (len < k) {
            k = k % len;
        }
        int p = len - k;
        int[] ans = new int[p];
        System.arraycopy(nums, 0, ans, 0, p);
        for (int i = 0; p < len; i++) {
            nums[i] = nums[p++];
        }
        System.arraycopy(ans, 0, nums, k, len - k);
    }
}
