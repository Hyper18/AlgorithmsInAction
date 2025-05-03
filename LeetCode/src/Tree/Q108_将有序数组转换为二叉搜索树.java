package Tree;

/**
 * @author Hyper
 * @date 2022/04/23，2025/05/03
 * <p>
 * 思路
 * dfs
 * 中序遍历建树
 */
public class Q108_将有序数组转换为二叉搜索树 {
    private int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return inorder(0, nums.length - 1);
    }

    TreeNode inorder(int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + ((r - l) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = inorder(l, mid - 1);
        root.right = inorder(mid + 1, r);

        return root;
    }
}
