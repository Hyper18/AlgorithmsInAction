package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2022/02/18
 */
public class Q94_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);

        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root != null) {
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);
        }
    }
}
