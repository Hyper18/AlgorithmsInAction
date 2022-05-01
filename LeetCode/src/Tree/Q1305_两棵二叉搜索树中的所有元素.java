package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2022/05/01
 * <p>
 * 思路
 * 中序遍历 + 归并排序（双指针）
 * 二叉排序树
 * 同一颗树 左子树 < 根 < 右子树 --> 采用中序遍历
 * <p>
 * API
 * subList(int beginIndex, endIndex)
 * 可用于直接获取子列表（类似字符串处理substring()）
 */
public class Q1305_两棵二叉搜索树中的所有元素 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        inorder(root1, res1);
        inorder(root2, res2);

        return merge(res1, res2);
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    private List<Integer> merge(List<Integer> res1, List<Integer> res2) {
        List<Integer> res = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (true) {
            if (p1 == res1.size()) {
                res.addAll(res2.subList(p2, res2.size()));
                break;
            }
            if (p2 == res2.size()) {
                res.addAll(res1.subList(p1, res1.size()));
                break;
            }
            if (res1.get(p1) <= res2.get(p2)) {
                res.add(res1.get(p1++));
            } else {
                res.add(res2.get(p2++));
            }
        }

        return res;
    }
}
