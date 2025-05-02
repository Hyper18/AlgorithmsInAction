package Tree;

/**
 * @author Hyperspace
 * @date 2025/05/02
 * @file Q2096_从二叉树一个节点到另一个节点每一步的方向.java
 * <p>
 * 思路
 * 两次dfs，去相同前缀
 * <p>
 * 一开始容易考虑找 st 和 ed 的公共祖先
 * 但实际上找到后也需要再 dfs 两次路径
 * 不如直接从根节点开始找
 */
public class Q2096_从二叉树一个节点到另一个节点每一步的方向 {
    private String path;
    private StringBuilder sb = new StringBuilder();

    public String getDirections(TreeNode root, int startValue, int destValue) {
        dfs(root, startValue);
        char[] cs1 = path.toCharArray();
        sb = new StringBuilder();
        dfs(root, destValue);
        char[] cs2 = path.toCharArray();
        int m = cs1.length, n = cs2.length;
        int idx = 0;
        while (idx < Math.min(m, n) && cs1[idx] == cs2[idx]) {
            idx++;
        }
        sb = new StringBuilder();
        for (int i = 0; i < m - idx; i++) {
            sb.append("U");
        }

        return sb.append(new String(cs2).substring(idx)).toString();
    }

    public boolean dfs(TreeNode root, int target) {
        if (root.val == target) {
            path = sb.toString();
            return true;
        }
        if (root.left != null) {
            sb.append("L");
            if (dfs(root.left, target)) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        if (root.right != null) {
            sb.append("R");
            if (dfs(root.right, target)) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
        }

        return false;
    }
}
