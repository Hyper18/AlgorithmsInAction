package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hyper
 * @date 2022/10/13
 * <p>
 * 思路
 * 1. 中序遍历二叉搜索树
 * 2. 来自官解，记录子树的结点数
 */
public class Q230_二叉搜索树中第K小的元素 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        inorder(cur, res);

        return res.get(k - 1);
    }

    public void inorder(TreeNode cur, List<Integer> res) {
        if (cur != null) {
            inorder(cur.left, res);
            res.add(cur.val);
            inorder(cur.right, res);
        }
    }

    public int kthSmallest2(TreeNode root, int k) {
        MyBST bst = new MyBST(root);

        return bst.kthSmallest(k);
    }
}

class MyBST {
    TreeNode root;
    Map<TreeNode, Integer> nodeNum;

    public MyBST(TreeNode root) {
        this.root = root;
        this.nodeNum = new HashMap<>();
        countNodeNum(root);
    }

    // 统计以node为根结点的子树的结点数
    private int countNodeNum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        nodeNum.put(node, 1 + countNodeNum(node.left) + countNodeNum(node.right));
        return nodeNum.get(node);
    }

    // 获取以node为根结点的子树的结点数
    private int getNodeNum(TreeNode node) {
        return nodeNum.getOrDefault(node, 0);
    }

    // 返回二叉搜索树中第k小的元素
    public int kthSmallest(int k) {
        TreeNode node = root;
        while (node != null) {
            int left = getNodeNum(node.left);
            if (left < k - 1) {
                node = node.right;
                k -= left + 1;
            } else if (left == k - 1) {
                break;
            } else {
                node = node.left;
            }
        }
        return node.val;
    }
}
