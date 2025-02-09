package TwoPointer;

/**
 * @author Hyper
 * @date 2022/02/12，2025/02/09
 * 思路
 * 1. 双指针 -- O(n)
 * 使用部分额外数组保留原数组需要更改的数据
 * 注意k可以比数组长度更大，可采用取余处理
 * 2. copy数组
 * 能否不额外开一个数组？
 * 3. 原地模拟 -- TLE O(n^2)，使用O(1)额外空间
 * 4. 原地模拟，旋转3次@灵茶山艾府 -- O(n)，使用O(1)额外空间
 */
public class Q189_轮转数组 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int p1 = 0, p2 = n - k;
        int[] res = new int[p2];
        for (int i = 0; i < p2; i++) {
            res[i] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = p2 < n ? nums[p2++] : res[p1++];
        }
    }

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int i = 0, p = n - k;
        int[] res = new int[p];
        System.arraycopy(nums, 0, res, 0, p);
        while (p < n) {
            nums[i++] = nums[p++];
        }
        System.arraycopy(res, 0, nums, k, n - k);
    }

    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        while (k-- > 0) {
            int t = nums[0];
            for (int i = n; i > 1; i--) {
                nums[i % n] = nums[i - 1];
            }
            nums[1] = t;
        }
    }

    public void rotate4(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] a, int i, int j) {
        for (; i < j; i++, j--) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }
}
