package Array;

/**
 * @author Hyper
 * @date 2023/11/13
 * @file M307_区域和检索_数组可修改.java
 * <p>
 * 思路
 * 树状数组
 */
public class M307_区域和检索_数组可修改 {
    class NumArray {
        int[] tree;

        int lowbit(int x) {
            return x & -x;
        }

        int query(int x) {
            int ans = 0;
            for (int i = x; i > 0; i -= lowbit(i)) {
                ans += tree[i];
            }
            return ans;
        }

        void add(int x, int u) {
            for (int i = x; i <= n; i += lowbit(i)) {
                tree[i] += u;
            }
        }

        int[] nums;
        int n;

        public NumArray(int[] nums) {
            this.nums = nums;
            n = nums.length;
            tree = new int[n + 1];
            for (int i = 0; i < n; i++) {
                add(i + 1, nums[i]);
            }
        }

        public void update(int i, int val) {
            add(i + 1, val - nums[i]);
            nums[i] = val;
        }

        public int sumRange(int l, int r) {
            return query(r + 1) - query(l);
        }
    }
}
