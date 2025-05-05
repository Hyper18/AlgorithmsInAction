package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2025/05/04
 * @file Q257_二叉树的所有路径.java
 * <p>
 * 思路
 * dfs
 */
public class Q257_二叉树的所有路径 {
    class Solution1_0 {
        private List<String> res = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            dfs(root, "");
            return res;
        }

        private void dfs(TreeNode cur, String path) {
            if (cur == null) {
                return;
            }
            path += cur.val;
            if (cur.left == null && cur.right == null) {
                res.add(path);
                return;
            }
            path += "->";
            dfs(cur.left, path);
            dfs(cur.right, path);
        }
    }
}
