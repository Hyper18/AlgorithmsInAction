package Tree;

/**
 * @author Hyperspace
 * @date 2022/04/23
 */
public class Q108_将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return build(nums, 0, n - 1);
    }

    TreeNode build(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = l + ((r - l) >> 1);
        TreeNode root = new TreeNode(nums[m]);
        root.left = build(nums, l, m - 1);
        root.right = build(nums, m + 1, r);

        return root;
    }
}
