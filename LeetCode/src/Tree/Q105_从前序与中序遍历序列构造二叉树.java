package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2022/02/18
 * 1. 递归 - 遍历
 * 2. 递归 - hash
 * 3. 迭代
 */
public class Q105_从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        int preorder_root = preorder_left;
        TreeNode root = new TreeNode(preorder[preorder_root]);
        int inorder_root = 0;
        for (int i = inorder_left; i <= inorder_right; i++) {
            if (preorder[preorder_root] == inorder[i]) {
                inorder_root = i;
                break;
            }
        }

        int size_left_subtree = inorder_root - inorder_left;

        root.left = build(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        root.right = build(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);

        return root;
    }

    private static Map<Integer, Integer> map;

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return build2(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode build2(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        int preorder_root = preorder_left;
        TreeNode root = new TreeNode(preorder[preorder_root]);
        int inorder_root = map.get(preorder_root);

        int size_left_subtree = inorder_root - inorder_left;

        root.left = build2(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        root.right = build2(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);

        return root;
    }
}
