package Tree;

/**
 * @author Hyperspace
 * @date 2023/11/25
 * @file M1457_二叉树中的伪回文路径.java
 * <p>
 * 思路
 * dfs
 */
public class M1457_二叉树中的伪回文路径 {
    int[] nums = new int[10];

    public int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode cur, int cnt) {
        int ans = 0;
        nums[cur.val]++;
        if (cur.left != null) {
            ans += dfs(cur.left, cnt + 1);
        }
        if (cur.right != null) {
            ans += dfs(cur.right, cnt + 1);
        }
        if (cur.left == null && cur.right == null) {
            ans += check(cnt + 1) ? 1 : 0;
        }
        nums[cur.val]--;
        return ans;
    }

    private boolean check(int cnt) {
        if (cnt % 2 == 0) {
            for (int x : nums) {
                if (x % 2 != 0) {
                    return false;
                }
            }
        } else {
            int t = 0;
            for (int x : nums) {
                if (x % 2 != 0) {
                    t++;
                }
                if (t > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
