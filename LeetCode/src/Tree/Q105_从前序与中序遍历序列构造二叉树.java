package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hyperspace
 * @date 2022/02/18
 * 1. 递归 - 遍历
 * 2. 递归 - hash优化
 * 通过hashmap记录val-idx的对应关系
 */
public class Q105_从前序与中序遍历序列构造二叉树 {
    private int[] preorder;
    private int[] inorder;

    private void init(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        init(preorder, inorder);
        int n = preorder.length;
        return build(0, n - 1, 0, n - 1);
    }

    private TreeNode build(int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        init(preorder, inorder);

        int preorderRoot = preLeft;
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        int inorderRoot = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (preorder[preorderRoot] == inorder[i]) {
                inorderRoot = i;
                break;
            }
        }

        int leftSubtreeSize = inorderRoot - inLeft;

        root.left = build(preLeft + 1, preLeft + leftSubtreeSize, inLeft, inorderRoot - 1);
        root.right = build(preLeft + leftSubtreeSize + 1, preRight, inorderRoot + 1, inRight);

        return root;
    }

    private static Map<Integer, Integer> map;

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        init(preorder, inorder);
        map = new HashMap<>();
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return build2(0, n - 1, 0, n - 1);
    }

    private TreeNode build2(int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        int preorderRoot = preorderLeft;
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        int inorderRoot = map.get(preorderRoot);

        int leftSubtreeSize = inorderRoot - inorderLeft;

        root.left = build2(preorderLeft + 1, preorderLeft + leftSubtreeSize, inorderLeft, inorderRoot - 1);
        root.right = build2(preorderLeft + leftSubtreeSize + 1, preorderRight, inorderRoot + 1, inorderRight);

        return root;
    }
}
