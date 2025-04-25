package Tree;

/**
 * @author Hyper
 * @date 2025/04/25
 * @file Q2265_统计值等于子树平均值的节点数.java
 */
public class Q2265_统计值等于子树平均值的节点数 {
    private int sum, ans;

    public int averageOfSubtree(TreeNode root) {
        f(root);
        return ans;
    }

    private void f(TreeNode cur) {
        if (cur == null) {
            return;
        }
        sum = 0;
        int cnt = dfs(cur);
        if (sum / cnt == cur.val) {
            ans++;
        }
        f(cur.left);
        f(cur.right);
    }

    private int dfs(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        sum += cur.val;
        return 1 + dfs(cur.left) + dfs(cur.right);
    }

    private int cnt = 0;

    public int averageOfSubtree2(TreeNode root) {
        dfs2(root);
        return cnt;
    }

    private int[] dfs2(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs2(root.left), r = dfs2(root.right);
        int sum = l[0] + r[0] + root.val;
        int n = l[1] + r[1] + 1;
        if (sum / n == root.val) {
            cnt++;
        }

        return new int[]{sum, n};
    }
}
