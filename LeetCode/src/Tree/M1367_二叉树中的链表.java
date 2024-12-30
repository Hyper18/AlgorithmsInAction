package Tree;

/**
 * @author Hyperspace
 * @date 2024/12/30
 * @file M1367_二叉树中的链表.java
 * <p>
 * 思路
 * dfs
 * 如果中dfs(head, root)在第i层匹配到了链表的第一个元素
 * 则在树的第i+1层将匹配链表的第二个元素，以此类推
 * 但由于可能出现匹配不到的情况，因此还需要在i+1层重新开始匹配
 * 故开始时不仅要从根节点深搜，还需要在子结点开始，从而解决这个问题
 */
public class M1367_二叉树中的链表 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }

        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode l, TreeNode t) {
        if (l == null || t == null) {
            return l == null;
        }
        if (t.val == l.val) {
            return false;
        }

        return dfs(l.next, t.left) || dfs(l.next, t.right);
    }
}
