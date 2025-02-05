package Tree;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hyper
 * @date 2024/03/12
 * @file M1261_在受污染的二叉树中查找元素.java
 * <p>
 * 思路
 * dfs，注意题干给出root.val均为0
 * <p>
 * 一开始考虑要不要先建树，发现没有必要
 * 只需要对处理后的值做判断即可
 */
public class M1261_在受污染的二叉树中查找元素 {
    class FindElements {
        Set<Integer> set;

        public FindElements(TreeNode root) {
            set = new HashSet<>();
            dfs(root, 0);
        }

        private void dfs(TreeNode root, int x) {
            if (root == null) {
                return;
            }
            root.val = x;
            set.add(x);
            dfs(root.left, 2 * x + 1);
            dfs(root.right, 2 * x + 2);
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }

    /**
     * Your FindElements object will be instantiated and called as such:
     * FindElements obj = new FindElements(root);
     * boolean param_1 = obj.find(target);
     */
}
